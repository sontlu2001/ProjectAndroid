package com.example.appthitracnghiem.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appthitracnghiem.Model.LichSuThi;
import com.example.appthitracnghiem.R;

import java.util.List;

public class LichSuThiAdapters extends ArrayAdapter<LichSuThi> {

    public LichSuThiAdapters(@NonNull Context context, int resource, @NonNull List<LichSuThi> objects) {
        super(context, resource, objects);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = View.inflate(parent.getContext(), R.layout.item_lich_su_thi_t, null);

        LichSuThi lichSuThi = getItem(position);
        TextView txtTenDeThi = convertView.findViewById(R.id.txtTenDeThi);
        TextView txtDiem = convertView.findViewById(R.id.txtDiemThi);
        TextView txtTenMonThiLS = convertView.findViewById(R.id.txtTenMonThiLS);

        txtTenMonThiLS.setText("Môn Thi: " + lichSuThi.getTenMonThi());
        txtTenDeThi.setText("Đề Thi: " + lichSuThi.getTenDeThi());
        txtDiem.setText("Điểm: " + lichSuThi.getDiem() + "");


        return convertView;
    }


}
