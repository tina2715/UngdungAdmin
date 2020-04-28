package com.udgs123.ungdungadmin.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thekhaeng.pushdownanim.PushDownAnim;
import com.udgs123.ungdungadmin.Model.Hocvien;
import com.udgs123.ungdungadmin.Model.OnItemClickListener;
import com.udgs123.ungdungadmin.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapterHV extends RecyclerView.Adapter<RecyclerViewAdapterHV.ViewHolder>{


    public ArrayList<Hocvien> mHocvien;
    private static OnItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }

public RecyclerViewAdapterHV(ArrayList<Hocvien> mHocvien){ this.mHocvien = mHocvien; }

    public RecyclerViewAdapterHV.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hocvien, null);
        final ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
            }
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Hocvien hocvien = mHocvien.get(position);
        holder.tentaikhoan_hv.setText(hocvien.getTentaikhoan_hv());
        holder.hoten_hv.setText(hocvien.getHoten_hv());
        holder.email_hv.setText(hocvien.getEmail_hv());
        holder.sodienthoai_hv.setText(hocvien.getSdt_hv());
        holder.diachi_hv.setText(hocvien.getDiachi_hv());


    }
    public int getItemCount() {
        return mHocvien.size();
    }
    class  ViewHolder extends RecyclerView.ViewHolder {

        private TextView tentaikhoan_hv, hoten_hv, email_hv, sodienthoai_hv, diachi_hv;
        Button btn_xemchitiet;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tentaikhoan_hv = (TextView) itemView.findViewById(R.id.tv_tentaikhoanhv_item);
            hoten_hv = (TextView) itemView.findViewById(R.id.tv_hotenhv_item);
            email_hv = (TextView) itemView.findViewById(R.id.tv_emailhv_item);
            sodienthoai_hv = (TextView) itemView.findViewById(R.id.tv_sdthv_item);
            diachi_hv = (TextView) itemView.findViewById(R.id.tv_diachihv_item);
            btn_xemchitiet = (Button) itemView.findViewById( R.id.btn_xemchitiet );
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
}
