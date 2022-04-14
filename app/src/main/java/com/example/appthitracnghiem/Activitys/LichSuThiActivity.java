package com.example.appthitracnghiem.Activitys;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appthitracnghiem.Adapters.LichSuThiAdapters;
import com.example.appthitracnghiem.Commons.Common;
import com.example.appthitracnghiem.ConfigDB.Database;
import com.example.appthitracnghiem.Model.LichSuThi;
import com.example.appthitracnghiem.R;

import java.util.ArrayList;
import java.util.List;

public class LichSuThiActivity extends AppCompatActivity {

    private TextView txtAlertLST;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_su_thi);

        addConTrolsLst();
    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Thông báo");
        dialog.setMessage("Bạn chắc chắn muốn thoát?");
        dialog.setIcon(R.drawable.warning);

        dialog.setPositiveButton("Có", (dialogInterface, i) -> finishAffinity());
        dialog.setNegativeButton("Không", (dialogInterface, i) -> {
        });
        dialog.show();
    }

    private void addConTrolsLst() {
        txtAlertLST = findViewById(R.id.txtAlertLST);
        ListView lstView = findViewById(R.id.lstLichSuThi);
        LichSuThiAdapters lichSuThiAdapters = new LichSuThiAdapters(
                this, R.layout.item_lich_su_thi_t, getLichSuThiList());

        lstView.setAdapter(lichSuThiAdapters);

    }


    private List<LichSuThi> getLichSuThiList() {
        List<LichSuThi> listLichSuThi = new ArrayList<>();
        try {
            SQLiteDatabase db = Database.initDatabase(this, Common.DATABASE_NAME);
            Cursor cursor = db.rawQuery("SELECT dt.TenDeThi, kq.Diem, mt.TenMon " +
                    "FROM KetQua kq, DeThi dt, HocSinh hs, MonThi mt " +
                    "WHERE kq.IDHocSinh=hs.IDHocSinh AND kq.IDDeThi=dt.IDDeThi " +
                    "AND dt.IDMonThi=mt.IDMonThi", null);

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                LichSuThi lichSuThi = new LichSuThi(
                        cursor.getString(0), cursor.getDouble(1), cursor.getString(2));
                listLichSuThi.add(lichSuThi);
                cursor.moveToNext();
            }
            cursor.close();
        } catch (SQLException e) {
            Toast.makeText(this, "Lỗi kết nối tới CSDL", Toast.LENGTH_SHORT).show();
        }

        if (listLichSuThi.size() == 0) {
            txtAlertLST.setVisibility(View.VISIBLE);
        }
        return listLichSuThi;
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        addConTrolsLst();
    }


    public void openMonThiActivity(View view) {
        startActivity(new Intent(this, MonThiActivity.class));
    }

    public void openLichThiActivity(View view) {
        startActivity(new Intent(this, LichThiActivity.class));
    }
}