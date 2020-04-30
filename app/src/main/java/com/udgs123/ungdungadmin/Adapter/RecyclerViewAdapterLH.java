package com.udgs123.ungdungadmin.Adapter;

import android.app.Dialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thekhaeng.pushdownanim.PushDownAnim;
import com.udgs123.ungdungadmin.Model.Lophoc;
import com.udgs123.ungdungadmin.Model.OnItemClickListener;
import com.udgs123.ungdungadmin.R;

import java.util.ArrayList;

public class RecyclerViewAdapterLH extends RecyclerView.Adapter<RecyclerViewAdapterLH.MyViewHolder> {
    public ArrayList<Lophoc> mLophoc;

    private OnItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }
    public RecyclerViewAdapterLH(ArrayList<Lophoc> mLophoc) {this.mLophoc = mLophoc;}


    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lophoc,null);
        final MyViewHolder vHolder = new MyViewHolder(view);

        return vHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Lophoc lophoc = mLophoc.get(position);
        holder.malophoc.setText(lophoc.getMalophoc());
        holder.tentaikhoanhv.setText(lophoc.getTentaikhoanhv());
        holder.caplop.setText(lophoc.getCaplop());
        holder.tenmonhoc.setText(lophoc.getTenmonhoc());
        holder.diadiem.setText(lophoc.getDiadiem());
        holder.ngaydukien.setText(lophoc.getNgaydukien());
        holder.soluonggio.setText(lophoc.getSoluonggio());
        holder.ngayhoctrongtuan.setText(lophoc.getNgayhoctrongtuan());
        holder.giobatdau.setText(lophoc.getGiobatdau());
        holder.loaitrinhdo.setText(lophoc.getLoaitrinhdo());
        holder.mota.setText(lophoc.getMota());
        holder.ngaytao.setText(lophoc.getNgaytao());
        holder.trangthailop.setText(lophoc.getTrangthailop());
        holder.tentaikhoangs.setText(lophoc.getTentaikhoangs());
        holder.hocphi.setText(lophoc.getHocphi());
    }

    @Override
    public int getItemCount() {
        return this.mLophoc.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
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
            PushDownAnim.setPushDownAnimTo(btnXemchitiet).setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener.onClick(view, getLayoutPosition());
                }
            } );
            PushDownAnim.setPushDownAnimTo(btnXemchitiet).setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    mOnItemClickListener.onLongClick(view, getLayoutPosition());
                    return true;
                }
            } );
        }
    }
}
