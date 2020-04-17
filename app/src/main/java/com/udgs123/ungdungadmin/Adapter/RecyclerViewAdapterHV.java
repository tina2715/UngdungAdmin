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
    public List<Hocvien> lsthocvien;
    Context mContext;
public RecyclerViewAdapterHV(List<Hocvien> lsthocvien){ this.lsthocvien = lsthocvien; };
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hocvien, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        final Dialog dialog = new Dialog(parent.getContext());
        dialog.setContentView( R.layout.dialog_chitiet_hocvien );
        dialog.getWindow();
        viewHolder.btn_xemchitiet.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView hoten_hv = (TextView) dialog.findViewById(R.id.tv_hotenhv);
                TextView email_hv = (TextView) dialog.findViewById( R.id.tv_emailhv );
                TextView sdt_hv = (TextView) dialog.findViewById( R.id.tv_sdthv );
                TextView diachi_hv = (TextView) dialog.findViewById( R.id.tv_diachihv );

                hoten_hv.setText(lsthocvien.get(viewHolder.getAdapterPosition()).getHoten_hv());
                email_hv.setText(lsthocvien.get(viewHolder.getAdapterPosition()).getEmail_hv());
                sdt_hv.setText(lsthocvien.get(viewHolder.getAdapterPosition()).getSdt_hv());
                diachi_hv.setText(lsthocvien.get(viewHolder.getAdapterPosition()).getDiachi_hv());


                dialog.show();

            }
        } );

                return viewHolder;
            }
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.hoten_hv.setText(lsthocvien.get(position).getHoten_hv());
        holder.email_hv.setText(lsthocvien.get(position).getEmail_hv());
        holder.sodienthoai_hv.setText(lsthocvien.get(position).getSdt_hv());
        holder.diachi_hv.setText(lsthocvien.get(position).getDiachi_hv());


    }
    public int getItemCount() {
        return lsthocvien.size();
    }
    public  static  class  ViewHolder extends RecyclerView.ViewHolder {

        private TextView hoten_hv, email_hv, sodienthoai_hv, diachi_hv;
        Button btn_xemchitiet;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hoten_hv = (TextView) itemView.findViewById(R.id.tv_hotenhv);
            email_hv = (TextView) itemView.findViewById(R.id.tv_emailhv);
            sodienthoai_hv = (TextView) itemView.findViewById(R.id.tv_sdthv);
            diachi_hv = (TextView) itemView.findViewById(R.id.tv_diachihv);
            btn_xemchitiet = (Button) itemView.findViewById( R.id.btn_xemchitiet );

        }
    }
}
