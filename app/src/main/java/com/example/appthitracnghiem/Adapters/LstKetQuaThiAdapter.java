package com.example.appthitracnghiem.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appthitracnghiem.Commons.Common;
import com.example.appthitracnghiem.Model.ChiTietBaiLam;
import com.example.appthitracnghiem.R;

import java.util.ArrayList;
import java.util.List;

public class LstKetQuaThiAdapter extends ArrayAdapter<ChiTietBaiLam> {


    public LstKetQuaThiAdapter(@NonNull Context context, int resource, @NonNull List<ChiTietBaiLam> objects) {
        super(context, resource, objects);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = View.inflate(parent.getContext(), R.layout.item_list_ketquathi_t, null);

        //Bind dữ liệu phần tử vào View
        ChiTietBaiLam chiTietBaiLam = getItem(position);

        TextView txtSoThuTu = convertView.findViewById(R.id.txtSoThuTu);
        TextView txtCauHoiLst = convertView.findViewById(R.id.txtCauHoiLst);
        TextView txtCauTraLoiLst = convertView.findViewById(R.id.txtCauTraLoiLst);

        txtSoThuTu.setText("Câu "+chiTietBaiLam.getSoThuTu() + ": ");
        txtCauHoiLst.setText(chiTietBaiLam.getCauHoi());
        txtCauTraLoiLst.setText(chiTietBaiLam.getDapAnChon());


        return convertView;
    }

    public static List<ChiTietBaiLam> getLstChiTietBaiLam() {
        List<ChiTietBaiLam> lstChiTietBaiLam = new ArrayList<>();
        String chiTietCauHoi, chiTietDapAn;

        for (int i = 0; i < Common.chiTietDeThiList.size(); i++) {
            chiTietCauHoi = Common.chiTietDeThiList.get(i).getChiTietCauHoi();
            chiTietDapAn = Common.chiTietDeThiList.get(i).getChiTietDapAn();
            lstChiTietBaiLam.add(new ChiTietBaiLam((i + 1), chiTietCauHoi, chiTietDapAn));
        }
        return lstChiTietBaiLam;
    }
}
