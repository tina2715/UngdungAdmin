package com.udgs123.ungdungadmin.Adapter;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.udgs123.ungdungadmin.Model.Lophoc;
import com.udgs123.ungdungadmin.R;

import java.util.List;

public class RecyclerViewAdapterLH extends RecyclerView.Adapter<RecyclerViewAdapterLH.MyViewHolder> {
    public List<Lophoc> lstLophoc;
    public RecyclerViewAdapterLH(List<Lophoc> lstLophoc) {this.lstLophoc = lstLophoc;}
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lophoc,parent,false);
        final MyViewHolder vHolder = new MyViewHolder(view);
        final Dialog dialogss=new Dialog(parent.getContext());
        dialogss.setContentView(R.layout.dialog_chitiet_lophoc);
        dialogss.getWindow();
        vHolder.btnXemchitiet.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView malophoc_dialog = (TextView) dialogss.findViewById(R.id.tv_malop_dialog);
                TextView tentaikhoanhv_dialog = (TextView) dialogss.findViewById(R.id.tv_tentaikhoanhv_dialog);
                TextView caplop_dialog = (TextView) dialogss.findViewById(R.id.tv_caplop_dialog);
                TextView tenmonhoc_dialog = (TextView) dialogss.findViewById(R.id.tv_tenmonhoc_dialog);
                TextView diadiemhoc_dialog = (TextView) dialogss.findViewById(R.id.tv_diadiemhoc_dialog);
                TextView ngaydukien_dialog = (TextView) dialogss.findViewById(R.id.tv_ngaydukien_dialog);
                TextView soluonggio_dialog = (TextView) dialogss.findViewById(R.id.tv_soluonggio_dialog);
                TextView ngayhoctrongtuan_dialog = (TextView) dialogss.findViewById(R.id.tv_ngayhoctrongtuan_dialog);
                TextView giobatdauhoc_dialog = (TextView) dialogss.findViewById(R.id.tv_giobatdau_dialog);
                TextView loaitrinhdo_dialog = (TextView) dialogss.findViewById(R.id.tv_loaitrinhdo_dialog);
                TextView mota_dialog = (TextView) dialogss.findViewById(R.id.tv_mota_dialog);
                TextView ngaytao_dialog = (TextView) dialogss.findViewById(R.id.tv_ngaytao_dialog);
                TextView hocphi_dialog = (TextView) dialogss.findViewById(R.id.tv_hocphi_dialog);
                TextView trangthailop_dialog = (TextView) dialogss.findViewById(R.id.tv_trangthailop_dialog);
                TextView tentaikhoangs_dialog = (TextView) dialogss.findViewById(R.id.tv_tentaikhoangs_dialog);


                malophoc_dialog.setText(lstLophoc.get(vHolder.getAdapterPosition()).getMalophoc());
                tentaikhoanhv_dialog.setText(lstLophoc.get(vHolder.getAdapterPosition()).getTentaikhoanhv());
                caplop_dialog.setText(lstLophoc.get(vHolder.getAdapterPosition()).getCaplop());
                tenmonhoc_dialog.setText(lstLophoc.get(vHolder.getAdapterPosition()).getTenmonhoc());
                diadiemhoc_dialog.setText(lstLophoc.get(vHolder.getAdapterPosition()).getDiadiem());
                ngaydukien_dialog.setText(lstLophoc.get(vHolder.getAdapterPosition()).getNgaydukien());
                soluonggio_dialog.setText(lstLophoc.get(vHolder.getAdapterPosition()).getSoluonggio());
                ngayhoctrongtuan_dialog.setText(lstLophoc.get(vHolder.getAdapterPosition()).getNgayhoctrongtuan());
                giobatdauhoc_dialog.setText(lstLophoc.get(vHolder.getAdapterPosition()).getGiobatdau());
                loaitrinhdo_dialog.setText(lstLophoc.get(vHolder.getAdapterPosition()).getLoaitrinhdo());
                mota_dialog.setText(lstLophoc.get(vHolder.getAdapterPosition()).getMota());
                ngaytao_dialog.setText(lstLophoc.get(vHolder.getAdapterPosition()).getNgaytao());
                hocphi_dialog.setText(lstLophoc.get(vHolder.getAdapterPosition()).getHocphi());
                trangthailop_dialog.setText(lstLophoc.get(vHolder.getAdapterPosition()).getTrangthailop());
                tentaikhoangs_dialog.setText(lstLophoc.get(vHolder.getAdapterPosition()).getTentaikhoangs());
                dialogss.show();
            }
        } );


        return vHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.malophoc.setText(lstLophoc.get(position).getMalophoc());
        holder.tentaikhoanhv.setText(lstLophoc.get(position).getTentaikhoanhv());
        holder.caplop.setText(lstLophoc.get(position).getCaplop());
        holder.tenmonhoc.setText(lstLophoc.get(position).getTenmonhoc());
        holder.diadiem.setText(lstLophoc.get(position).getDiadiem());
        holder.ngaydukien.setText(lstLophoc.get(position).getNgaydukien());
        holder.soluonggio.setText(lstLophoc.get(position).getSoluonggio());
        holder.ngayhoctrongtuan.setText(lstLophoc.get(position).getNgayhoctrongtuan());
        holder.giobatdau.setText(lstLophoc.get(position).getGiobatdau());
        holder.loaitrinhdo.setText(lstLophoc.get(position).getLoaitrinhdo());
        holder.mota.setText(lstLophoc.get(position).getMota());
        holder.ngaytao.setText(lstLophoc.get(position).getNgaytao());
        holder.trangthailop.setText(lstLophoc.get(position).getTrangthailop());
        holder.tentaikhoangs.setText(lstLophoc.get(position).getTentaikhoangs());
        holder.hocphi.setText(lstLophoc.get(position).getHocphi());
    }

    @Override
    public int getItemCount() {
        return this.lstLophoc.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView malophoc, tentaikhoanhv, caplop, tenmonhoc, diadiem, ngaydukien, soluonggio, ngayhoctrongtuan, giobatdau, loaitrinhdo, mota, ngaytao, trangthailop, tentaikhoangs, hocphi;
        private Button btnXemchitiet;

        public MyViewHolder(View itemView){
            super(itemView);
            malophoc = (TextView) itemView.findViewById( R.id.tv_malophoc_item);
            tentaikhoanhv = (TextView) itemView.findViewById(R.id.tv_tentaikhoanhv_item);
            caplop = (TextView) itemView.findViewById(R.id.tv_caplop_item);
            tenmonhoc = (TextView) itemView.findViewById(R.id.tv_tenmonhoc_item);
            diadiem = (TextView) itemView.findViewById(R.id.tv_diadiem_item);
            ngaydukien = (TextView) itemView.findViewById(R.id.tv_ngaydukien_item);
            soluonggio = (TextView) itemView.findViewById(R.id.tv_soluonggio_item);
            ngayhoctrongtuan = (TextView) itemView.findViewById(R.id.tv_ngayhoctrongtuan_item);
            giobatdau = (TextView) itemView.findViewById(R.id.tv_giobatdau_item);
            loaitrinhdo = (TextView) itemView.findViewById(R.id.tv_loaitrinhdo_item);
            mota = (TextView) itemView.findViewById(R.id.tv_mota_item);
            ngaytao = (TextView) itemView.findViewById(R.id.tv_ngaytao_item);
            trangthailop = (TextView) itemView.findViewById(R.id.tv_trangthailop_item);
            tentaikhoangs = (TextView) itemView.findViewById(R.id.tv_tentaikhoangs_item);
            hocphi = (TextView) itemView.findViewById(R.id.tv_hocphi_item);
            btnXemchitiet = (Button) itemView.findViewById(R.id.btn_xemchitiet);
        }
    }
}
