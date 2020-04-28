package com.udgs123.ungdungadmin.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thekhaeng.pushdownanim.PushDownAnim;
import com.udgs123.ungdungadmin.Chitiet_giasu;
import com.udgs123.ungdungadmin.Model.Giasu;
import com.udgs123.ungdungadmin.Model.OnItemClickListener;
import com.udgs123.ungdungadmin.R;

import java.util.ArrayList;

public class RecyclerViewAdapterGS extends RecyclerView.Adapter<RecyclerViewAdapterGS.ViewHolder> {
    public ArrayList<Giasu> mGiasu;

    private OnItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public RecyclerViewAdapterGS(ArrayList<Giasu> mGiasu) {this.mGiasu = mGiasu;}

    public RecyclerViewAdapterGS.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_giasu,null);
        final ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;


//        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//        View view = layoutInflater.inflate(R.layout.item_giasu,null);
//        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterGS.ViewHolder holder, int position) {
        final Giasu giasu = mGiasu.get(position);
        holder.tentaikhoan_gs.setText(giasu.getTentaikhoan_gs());
        holder.hoten_gs.setText(giasu.getHoten_gs());
        holder.ngaysinh_gs.setText(giasu.getNgaysinh_gs());
        holder.email_gs.setText(giasu.getEmail_gs());
        holder.sodienthoai_gs.setText(giasu.getSodienthoai_gs());
        holder.diachi_gs.setText(giasu.getDiachi_gs());
        holder.truongtheohoc_gs.setText(giasu.getTruongtheohoc_gs());
        holder.chuyennganhgs.setText(giasu.getChuyennganh_gs());
        holder.monday_gs.setText(giasu.getMonday_gs());
        holder.trinhdo_gs.setText(giasu.getTrinhdo_gs());

    }

    @Override
    public int getItemCount() {
        return mGiasu.size() ;
    }

//> 0 ? mGiasu.size() :0
    class ViewHolder extends RecyclerView.ViewHolder{
        private Button btn_xemchitiet;
        private TextView tentaikhoan_gs, hoten_gs, ngaysinh_gs, email_gs, sodienthoai_gs, diachi_gs, truongtheohoc_gs, chuyennganhgs, monday_gs, trinhdo_gs;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tentaikhoan_gs = itemView.findViewById(R.id.tv_tentaikhoangs);
            hoten_gs = itemView.findViewById(R.id.tv_hotengs);
            ngaysinh_gs = itemView.findViewById(R.id.tv_ngaysinhgs);
            email_gs = itemView.findViewById( R.id.tv_emailgs );
            sodienthoai_gs = itemView.findViewById( R.id.tv_sdtgs );
            diachi_gs = itemView.findViewById( R.id.tv_diachigs );
            truongtheohoc_gs =  itemView.findViewById( R.id.tv_truongtheohocgs );
            chuyennganhgs = itemView.findViewById( R.id.tv_chuyennganhgs );
            monday_gs =  itemView.findViewById( R.id.tv_mondaygs );
            trinhdo_gs =  itemView.findViewById( R.id.tv_trinhdogs );
            btn_xemchitiet = (Button) itemView.findViewById(R.id.btn_xemchitiet);
            PushDownAnim.setPushDownAnimTo(btn_xemchitiet).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener.onClick(view, getLayoutPosition());
                   }
            } );
            PushDownAnim.setPushDownAnimTo(btn_xemchitiet).setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    mOnItemClickListener.onLongClick(view, getLayoutPosition());
                    return true;
                }
            } );

        }
    }

















    //public List<Giasu> lstGiasu;
//    public RecyclerViewAdapterGS(List<Giasu> lstGiasu) {this.lstGiasu = lstGiasu;};
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_giasu,parent,false);
//        final ViewHolder viewHolder = new ViewHolder(view);
//        final Dialog dialoggs = new Dialog(parent.getContext());
//        dialoggs.setContentView(R.layout.dialog_chitiet_giasu);
//        dialoggs.getWindow();
//        viewHolder.btn_xemchitiet.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                TextView tentaikhoan_gs = (TextView) dialoggs.findViewById(R.id.tv_ct_tentaikhoangs);
//                TextView hoten_gs = (TextView) dialoggs.findViewById(R.id.tv_hotengs);
//                TextView ngaysinh_gs = (TextView) dialoggs.findViewById(R.id.tv_ngaysinhgs);
//                TextView email_gs = (TextView) dialoggs.findViewById(R.id.tv_emailgs);
//                TextView sodienthoai_gs = (TextView) dialoggs.findViewById(R.id.tv_sdtgs);
//                TextView diachi_gs = (TextView) dialoggs.findViewById(R.id.tv_diachigs);
//                TextView truongtheohoc_gs = (TextView) dialoggs.findViewById(R.id.tv_truongtheohocgs);
//                TextView chuyennganh_gs = (TextView) dialoggs.findViewById(R.id.tv_chuyennganhgs);
//                TextView monday_gs = (TextView) dialoggs.findViewById(R.id.tv_mondaygs);
//                TextView trinhdo_gs = (TextView) dialoggs.findViewById(R.id.tv_trinhdogs);
//
//                tentaikhoan_gs.setText(lstGiasu.get(viewHolder.getAdapterPosition()).getTentaikhoan_gs());
//                hoten_gs.setText(lstGiasu.get(viewHolder.getAdapterPosition()).getHoten_gs());
//                ngaysinh_gs.setText(lstGiasu.get(viewHolder.getAdapterPosition()).getNgaysinh_gs());
//                email_gs.setText(lstGiasu.get(viewHolder.getAdapterPosition()).getEmail_gs());
//                sodienthoai_gs.setText(lstGiasu.get(viewHolder.getAdapterPosition()).getSodienthoai_gs());
//                diachi_gs.setText(lstGiasu.get(viewHolder.getAdapterPosition()).getDiachi_gs());
//                truongtheohoc_gs.setText(lstGiasu.get(viewHolder.getAdapterPosition()).getTruongtheohoc_gs());
//                chuyennganh_gs.setText(lstGiasu.get(viewHolder.getAdapterPosition()).getChuyennganh_gs());
//                monday_gs.setText(lstGiasu.get(viewHolder.getAdapterPosition()).getMonday_gs());
//                trinhdo_gs.setText(lstGiasu.get(viewHolder.getAdapterPosition()).getTrinhdo_gs());
//                dialoggs.show();
//            }
//        } );
//
//        return viewHolder;
//    }
//
//
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.tentaikhoan_gs.setText(lstGiasu.get(position).getTentaikhoan_gs());
//        holder.hoten_gs.setText(lstGiasu.get(position).getHoten_gs());
//        holder.ngaysinh_gs.setText(lstGiasu.get(position).getNgaysinh_gs());
//        holder.email_gs.setText(lstGiasu.get(position).getEmail_gs());
//        holder.sodienthoai_gs.setText(lstGiasu.get(position).getSodienthoai_gs());
//        holder.diachi_gs.setText(lstGiasu.get(position).getDiachi_gs());
//        holder.truongtheohoc_gs.setText(lstGiasu.get(position).getTruongtheohoc_gs());
//        holder.chuyennganhgs.setText(lstGiasu.get(position).getChuyennganh_gs());
//        holder.monday_gs.setText(lstGiasu.get(position).getMonday_gs());
//        holder.trinhdo_gs.setText(lstGiasu.get( position ).getTrinhdo_gs());
//
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return lstGiasu.size();
//    }
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        private Button btn_xemchitiet;
//        private TextView tentaikhoan_gs, hoten_gs, ngaysinh_gs, email_gs, sodienthoai_gs, diachi_gs, truongtheohoc_gs, chuyennganhgs, monday_gs, trinhdo_gs;
//        public ViewHolder(View itemView) {
//            super(itemView);
//            tentaikhoan_gs = (TextView) itemView.findViewById(R.id.tv_tentaikhoangs);
//            hoten_gs = (TextView) itemView.findViewById(R.id.tv_hotengs);
//            ngaysinh_gs = (TextView) itemView.findViewById(R.id.tv_ngaysinhgs);
//            email_gs = (TextView) itemView.findViewById( R.id.tv_emailgs );
//            sodienthoai_gs = (TextView) itemView.findViewById( R.id.tv_sdtgs );
//            diachi_gs = (TextView) itemView.findViewById( R.id.tv_diachigs );
//            truongtheohoc_gs = (TextView) itemView.findViewById( R.id.tv_truongtheohocgs );
//            chuyennganhgs = (TextView) itemView.findViewById( R.id.tv_chuyennganhgs );
//            monday_gs = (TextView) itemView.findViewById( R.id.tv_mondaygs );
//            trinhdo_gs = (TextView) itemView.findViewById( R.id.tv_trinhdogs );
//            btn_xemchitiet = (Button) itemView.findViewById(R.id.btn_xemchitiet);
//        }
//    }
}
