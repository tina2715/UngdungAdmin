package com.udgs123.ungdungadmin;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Chitiet_hocvien extends AppCompatActivity {
    TextView tentaikhoanhv, hoten, email, sdt, diachi;
    Button btnXoa;
    Connection connect;
    String tentaikhoan;
    int REQUEST_CODE_UPDATE = 1997;


 protected void onCreate (Bundle savedInstanceState){
     super.onCreate(savedInstanceState);
     setContentView(R.layout.dialog_chitiet_hocvien);
     tentaikhoanhv = findViewById(R.id.tv_tentaikhoanhv_ct);
     hoten = findViewById(R.id.tv_hotenhv_ct);
     email = findViewById(R.id.tv_emailhv_ct);
     sdt = findViewById(R.id.tv_sdthv_ct);
     diachi = findViewById(R.id.tv_diachihv_ct);
     tentaikhoan = getIntent().getStringExtra("tentaikhoan");
     tentaikhoanhv.setText(tentaikhoan);

     try {
         ConnectHelper connectHelper = new ConnectHelper();
         connect = connectHelper.connections();
         if (connect==null){
             Toast.makeText(getApplicationContext(),"Loi",Toast.LENGTH_LONG).show();
         } else {
             String query = "SELECT * FROM tthv WHERE Tentaikhoanhv='"+tentaikhoan+"'";
             Statement st = connect.createStatement();
             ResultSet rs = st.executeQuery(query);
             if (rs.next()){
                 tentaikhoanhv.setText(rs.getString("Tentaikhoanhv"));
                 hoten.setText(rs.getString("Hotenhv"));
                 email.setText(rs.getString("Emailhv"));
                 sdt.setText(rs.getString("Sdthv"));
                 diachi.setText(rs.getString("Diachihv"));
             }

         }
     } catch (Exception e){
         Log.d("BBB", e.getMessage());
     }

 }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==REQUEST_CODE_UPDATE && resultCode==RESULT_OK && data != null){
            finish();
            Intent intent = new Intent(Chitiet_hocvien.this, Chitiet_hocvien.class);
            intent.putExtra("tentaikhoan",tentaikhoan);
            startActivity(intent);
        }

        super.onActivityResult( requestCode, resultCode, data );
    }

}
