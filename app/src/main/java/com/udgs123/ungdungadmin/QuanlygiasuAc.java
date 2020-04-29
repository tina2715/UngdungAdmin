package com.udgs123.ungdungadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.thekhaeng.pushdownanim.PushDownAnim;
import com.udgs123.ungdungadmin.Adapter.RecyclerViewAdapterGS;
import com.udgs123.ungdungadmin.Adapter.RecyclerViewAdapterHV;
import com.udgs123.ungdungadmin.Model.Giasu;
import com.udgs123.ungdungadmin.Model.LoadingDialog;
import com.udgs123.ungdungadmin.Model.OnItemClickListener;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuanlygiasuAc extends AppCompatActivity {
//    RecyclerView myrecyclerview1;
//    Connection connect;
    RecyclerView recyclerView;
    ArrayList<Giasu> giaSus;
    RecyclerViewAdapterGS recyclerViewAdapterGS;
    ArrayList<String> tentaikhoan = new ArrayList<String>();
    ArrayList<String> hoten = new ArrayList<String>();
    ArrayList<String> ngaysinh = new ArrayList<String>();
    ArrayList<String> email = new ArrayList<String>();
    ArrayList<String> sdt = new ArrayList<String>();
    ArrayList<String> diachi = new ArrayList<String>();
    ArrayList<String> truongtheohoc = new ArrayList<String>();
    ArrayList<String> chuyennganh = new ArrayList<String>();
    ArrayList<String> tenmon = new ArrayList<String>();
    ArrayList<String> trinhdo = new ArrayList<String>();
    String[] tentaikhoanArr, hotenArr, ngaysinhArr, emailArr, sdtArr, diachiArr, truongtheohocArr, chuyennganhArr, tenmonArr, trinhdoArr;
    Connection connect;
    EditText edtTimgs;
    String textTimgs;
    Button btnTimgs, btnChua, btnDa, btnKhoa;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_quanlygiasu);

        recyclerView = findViewById(R.id.giasu_recyclerview);
        edtTimgs = findViewById(R.id.edt_timgs);
        btnTimgs = findViewById(R.id.btn_timgs);
        btnChua = findViewById(R.id.btn_chua);
        btnDa = findViewById(R.id.btn_da);
        btnKhoa = findViewById(R.id.btn_khoa);

        giaSus = new ArrayList<>();
        tentaikhoan.clear();
        hoten.clear();
        ngaysinh.clear();
        email.clear();
        sdt.clear();
        diachi.clear();
        truongtheohoc.clear();
        chuyennganh.clear();
        tenmon.clear();
        trinhdo.clear();
        try {
            ConnectHelper connectHelper = new ConnectHelper();
            connect = connectHelper.connections();
            if(connect==null){
                Toast.makeText(getApplicationContext(),"Loi", Toast.LENGTH_SHORT).show();
            } else {
                String query = "SELECT * FROM ttgs";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()){
                    tentaikhoan.add(rs.getString("Tentaikhoangs"));
                    hoten.add(rs.getString("Hotengs"));
                    ngaysinh.add(rs.getString("Ngaysinhgs"));
                    email.add(rs.getString("Emailgs"));
                    sdt.add(rs.getString("Sdtgs"));
                    diachi.add(rs.getString("Diachigs"));
                    truongtheohoc.add(rs.getString("Truongtheohoc"));
                    chuyennganh.add(rs.getString("Chuyennganh"));
                    tenmon.add(rs.getString("Tenmongs"));
                    trinhdo.add(rs.getString("Tentrinhdo"));
                }
                tentaikhoanArr = new String[tentaikhoan.size()];
                tentaikhoanArr = tentaikhoan.toArray(tentaikhoanArr);
                hotenArr = new String[hoten.size()];
                hotenArr = hoten.toArray(hotenArr);
                ngaysinhArr = new String[ngaysinh.size()];
                ngaysinhArr = ngaysinh.toArray(ngaysinhArr);
                emailArr = new String[email.size()];
                emailArr = email.toArray(emailArr);
                sdtArr = new String[sdt.size()];
                sdtArr = sdt.toArray(sdtArr);
                diachiArr = new String[diachi.size()];
                diachiArr = diachi.toArray(diachiArr);
                truongtheohocArr = new String[truongtheohoc.size()];
                truongtheohocArr = truongtheohoc.toArray(truongtheohocArr);
                chuyennganhArr = new String[chuyennganh.size()];
                chuyennganhArr = chuyennganh.toArray(chuyennganhArr);
                tenmonArr = new String[tenmon.size()];
                tenmonArr = tenmon.toArray(tenmonArr);
                trinhdoArr = new String[trinhdo.size()];
                trinhdoArr = trinhdo.toArray(trinhdoArr);
                for (int i = 0; i < hoten.size();i++){
                    giaSus.add(new Giasu(tentaikhoanArr[i],hotenArr[i],ngaysinhArr[i],emailArr[i],sdtArr[i],diachiArr[i],truongtheohocArr[i],chuyennganhArr[i],tenmonArr[i],trinhdoArr[i]));
                }
                connect.close();

            }
        } catch (Exception e) {
            Log.d("BBB", e.getMessage());
        }

        recyclerViewAdapterGS = new RecyclerViewAdapterGS(giaSus);
        recyclerView.setLayoutManager(new LinearLayoutManager(QuanlygiasuAc.this));
        recyclerView.setAdapter(recyclerViewAdapterGS);
        if (recyclerView.getAdapter() != null) {
            ((RecyclerViewAdapterGS) recyclerView.getAdapter()).setOnItemClickListener( new OnItemClickListener() {
                @Override
                public void onClick(View v, @NonNull int position) {
                    LoadingDialog loadingDialog = new LoadingDialog();
                    loadingDialog.loading(QuanlygiasuAc.this);
                    Intent detail = new Intent(QuanlygiasuAc.this,Chitiet_giasu.class);
                    detail.putExtra("tentaikhoan",tentaikhoanArr[position]);
                    startActivity(detail);
                }

                @Override
                public void onLongClick(View v, @NonNull int position) {

                }
            } );
        }
        btnTimgs.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tentaikhoan.clear();
                hoten.clear();
                ngaysinh.clear();
                email.clear();
                sdt.clear();
                diachi.clear();
                truongtheohoc.clear();
                chuyennganh.clear();
                tenmon.clear();
                trinhdo.clear();
                giaSus.clear();
                try {
                    ConnectHelper connectHelper = new ConnectHelper();
                    connect = connectHelper.connections();
                    if (connect==null){
                        Toast.makeText(getApplicationContext(),"Loi", Toast.LENGTH_SHORT).show();
                    } else if (edtTimgs.getText().toString().trim().equals("")){
                        edtTimgs.setError("Nhập thông tin tìm kiếm");
                        edtTimgs.requestFocus();
                    } else {
                        String query = "select * from ttgs where Hotengs like '"+edtTimgs.getText().toString().trim()+"'";
                        Statement st = connect.createStatement();
                        ResultSet rs = st.executeQuery(query);
                        while (rs.next()){
                            tentaikhoan.add(rs.getString("Tentaikhoangs"));
                            hoten.add(rs.getString("Hotengs"));
                            ngaysinh.add(rs.getString("Ngaysinhgs"));
                            email.add(rs.getString("Emailgs"));
                            sdt.add(rs.getString("Sdtgs"));
                            diachi.add(rs.getString("Diachigs"));
                            truongtheohoc.add(rs.getString("Truongtheohoc"));
                            chuyennganh.add(rs.getString("Chuyennganh"));
                            tenmon.add(rs.getString("Tenmongs"));
                            trinhdo.add(rs.getString("Tentrinhdo"));
                        }
                        if (hoten.size()==0){
                            Toast.makeText(getApplicationContext(),"Khong tim thay gia su nao",Toast.LENGTH_SHORT).show();
                        }
                        tentaikhoanArr = new String[tentaikhoan.size()];
                        tentaikhoanArr = tentaikhoan.toArray(tentaikhoanArr);
                        hotenArr = new String[hoten.size()];
                        hotenArr = hoten.toArray(hotenArr);
                        ngaysinhArr = new String[ngaysinh.size()];
                        ngaysinhArr = ngaysinh.toArray(ngaysinhArr);
                        emailArr = new String[email.size()];
                        emailArr = email.toArray(emailArr);
                        sdtArr = new String[sdt.size()];
                        sdtArr = sdt.toArray(sdtArr);
                        diachiArr = new String[diachi.size()];
                        diachiArr = diachi.toArray(diachiArr);
                        truongtheohocArr = new String[truongtheohoc.size()];
                        truongtheohocArr = truongtheohoc.toArray(truongtheohocArr);
                        chuyennganhArr = new String[chuyennganh.size()];
                        chuyennganhArr = chuyennganh.toArray(chuyennganhArr);
                        tenmonArr = new String[tenmon.size()];
                        tenmonArr = tenmon.toArray(tenmonArr);
                        trinhdoArr = new String[trinhdo.size()];
                        trinhdoArr = trinhdo.toArray(trinhdoArr);
                        for (int i = 0; i < hoten.size();i++){
                            giaSus.add(new Giasu(tentaikhoanArr[i],hotenArr[i],ngaysinhArr[i],emailArr[i],sdtArr[i],diachiArr[i],truongtheohocArr[i],chuyennganhArr[i],tenmonArr[i],trinhdoArr[i]));
                        }
                        connect.close();

                    }
                } catch (Exception e) {
                    Log.d("BBB", e.getMessage());
                }
                recyclerViewAdapterGS = new RecyclerViewAdapterGS(giaSus);
                recyclerViewAdapterGS.notifyDataSetChanged();
                recyclerView.setLayoutManager(new LinearLayoutManager(QuanlygiasuAc.this));
                recyclerView.setAdapter(recyclerViewAdapterGS);
                if (recyclerView.getAdapter() != null){
                    ((RecyclerViewAdapterGS) recyclerView.getAdapter()).setOnItemClickListener( new OnItemClickListener() {
                        @Override
                        public void onClick(View v, @NonNull int position) {
                            LoadingDialog loadingDialog = new LoadingDialog();
                            loadingDialog.loading(QuanlygiasuAc.this);
                            Intent detail = new Intent(QuanlygiasuAc.this,Chitiet_giasu.class);

                            detail.putExtra("tentaikhoan", tentaikhoanArr[position]);
                            startActivity(detail);
                        }

                        @Override
                        public void onLongClick(View v, @NonNull int position) {

                        }
                    } );

                }

            }
        } );
        PushDownAnim.setPushDownAnimTo(btnChua).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                option(1);
            }
        } );
        PushDownAnim.setPushDownAnimTo(btnDa).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                option(2);
            }
        } );
        PushDownAnim.setPushDownAnimTo(btnKhoa).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                option(0);
            }
        } );

    }
    private void option(Integer status){
        tentaikhoan.clear();
        hoten.clear();
        ngaysinh.clear();
        email.clear();
        sdt.clear();
        diachi.clear();
        truongtheohoc.clear();
        chuyennganh.clear();
        tenmon.clear();
        trinhdo.clear();
        giaSus.clear();

        try {
            ConnectHelper connectHelper = new ConnectHelper();
            connect = connectHelper.connections();
            if (connect==null) {
                Toast.makeText(getApplicationContext(),"Loi", Toast.LENGTH_SHORT).show();
            } else {
                String query = "SELECT * FROM ttgs WHERE Trangthainguoidung='"+status+"'";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()){
                    tentaikhoan.add(rs.getString("Tentaikhoangs"));
                    hoten.add(rs.getString("Hotengs"));
                    ngaysinh.add(rs.getString("Ngaysinhgs"));
                    email.add(rs.getString("Emailgs"));
                    sdt.add(rs.getString("Sdtgs"));
                    diachi.add(rs.getString("Diachigs"));
                    truongtheohoc.add(rs.getString("Truongtheohoc"));
                    chuyennganh.add(rs.getString("Chuyennganh"));
                    tenmon.add(rs.getString("Tenmongs"));
                    trinhdo.add(rs.getString("Tentrinhdo"));
                }
                if (hoten.size()==0){
                    Toast.makeText(getApplicationContext(),"Khong tim thay gia su",Toast.LENGTH_SHORT).show();
                }
                tentaikhoanArr = new String[tentaikhoan.size()];
                tentaikhoanArr = tentaikhoan.toArray(tentaikhoanArr);
                hotenArr = new String[hoten.size()];
                hotenArr = hoten.toArray(hotenArr);
                ngaysinhArr = new String[ngaysinh.size()];
                ngaysinhArr = ngaysinh.toArray(ngaysinhArr);
                emailArr = new String[email.size()];
                emailArr = email.toArray(emailArr);
                sdtArr = new String[sdt.size()];
                sdtArr = sdt.toArray(sdtArr);
                diachiArr = new String[diachi.size()];
                diachiArr = diachi.toArray(diachiArr);
                truongtheohocArr = new String[truongtheohoc.size()];
                truongtheohocArr = truongtheohoc.toArray(truongtheohocArr);
                chuyennganhArr = new String[chuyennganh.size()];
                chuyennganhArr = chuyennganh.toArray(chuyennganhArr);
                tenmonArr = new String[tenmon.size()];
                tenmonArr = tenmon.toArray(tenmonArr);
                trinhdoArr = new String[trinhdo.size()];
                trinhdoArr = trinhdo.toArray(trinhdoArr);
                for (int i = 0; i < hoten.size();i++){
                    giaSus.add(new Giasu(tentaikhoanArr[i],hotenArr[i],ngaysinhArr[i],emailArr[i],sdtArr[i],diachiArr[i],truongtheohocArr[i],chuyennganhArr[i],tenmonArr[i],trinhdoArr[i]));
                }
                connect.close();
            }

        } catch (Exception e) {
            Log.d("BBB", e.getMessage());
        }
        recyclerViewAdapterGS = new RecyclerViewAdapterGS(giaSus);
        recyclerViewAdapterGS.notifyDataSetChanged();
        recyclerView.setLayoutManager(new LinearLayoutManager(QuanlygiasuAc.this));
        recyclerView.setAdapter(recyclerViewAdapterGS);
        if (recyclerView.getAdapter() != null){
            ((RecyclerViewAdapterGS) recyclerView.getAdapter()).setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onClick(View v, @NonNull int position) {
                    LoadingDialog loadingDialog = new LoadingDialog();
                    loadingDialog.loading(QuanlygiasuAc.this);
                    Intent detail = new Intent(QuanlygiasuAc.this,Chitiet_giasu.class);
                    detail.putExtra("tentaikhoan", tentaikhoanArr[position]);
                    startActivity(detail);
                }

                @Override
                public void onLongClick(View v, @NonNull int position) {

                }
            } );
        }
    }
}
