package com.example.appthitracnghiem.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appthitracnghiem.Model.LichThi;
import com.example.appthitracnghiem.R;

import java.util.List;

public class LichThiAdapter extends ArrayAdapter<LichThi> {
    public LichThiAdapter(@NonNull Context context, int resource, @NonNull List<LichThi> objects) {
        super(context, resource, objects);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = View.inflate(parent.getContext(), R.layout.item_lich_thi_t, null);

        LichThi lichThi = getItem(position);
        TextView txtTenMonThi = convertView.findViewById(R.id.txtTenMonThi);
        TextView txtTenDeThiLT = convertView.findViewById(R.id.txtTenDeThiLT);
        TextView txtNgayThi = convertView.findViewById(R.id.txtNgayThi);

        txtTenMonThi.setText("Môn thi: " + lichThi.getTenMonThi());
        txtTenDeThiLT.setText("Đề thi: " + lichThi.getTenDeThi());
        txtNgayThi.setText("Ngày thi: " + lichThi.getThoiGianThi() + "");

        return convertView;
    }
}
