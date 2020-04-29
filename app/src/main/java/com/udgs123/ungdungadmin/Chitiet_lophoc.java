package com.udgs123.ungdungadmin;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Chitiet_lophoc extends AppCompatActivity {
TextView malopHoc, tentaikhoanhv, caplop, tenmonhoc, diadiem, ngaydukien, soluonggio, ngayhoctrongtuan,
        giobatdau, loaitrinhdo, mota, ngaytao, trangthailop, tentaikhoangs, hocphi;
Button btnHuy, btnKhoa, btnKichhoat;
Connection connect;
String malophoc;
int REQUEST_CODE_UPDATE = 1997;
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_chitiet_lophoc);
        malopHoc = findViewById( R.id.tv_malop_dialog );
        tentaikhoanhv = findViewById(R.id.tv_tentaikhoanhv_dialog);
        caplop = findViewById( R.id.tv_caplop_dialog );
        tenmonhoc = findViewById( R.id.tv_tenmonhoc_dialog );
        diadiem = findViewById( R.id.tv_diadiemhoc_dialog );
        ngaydukien = findViewById( R.id.tv_ngaydukien_dialog );
        soluonggio = findViewById(R.id.tv_soluonggio_dialog);
        ngayhoctrongtuan = findViewById( R.id.tv_ngayhoctrongtuan_dialog );
        giobatdau = findViewById( R.id.tv_giobatdau_dialog );
        loaitrinhdo = findViewById( R.id.tv_loaitrinhdo_dialog );
        mota = findViewById( R.id.tv_mota_dialog );
        ngaytao = findViewById( R.id.tv_ngaytao_dialog );
        trangthailop = findViewById(R.id.tv_trangthailop_dialog);
        tentaikhoangs = findViewById( R.id.tv_tentaikhoangs_dialog );
        hocphi = findViewById( R.id.tv_hocphi_dialog );
        btnKhoa = findViewById(R.id.btn_khoa_lop_dialog);
        btnKichhoat = findViewById(R.id.btn_kichhoat_lop_dialog);
        btnHuy = findViewById( R.id.btn_huy_lop_dialog );

        malophoc = getIntent().getStringExtra("malophoc");
        malopHoc.setText(malophoc);

        try {
           ConnectHelper connectHelper = new ConnectHelper();
           connect = connectHelper.connections();
           if(connect==null){
               Toast.makeText(getApplicationContext(),"Lỗi kết nối", Toast.LENGTH_LONG).show();
           } else {
               String query = "SELECT * FROM Quanlylop WHERE Malophoc ='"+malophoc+"'";
               Statement st = connect.createStatement();
               ResultSet rs = st.executeQuery(query);
               if (rs.next()){
                   if (rs.getInt( "Trangthailop" )==0){
                       trangthailop.setTextColor(Color.CYAN);
                       trangthailop.setText("Chưa có gia sư nhận");
                   }
                   else if (rs.getInt("Trangthailop")==3) {
                       trangthailop.setTextColor(Color.RED);
                       trangthailop.setText("Đã khóa");
                       btnKhoa.setText("Mở khóa");
                   } else if (rs.getInt("Trangthailop")==1){
                       trangthailop.setTextColor(Color.BLUE);
                       trangthailop.setText("Chưa kích hoạt");
                   } else {
                       trangthailop.setTextColor(Color.GREEN);
                       trangthailop.setText("Đã kích hoạt");
                   }
                   tentaikhoanhv.setText(rs.getString("Tentaikhoanhv"));
                   caplop.setText(rs.getString("Caplop"));
                   tenmonhoc.setText(rs.getString("Tenmonhoc"));
                   diadiem.setText(rs.getString("Diadiem"));
                   ngaydukien.setText(rs.getString("Ngaydukien"));
                   soluonggio.setText(rs.getString("Soluonggio"));
                   ngayhoctrongtuan.setText(rs.getString("Ngayhoctrongtuan"));
                   giobatdau.setText(rs.getString("Giobatdau"));
                   loaitrinhdo.setText(rs.getString("Loaitrinhdo"));
                   mota.setText(rs.getString("Mota"));
                   ngaytao.setText(rs.getString("Ngaytao"));
                   tentaikhoangs.setText(rs.getString("Tentaikhoangs"));
                   hocphi.setText(rs.getString("Hocphi"));
               }
           }
        } catch (Exception e) {
            Log.d("BBB",e.getMessage());
        }
        btnKichhoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (trangthailop.getText().toString().trim().equals("Đã kích hoạt")){
                    Toast.makeText(getApplicationContext(),"Lớp này đã được kích hoạt",Toast.LENGTH_LONG).show();
                }
                if (trangthailop.getText().toString().trim().equals("Đã khóa")) {
                    Toast.makeText(getApplicationContext(),"Lớp này đang bị khóa, không thể kích hoạt", Toast.LENGTH_LONG).show();
                }
                else {
                    try {
                        ConnectHelper connectHelper = new ConnectHelper();
                        connect = connectHelper.connections();
                        if (connect==null){
                            Toast.makeText(getApplicationContext(),"Lỗi kết nối", Toast.LENGTH_LONG).show();
                        } else {
                            String query = "UPDATE Quanlylop SET Trangthailop=2 WHERE Malophoc='"+malophoc+"'";
                            Statement st = connect.createStatement();
                            ResultSet rs = st.executeQuery(query);
                        }
                        connect.close();
                    } catch (Exception e){
                        trangthailop.setTextColor(Color.GREEN);
                        trangthailop.setText("Đã kích hoạt");
                        Toast.makeText(getApplicationContext(),"Kích hoạt thành công", Toast.LENGTH_LONG).show();
                    }
                }
            }
        } );
        btnKhoa.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog();
            }
        } );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==REQUEST_CODE_UPDATE && resultCode==RESULT_OK && data!=null) {
            finish();
            Intent intent = new Intent(Chitiet_lophoc.this, Chitiet_lophoc.class);
            intent.putExtra("malophoc", malophoc);
            startActivity(intent);
        }
        super.onActivityResult( requestCode, resultCode, data );
    }
    public void showAlertDialog(){
        if (trangthailop.getText().toString().trim().equals("Đã kích hoạt")|| trangthailop.getText().toString().trim().equals("Chưa kích hoạt")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Xác nhận");
            builder.setMessage("Bạn có muốn khóa lớp học này không?");
            builder.setCancelable(false);
            builder.setNegativeButton( "Có", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    try {
                        ConnectHelper connectHelper = new ConnectHelper();
                        connect=connectHelper.connections();
                        if (connect==null){
                            Toast.makeText(getApplicationContext(),"Lỗi kết nối", Toast.LENGTH_LONG).show();
                        } else {
                            String query = "UPDATE Quanlylop SET Trangthailop=3 WHERE Malophoc='"+malophoc+"'";
                            Statement st = connect.createStatement();
                            st.executeQuery(query);
                        } connect.close();
                    } catch (Exception e) {
                        trangthailop.setTextColor(Color.RED);
                        trangthailop.setText("Đã khóa");
                        Toast.makeText(getApplicationContext(),"Lớp này đã bị khóa", Toast.LENGTH_LONG).show();
                    }
                }
            } );
            builder.setPositiveButton( "Không", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            } );
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Xác nhận");
            builder.setMessage("Bạn có muốn mở lớp này không?");
            builder.setCancelable(false);
            builder.setNegativeButton( "Có", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    try {
                        ConnectHelper connectHelper = new ConnectHelper();
                        connect = connectHelper.connections();
                        if (connect== null){
                            Toast.makeText(getApplicationContext(),"Lỗi kết nối",Toast.LENGTH_LONG).show();
                        } else {
                            String query = "UPDATE Quanlylop SET Trangthailop=1 WHERE Malophoc='"+malophoc+"'";
                            Statement st = connect.createStatement();
                            st.executeQuery(query);
                        } connect.close();
                    }catch (Exception e) {
                        btnKhoa.setText("Khóa");
                        trangthailop.setTextColor(Color.BLUE);
                        trangthailop.setText("Chưa kích hoạt");
                        Toast.makeText(getApplicationContext(),"Lớp học này đã được mở khóa", Toast.LENGTH_LONG).show();
                    }
                }
            } );
            builder.setPositiveButton( "Không", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            } );
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }
}
