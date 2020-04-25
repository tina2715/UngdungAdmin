package com.udgs123.ungdungadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dangnhap extends AppCompatActivity {
    Button btn_dangnhap;
    TextView tv_dangky;
    Connection connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);
        btn_dangnhap = findViewById(R.id.btn_dangnhap);
        btn_dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText tentaikhoan = (EditText) findViewById(R.id.edt_tentaikhoan);
                final EditText matkhau = (EditText) findViewById(R.id.edt_matkhau);
                final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
                if (tentaikhoan.getText().toString().trim().equals("")||matkhau.getText().toString().trim().equals("")) {
                    Toast.makeText(Dangnhap.this, "Hãy nhập tên tài khoản và mật khẩu! ", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        ConnectHelper connectionHelper= new ConnectHelper();
                        connect=connectionHelper.connections();
                        if ( connect == null ) {
                            Toast.makeText(Dangnhap.this, "Kiểm tra kết nối của bạn! ", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            String tentaikhoan1= tentaikhoan.getText().toString().trim();
                            String matkhau1 = matkhau.getText().toString().trim();
                            progressBar.setVisibility(View.VISIBLE);
                            String query ="select * from ttad where Tentaikhoanad = '" + tentaikhoan1 + "' and Matkhauad = '"+ matkhau1 +"' ";
                            Statement stmt = connect.createStatement();
                            ResultSet rs = stmt.executeQuery(query);
                            if (rs.next())
                            {
                                startActivity(new Intent(Dangnhap.this, Trangchu.class));
                                connect.close();
                                progressBar.setVisibility(View.INVISIBLE);
                            }
                            else
                            {
                                progressBar.setVisibility(View.VISIBLE);
                                Toast.makeText(Dangnhap.this ,"Nhập thiếu trường", Toast.LENGTH_LONG).show();
                                progressBar.setVisibility(View.INVISIBLE);
                            }
                        }
                    }catch (Exception ex)
                    {
                        Toast.makeText(Dangnhap.this ,ex.getMessage(), Toast.LENGTH_LONG).show();
                        progressBar.setVisibility( View.INVISIBLE);
                    }
                }
            }
        });

        tv_dangky = (TextView) findViewById(R.id.tv_dangky);
        tv_dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dangnhap.this,Dangky.class);
                startActivity(intent);
            }
        });
    }
}
