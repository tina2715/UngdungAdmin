package com.udgs123.ungdungadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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
    EditText tentaikhoan, matkhau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);
        btn_dangky = (Button) findViewById(R.id.btn_dangky);


        btn_dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    tentaikhoan = findViewById(R.id.edt_tentaikhoan);
                    matkhau = findViewById(R.id.edt_matkhau);
                final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
                if (tentaikhoan.getText().toString().trim().equals("")||matkhau.getText().toString().trim().equals("")) {
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
                                    String tentaikhoan1 = tentaikhoan.getText().toString().trim();
                                    String matkhau1 = matkhau.getText().toString();
                                    String query ="INSERT INTO ttad(Tentaikhoanad, Matkhauad) VALUES('"+tentaikhoan1+"','"+matkhau1+"')";
                                    PreparedStatement pst = connect.prepareStatement(query);
                                    pst.executeUpdate();
                                    Toast.makeText(getApplicationContext(),"Dang ky thanh cong", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(),Dangnhap.class));
                                    connect.close();


//                                PreparedStatement pst = connect.prepareStatement("insert into ttad values(?,?)");
//                                pst.setString(1, tentaikhoan.getText().toString().trim());
//                                pst.setString(2, matkhau.getText().toString().trim());
//                                pst.executeUpdate();
//                                Toast.makeText(getApplicationContext(),"Đăng ký thành công", Toast.LENGTH_SHORT).show();
//                                startActivity(new Intent(Dangky.this, Dangnhap.class));
//                                connect.close();
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
