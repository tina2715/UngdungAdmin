package com.udgs123.ungdungadmin.Adapter;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.udgs123.ungdungadmin.Model.Giasu;
import com.udgs123.ungdungadmin.R;

import java.util.List;

public class RecyclerViewAdapterGS extends RecyclerView.Adapter<RecyclerViewAdapterGS.ViewHolder> {
    public List<Giasu> lstGiasu;
    public RecyclerViewAdapterGS(List<Giasu> lstGiasu) {this.lstGiasu = lstGiasu;};
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_giasu,parent,false);
        final ViewHolder viewHolder = new ViewHolder(view);
        final Dialog dialoggs = new Dialog(parent.getContext());
        dialoggs.setContentView(R.layout.dialog_chitiet_giasu);
        dialoggs.getWindow();
        viewHolder.btn_xemchitiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView id_gs = (TextView) dialoggs.findViewById(R.id.id_gs);
                TextView hoten_gs = (TextView) dialoggs.findViewById(R.id.tv_hotengs);
                TextView email_gs = (TextView) dialoggs.findViewById(R.id.tv_emailgs);
                TextView sodienthoai_gs = (TextView) dialoggs.findViewById(R.id.tv_sdtgs);
                TextView diachi_gs = (TextView) dialoggs.findViewById(R.id.tv_diachigs);
                TextView truongtheohoc_gs = (TextView) dialoggs.findViewById(R.id.tv_truongtheohocgs);
                TextView chuyennganh_gs = (TextView) dialoggs.findViewById(R.id.tv_chuyennganhgs);
                TextView monday_gs = (TextView) dialoggs.findViewById(R.id.tv_mondaygs);
                TextView trinhdo_gs = (TextView) dialoggs.findViewById(R.id.tv_trinhdogs);


                id_gs.setText(lstGiasu.get(viewHolder.getAdapterPosition()).getId_gs());
                hoten_gs.setText(lstGiasu.get(viewHolder.getAdapterPosition()).getHoten_gs());
                email_gs.setText(lstGiasu.get(viewHolder.getAdapterPosition()).getEmail_gs());
                sodienthoai_gs.setText(lstGiasu.get(viewHolder.getAdapterPosition()).getSodienthoai_gs());
                diachi_gs.setText(lstGiasu.get(viewHolder.getAdapterPosition()).getDiachi_gs());
                truongtheohoc_gs.setText(lstGiasu.get(viewHolder.getAdapterPosition()).getTruongtheohoc_gs());
                chuyennganh_gs.setText(lstGiasu.get(viewHolder.getAdapterPosition()).getChuyennganh_gs());
                monday_gs.setText(lstGiasu.get(viewHolder.getAdapterPosition()).getMonday_gs());
                trinhdo_gs.setText(lstGiasu.get(viewHolder.getAdapterPosition()).getTrinhdo_gs());
                dialoggs.show();
            }
        } );

        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.id_gs.setText(lstGiasu.get(position).getId_gs());
        holder.hoten_gs.setText(lstGiasu.get(position).getHoten_gs());
        holder.email_gs.setText(lstGiasu.get(position).getEmail_gs());
        holder.sodienthoai_gs.setText(lstGiasu.get(position).getSodienthoai_gs());
        holder.diachi_gs.setText(lstGiasu.get(position).getDiachi_gs());
        holder.truongtheohoc_gs.setText(lstGiasu.get(position).getTruongtheohoc_gs());
        holder.chuyennganhgs.setText(lstGiasu.get(position).getChuyennganh_gs());
        holder.monday_gs.setText(lstGiasu.get(position).getMonday_gs());
        holder.trinhdo_gs.setText(lstGiasu.get( position ).getTrinhdo_gs());



    }

    @Override
    public int getItemCount() {
        return lstGiasu.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private Button btn_xemchitiet;
        private TextView id_gs, hoten_gs, email_gs, sodienthoai_gs, diachi_gs, truongtheohoc_gs, chuyennganhgs, monday_gs, trinhdo_gs;
        public ViewHolder(View itemView) {
            super(itemView);
            id_gs = (TextView) itemView.findViewById(R.id.id_gs);
            hoten_gs = (TextView) itemView.findViewById(R.id.tv_hotengs);
            email_gs = (TextView) itemView.findViewById( R.id.tv_emailgs );
            sodienthoai_gs = (TextView) itemView.findViewById( R.id.tv_sdtgs );
            diachi_gs = (TextView) itemView.findViewById( R.id.tv_diachigs );
            truongtheohoc_gs = (TextView) itemView.findViewById( R.id.tv_truongtheohocgs );
            chuyennganhgs = (TextView) itemView.findViewById( R.id.tv_chuyennganhgs );
            monday_gs = (TextView) itemView.findViewById( R.id.tv_mondaygs );
            trinhdo_gs = (TextView) itemView.findViewById( R.id.tv_trinhdogs );
            btn_xemchitiet = (Button) itemView.findViewById(R.id.btn_xemchitiet);
        }
    }
}
