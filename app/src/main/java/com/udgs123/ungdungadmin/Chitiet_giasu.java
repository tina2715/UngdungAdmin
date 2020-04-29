package com.udgs123.ungdungadmin;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
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

public class Chitiet_giasu extends AppCompatActivity {
    TextView tentaikhoangs, hoten, ngaysinh, email, sdt, diachi, truongtheohoc, chuyennganh, tenmon, trinhdo, trangthainguoidung;
    Button btnXoa, btnKhoa, btnKichhoat;
    Connection connect;
    String tentaikhoan;
    int REQUEST_CODE_UPDATE = 1997;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_chitiet_giasu);

        trangthainguoidung = findViewById( R.id.tv_trangthainguoidung_ct );
        btnXoa = findViewById(R.id.btn_xoa_ct);
        btnKichhoat = findViewById(R.id.btn_kichhoat_ct);
        btnKhoa = findViewById(R.id.btn_khoa_ct);
        tentaikhoangs = findViewById(R.id.tv_ct_tentaikhoangs);
        hoten = findViewById(R.id.tv_hotengs_ct);
        ngaysinh = findViewById(R.id.tv_ngaysinhgs_ct);
        email = findViewById(R.id.tv_emailgs_ct);
        sdt = findViewById(R.id.tv_sdtgs_ct);
        diachi = findViewById(R.id.tv_diachigs_ct);
        truongtheohoc = findViewById(R.id.tv_truongtheohocgs_ct);
        chuyennganh = findViewById(R.id.tv_chuyennganhgs_ct);
        tenmon = findViewById(R.id.tv_mondaygs_ct);
        trinhdo = findViewById(R.id.tv_trinhdogs_ct);

    //        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    //        SharedPreferences.Editor editor = mPreferences.edit();
    //
    //        String tentaikhoan = mPreferences.getString( "Tentaikhoangs","" );

        tentaikhoan = getIntent().getStringExtra("tentaikhoan");
        tentaikhoangs.setText(tentaikhoan);



        try {
            ConnectHelper connectHelper = new ConnectHelper();
            connect = connectHelper.connections();
            if (connect==null){
                Toast.makeText(getApplicationContext(),"Loi",Toast.LENGTH_LONG).show();
            } else {
                String query = "SELECT * FROM ttgs WHERE Tentaikhoangs='"+tentaikhoan+"'";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);
                if (rs.next()){
                    if (rs.getInt("Trangthainguoidung")==0){
                        trangthainguoidung.setTextColor(Color.RED);
                        trangthainguoidung.setText("Đã khóa");
                        btnKhoa.setText("Mở khóa");
                    } else if (rs.getInt("Trangthainguoidung")==1){
                        trangthainguoidung.setTextColor(Color.BLUE);
                        trangthainguoidung.setText("Chưa kích hoạt");
                    } else {
                        trangthainguoidung.setTextColor(Color.GREEN);
                        trangthainguoidung.setText("Đã kích hoạt");
                    }
                    hoten.setText(rs.getString("Hotengs"));
                    ngaysinh.setText(rs.getString("Ngaysinhgs"));
                    email.setText(rs.getString("Emailgs"));
                    sdt.setText(rs.getString("Sdtgs"));
                    diachi.setText(rs.getString("Diachigs"));
                    truongtheohoc.setText(rs.getString("Truongtheohoc"));
                    chuyennganh.setText(rs.getString("Chuyennganh"));
                    tenmon.setText(rs.getString("Tenmongs"));
                    trinhdo.setText(rs.getString("Tentrinhdo"));
                }

            }
        } catch (Exception e){
            Log.d("BBB", e.getMessage());
        }
        btnKichhoat.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (trangthainguoidung.getText().toString().trim().equals("Đã kích hoạt")){
                    Toast.makeText(getApplicationContext(),"Tài khoản này đã được kích hoạt!",Toast.LENGTH_LONG).show();
                }
                if (trangthainguoidung.getText().toString().trim().equals("Đã khóa")) {
                    Toast.makeText(getApplicationContext(),"Tài khoản này đang bị khóa, không thể kích hoạt!",Toast.LENGTH_LONG).show();
                }
                else {
                    try {
                        ConnectHelper connectHelper = new ConnectHelper();
                        connect = connectHelper.connections();
                        if (connect==null){
                            Toast.makeText(getApplicationContext(),"Loi",Toast.LENGTH_LONG).show();
                        }
                        else {
                            String query = "UPDATE ttgs SET Trangthainguoidung=2 WHERE Tentaikhoangs='"+tentaikhoan+"'";
                            Statement st = connect.createStatement();
                            st.executeQuery(query);
                        }
                        connect.close();
                    } catch (Exception e){
                        trangthainguoidung.setTextColor(Color.GREEN);
                        trangthainguoidung.setText("Đã kích hoạt");
                        Toast.makeText(getApplicationContext(),"kich hoat thanh cong", Toast.LENGTH_LONG).show();
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
        if (requestCode==REQUEST_CODE_UPDATE && resultCode==RESULT_OK && data != null){
            finish();
            Intent intent = new Intent(Chitiet_giasu.this, Chitiet_giasu.class);
            intent.putExtra("tentaikhoan",tentaikhoan);
            startActivity(intent);
        }

        super.onActivityResult( requestCode, resultCode, data );
    }

    public void showAlertDialog(){
        if (trangthainguoidung.getText().toString().trim().equals("Đã kích hoạt")||trangthainguoidung.getText().toString().trim().equals("Chưa kích hoạt")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Xác nhận");
            builder.setMessage("Bạn có muốn khóa tài khoản này không?");
            builder.setCancelable(false);
            builder.setNegativeButton( "có", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    try {
                        ConnectHelper connectHelper = new ConnectHelper();
                        connect = connectHelper.connections();
                        if (connect==null){
                            Toast.makeText(getApplicationContext(),"Loi",Toast.LENGTH_LONG).show();
                        } else {
                            String query = "UPDATE ttgs SET Trangthainguoidung=0 WHERE Tentaikhoangs='"+tentaikhoan+"'";
                            Statement st = connect.createStatement();
                            st.executeQuery(query);
                        } connect.close();
                    } catch (Exception e) {
                        trangthainguoidung.setTextColor(Color.RED);
                        trangthainguoidung.setText("Đã khóa");
                        Toast.makeText(getApplicationContext(),"Tài khoản đã bị khóa",Toast.LENGTH_LONG).show();
                    }
                }
            } );
        builder.setPositiveButton( "không", new DialogInterface.OnClickListener() {
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
            builder.setMessage("Bạn có muốn mở khóa tài khoản này không?");
            builder.setCancelable(false);
            builder.setNegativeButton( "Có", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    try {
                        ConnectHelper connectHelper = new ConnectHelper();
                        connect = connectHelper.connections();
                        if (connect==null){
                            Toast.makeText(getApplicationContext(),"Loi",Toast.LENGTH_LONG).show();
                        } else {
                            String query = "UPDATE ttgs SET Trangthainguoidung=1 WHERE Tentaikhoangs='"+tentaikhoan+"'";
                            Statement st = connect.createStatement();
                            st.executeQuery(query);
                        } connect.close();
                    }catch (Exception e) {
                        btnKhoa.setText("Khóa");
                        trangthainguoidung.setTextColor(Color.BLUE);
                        trangthainguoidung.setText("Chưa kích hoạt");
                        Toast.makeText(getApplicationContext(),"Tài khoản đã được mở khóa",Toast.LENGTH_LONG).show();
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
