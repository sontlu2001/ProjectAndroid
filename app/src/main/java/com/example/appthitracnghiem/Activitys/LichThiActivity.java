package com.example.appthitracnghiem.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appthitracnghiem.Adapters.LichThiAdapter;
import com.example.appthitracnghiem.Commons.Common;
import com.example.appthitracnghiem.ConfigDB.Database;
import com.example.appthitracnghiem.Model.LichThi;
import com.example.appthitracnghiem.R;

import java.util.ArrayList;
import java.util.List;

public class LichThiActivity extends AppCompatActivity {

    private TextView txtAlertLT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_thi);

        addConTrolsLst();
    }

    private void addConTrolsLst() {
        txtAlertLT = findViewById(R.id.txtAlertLT);
        ListView lstView = findViewById(R.id.lstLichThi);
        LichThiAdapter lichThiAdapter = new LichThiAdapter(
                this, R.layout.item_lich_thi_t, getLichThiList());
        lstView.setAdapter(lichThiAdapter);
    }


    private List<LichThi> getLichThiList() {
        List<LichThi> lichThiList = new ArrayList<>();
        try {
            SQLiteDatabase db = Database.initDatabase(this, Common.DATABASE_NAME);
            Cursor cursor = db.rawQuery(
                    "SELECT mt.TenMon, dt.TenDeThi, dt.ThoiGianThi  " +
                            "FROM DeThi dt, MonThi mt, HocSinh hs  " +
                            "WHERE hs.IDHocSinh=? AND dt.IDMonThi=mt.IDMonThi",
                    new String[]{Common.ID_HOCSINH + ""});
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                LichThi lichThi = new LichThi();
                lichThi.setTenMonThi(cursor.getString(0));
                lichThi.setTenDeThi(cursor.getString(1));
                lichThi.setThoiGianThi(cursor.getString(2));
                lichThiList.add(lichThi);
                cursor.moveToNext();
            }
            cursor.close();
        } catch (SQLException e) {
            Toast.makeText(this, "Lỗi kết nối tới CSDL", Toast.LENGTH_SHORT).show();
        }

        if (lichThiList.size() == 0) {
            txtAlertLT.setVisibility(View.VISIBLE);
        }
        return lichThiList;
    }

    public void openLichSuThiActivity(View view) {
        startActivity(new Intent(this, LichSuThiActivity.class));
    }

    public void openMonThiActivity(View view) {
        startActivity(new Intent(this, MonThiActivity.class));
    }
}