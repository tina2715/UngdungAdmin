package com.udgs123.ungdungadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Trangchu extends AppCompatActivity {
    TextView tv_quanlygiasu, tv_quanlyhocvien, tv_quanlylophoc, tv_quanlyhocphi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_trangchu );
        tv_quanlygiasu = findViewById(R.id.tv_quanlygiasu);
        tv_quanlygiasu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent qlgsIntent = new Intent(Trangchu.this,QuanlygiasuAc.class);
                startActivity(qlgsIntent);
            }
        });
        tv_quanlyhocvien = findViewById(R.id.tv_quanlyhocvien);
        tv_quanlyhocvien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent qlhvIntent = new Intent(Trangchu.this,QuanlyhocvienAc.class);
                startActivity(qlhvIntent);
            }
        });
        tv_quanlylophoc = findViewById(R.id.tv_quanlylophoc);
        tv_quanlylophoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent qllhIntent = new Intent(Trangchu.this,QuanlylophocAc.class);
                startActivity(qllhIntent);
            }
        });
        tv_quanlyhocphi = findViewById(R.id.tv_quanlyhocphi);
        tv_quanlyhocphi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent qlhpIntent = new Intent(Trangchu.this,QuanlyhocphiAc.class);
                startActivity(qlhpIntent);
            }
        });
    }
}
