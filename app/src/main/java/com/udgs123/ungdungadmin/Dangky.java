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
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dangky extends AppCompatActivity {
    Button btn_dangky;
    TextView tv_huy;
    Connection connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);
        btn_dangky = (Button) findViewById(R.id.btn_dangky);
        btn_dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText tentaikhoan = findViewById(R.id.edt_tentaikhoan);
                final EditText matkhau = findViewById(R.id.edt_matkhau);
                final EditText hoten = findViewById(R.id.edt_hoten);
                final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
                if (tentaikhoan.getText().toString().trim().equals("")||matkhau.getText().toString().trim().equals("")||hoten.getText().toString().trim().equals("")) {
                    Toast.makeText(Dangky.this, "Hãy nhập đầy đủ thông tin! ", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        ConnectHelper connectionHelper= new ConnectHelper();
                        connect=connectionHelper.connections();
                        if ( connect == null ) {
                            Toast.makeText(Dangky.this, "Kiểm tra kết nối của bạn! ", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            try {
                                PreparedStatement pst = connect.prepareStatement("insert into taikhoan_admin values(?,?,?)");
                                pst.setString(1, tentaikhoan.getText().toString().trim());
                                pst.setString(2, matkhau.getText().toString().trim());
                                pst.setString(3, hoten.getText().toString().trim());
                                pst.executeUpdate();
                                Toast.makeText(getApplicationContext(),"Đăng ký thành công", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Dangky.this, Dangnhap.class));
                                connect.close();
                            } catch (SQLException e) {
                                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }catch (Exception ex)
                    {
                        Toast.makeText(Dangky.this ,ex.getMessage(), Toast.LENGTH_LONG).show();
                        progressBar.setVisibility( View.INVISIBLE);
                    }
                }
            }
        });
        tv_huy = (TextView) findViewById(R.id.tv_huy);
        tv_huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dangky.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
