package com.example.appthitracnghiem.Activitys;

import android.content.ContentValues;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appthitracnghiem.Adapters.GrdKetQuaThiAdapter;
import com.example.appthitracnghiem.Adapters.LstKetQuaThiAdapter;
import com.example.appthitracnghiem.Commons.Common;
import com.example.appthitracnghiem.ConfigDB.Database;
import com.example.appthitracnghiem.Model.ChiTietBaiLam;
import com.example.appthitracnghiem.Model.KetQua;
import com.example.appthitracnghiem.R;

import java.util.List;

public class KetQuaActivity extends AppCompatActivity {

    private ViewStub stubGrid;
    private ViewStub stubList;

    private List<ChiTietBaiLam> chiTietBaiLam;
    private int currentViewMode = 0;

    private double DiemBaiThi;
    private static final int VIEW_MODE_GRIDVIEW = 0;
    private static final int VIEW_MODE_LISTVIEW = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ket_qua);


        stubList = findViewById(R.id.stub_list);
        stubGrid = findViewById(R.id.stub_grid);

        stubGrid.inflate();

        switchView();
        addControlsInfor();
        //Insert kq thi vào CSDL
        insertDBketquathi();
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        AlertDialog.Builder dialog = new AlertDialog.Builder(KetQuaActivity.this);
        dialog.setTitle("Thông báo");
        dialog.setMessage("Bạn sẽ không thể xem lại. Bạn chắc chắn muốn rời đi ?");
        dialog.setIcon(R.drawable.warning);

        dialog.setPositiveButton("Có", (dialogInterface, i) ->
                startActivity(new Intent(KetQuaActivity.this, LichSuThiActivity.class)));
        dialog.setNegativeButton("Không", (dialogInterface, i) -> {});
        dialog.show();
    }



    private void addControlsInfor() {
        TextView txtDeThi = findViewById(R.id.txtDeThi);
        TextView txtThoiGianLamBai = findViewById(R.id.txtThoiGianLam);
        TextView txtSoCauDung = findViewById(R.id.txtSoCauDung);
        TextView txtDiem = findViewById(R.id.txtDiem);
        TextView txtTenHS = findViewById(R.id.tv_TenHocSinh);

        int minutes = Common.THOI_GIAN_LAM_BAI / 60;
        int seconds = Common.THOI_GIAN_LAM_BAI - (minutes * 60);
        String secondsString = Integer.toString(seconds);
        if (seconds <= 9) {
            secondsString = "0" + secondsString;
        }
        txtDeThi.setText("Đề thi: " + Common.TEN_DE_THI);
        txtThoiGianLamBai.setText("Thời gian làm bài: " + minutes + ":" + secondsString);
        txtSoCauDung.setText("Số câu đúng: " + Common.SO_CAU_DUNG + "/" + chiTietBaiLam.size());
        txtTenHS.setText("Tên học sinh: " + Common.TEN_HOC_SINH);
        DiemBaiThi = Math.round((Common.SO_CAU_DUNG * 1.0 / chiTietBaiLam.size() * 10) * 100.0) / 100.0;
        txtDiem.setText("Điểm: " + (DiemBaiThi));

    }


    public void switchLayout(View view) {
        if (VIEW_MODE_GRIDVIEW == currentViewMode) {
            currentViewMode = VIEW_MODE_LISTVIEW;
        } else {
            currentViewMode = VIEW_MODE_GRIDVIEW;
        }
        switchView();
    }

    private void switchView() {
        ImageView switchIcon = findViewById(R.id.switchIcon);
        if (VIEW_MODE_GRIDVIEW == currentViewMode) {
            switchIcon.setImageResource(R.drawable.ic_grid_t);
            stubGrid.setVisibility(View.VISIBLE);
            stubList.setVisibility(View.GONE);

            addControlsGrd();
        } else {

            switchIcon.setImageResource(R.drawable.ic_list_t);
            stubGrid.setVisibility(View.GONE);
            stubList.setVisibility(View.VISIBLE);

            addControlsLst();
        }
    }

    private void addControlsLst() {
        ListView listView = findViewById(R.id.lstKetQuaThi);
        chiTietBaiLam = LstKetQuaThiAdapter.getLstChiTietBaiLam();
        LstKetQuaThiAdapter lstKetQuaThiAdapter = new LstKetQuaThiAdapter(
                KetQuaActivity.this, R.layout.item_list_ketquathi_t, chiTietBaiLam);

        listView.setAdapter(lstKetQuaThiAdapter);
    }

    private void addControlsGrd() {
        GridView gridView = findViewById(R.id.grdKetQuaThi);
        chiTietBaiLam = GrdKetQuaThiAdapter.getLstChiTietBaiLam();
        GrdKetQuaThiAdapter grdKetQuaThiAdapter = new GrdKetQuaThiAdapter(
                KetQuaActivity.this, R.layout.item_grid_ketquathi_t, chiTietBaiLam);

        gridView.setAdapter(grdKetQuaThiAdapter);
    }

    private void insertDBketquathi() {

        KetQua ketQua = new KetQua(Common.IDDETHI, Common.ID_HOCSINH, DiemBaiThi);
        ContentValues contentValues = new ContentValues();
        contentValues.put("IDDeThi", ketQua.getIDDeThi());
        contentValues.put("IDHocSinh", ketQua.getIDHocSinh());
        contentValues.put("Diem", DiemBaiThi);

        try {
            SQLiteDatabase db = Database.initDatabase(KetQuaActivity.this, Common.DATABASE_NAME);
            db.insert("KetQua", null, contentValues);
            db.close();
        } catch (SQLException e) {
            Toast.makeText(KetQuaActivity.this, "Lỗi kết nối tới CSDL", Toast.LENGTH_SHORT).show();
        }
    }
}