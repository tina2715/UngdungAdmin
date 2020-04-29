package com.udgs123.ungdungadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.thekhaeng.pushdownanim.PushDownAnim;
import com.udgs123.ungdungadmin.Adapter.RecyclerViewAdapterLH;
import com.udgs123.ungdungadmin.Model.LoadingDialog;
import com.udgs123.ungdungadmin.Model.Lophoc;
import com.udgs123.ungdungadmin.Model.OnItemClickListener;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuanlylophocAc extends AppCompatActivity {
    Connection connect;
    RecyclerView recyclerView;
    ArrayList<Lophoc> lophocs;
    RecyclerViewAdapterLH recyclerViewAdapterLH;
    ArrayList<String> malophoc = new ArrayList<>();
    ArrayList<String> tentaikhoanhv = new ArrayList<>();
    ArrayList<String> caplop = new ArrayList<>();
    ArrayList<String> tenmonhoc = new ArrayList<>();
    ArrayList<String> diadiem = new ArrayList<>();
    ArrayList<String> ngaydukien = new ArrayList<>();
    ArrayList<String> soluonggio = new ArrayList<>();
    ArrayList<String> ngayhoctrongtuan = new ArrayList<>();
    ArrayList<String> giobatdau = new ArrayList<>();
    ArrayList<String> loaitrinhdo = new ArrayList<>();
    ArrayList<String> mota = new ArrayList<>();
    ArrayList<String> ngaytao = new ArrayList<>();
    ArrayList<String> trangthailop = new ArrayList<>();
    ArrayList<String> tentaikhoangs = new ArrayList<>();
    ArrayList<String> hocphi = new ArrayList<>();
    String[] malophocArr, tentaikhoanhvArr, caplopArr, tenmonhocArr,diadiemArr,ngaydukienArr,soluonggioArr,
    ngayhoctrongtuanArr,giobatdauArr,loaitrinhdoArr,motaArr,ngaytaoArr,trangthailopArr, tentaikhoangsArr, hocphiArr;
    EditText edtTimlh;
    Button btnTimlh, btnChua, btnDa, btnKhoa, btnChuacogs;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_quanlylophoc );
        recyclerView = findViewById(R.id.lophoc_recyclerview);
        edtTimlh = findViewById(R.id.edt_timlh);
        btnTimlh = findViewById(R.id.btn_timlh);
        btnChua = findViewById(R.id.btn_chua_lop);
        btnDa = findViewById(R.id.btn_da_lop);
        btnKhoa = findViewById(R.id.btn_khoa_lop);
        btnChuacogs = findViewById( R.id.btn_chuacogs_lop );

        lophocs = new ArrayList<>();
        malophoc.clear();
        tentaikhoanhv.clear();
        caplop.clear();
        tenmonhoc.clear();
        diadiem.clear();
        ngaydukien.clear();
        soluonggio.clear();
        ngayhoctrongtuan.clear();
        giobatdau.clear();
        loaitrinhdo.clear();
        mota.clear();
        ngaytao.clear();
        trangthailop.clear();
        tentaikhoangs.clear();
        hocphi.clear();
        try {
            ConnectHelper connectHelper = new ConnectHelper();
            connect = connectHelper.connections();
            if (connect==null) {
                Toast.makeText(getApplicationContext(),"Loi",Toast.LENGTH_LONG).show();
            } else {
                String query = "SELECT * FROM Quanlylop";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    malophoc.add(rs.getString("Malophoc"));
                    tentaikhoanhv.add(rs.getString("Tentaikhoanhv"));
                    caplop.add(rs.getString("Caplop"));
                    tenmonhoc.add(rs.getString("Tenmonhoc"));
                    diadiem.add(rs.getString("Diadiem"));
                    ngaydukien.add(rs.getString("Ngaydukien"));
                    soluonggio.add(rs.getString("Soluonggio"));
                    ngayhoctrongtuan.add(rs.getString("Ngayhoctrongtuan"));
                    giobatdau.add(rs.getString("Giobatdau"));
                    loaitrinhdo.add(rs.getString("Loaitrinhdo"));
                    mota.add(rs.getString("Mota"));
                    ngaytao.add(rs.getString("Ngaytao"));
                    trangthailop.add(rs.getString("Trangthailop"));
                    tentaikhoangs.add(rs.getString("Tentaikhoangs"));
                    hocphi.add(rs.getString("Hocphi"));
                }
                malophocArr = new String[malophoc.size()];
                malophocArr = malophoc.toArray(malophocArr);
                tentaikhoanhvArr = new String[tentaikhoanhv.size()];
                tentaikhoanhvArr = tentaikhoanhv.toArray(tentaikhoanhvArr);
                caplopArr = new String[caplop.size()];
                caplopArr = caplop.toArray(caplopArr);
                tenmonhocArr = new String[tenmonhoc.size()];
                tenmonhocArr = tenmonhoc.toArray(tenmonhocArr);
                diadiemArr = new String[diadiem.size()];
                diadiemArr = diadiem.toArray(diadiemArr);
                ngaydukienArr = new String[ngaydukien.size()];
                ngaydukienArr = ngaydukien.toArray(ngaydukienArr);
                soluonggioArr = new String[soluonggio.size()];
                soluonggioArr = soluonggio.toArray(soluonggioArr);
                ngayhoctrongtuanArr = new String[ngayhoctrongtuan.size()];
                ngayhoctrongtuanArr = ngayhoctrongtuan.toArray(ngayhoctrongtuanArr);
                giobatdauArr = new String[giobatdau.size()];
                giobatdauArr = giobatdau.toArray(giobatdauArr);
                loaitrinhdoArr = new String[loaitrinhdo.size()];
                loaitrinhdoArr = loaitrinhdo.toArray(loaitrinhdoArr);
                motaArr = new String[mota.size()];
                motaArr = mota.toArray(motaArr);
                ngaytaoArr = new String[ngaytao.size()];
                ngaytaoArr = ngaytao.toArray(ngaytaoArr);
                trangthailopArr = new String[trangthailop.size()];
                trangthailopArr = trangthailop.toArray(trangthailopArr);
                tentaikhoangsArr = new String[tentaikhoangs.size()];
                tentaikhoangsArr = tentaikhoangs.toArray(tentaikhoangsArr);
                hocphiArr = new String[hocphi.size()];
                hocphiArr = hocphi.toArray(hocphiArr);
                for (int i = 0; i < caplop.size(); i++) {
                    lophocs.add(new Lophoc(malophocArr[i],tentaikhoanhvArr[i],caplopArr[i],tenmonhocArr[i],diadiemArr[i],ngaydukienArr[i],soluonggioArr[i],ngayhoctrongtuanArr[i],giobatdauArr[i],loaitrinhdoArr[i],motaArr[i],ngaytaoArr[i],trangthailopArr[i],tentaikhoangsArr[i],hocphiArr[i]));
                }
                connect.close();
            }
        } catch (Exception e)
        {
            Log.d("BBB", e.getMessage());
        }
        recyclerViewAdapterLH = new RecyclerViewAdapterLH(lophocs);
        recyclerView.setLayoutManager(new LinearLayoutManager(QuanlylophocAc.this));
        recyclerView.setAdapter(recyclerViewAdapterLH);
        if (recyclerView.getAdapter() != null) {
            ((RecyclerViewAdapterLH) recyclerView.getAdapter()).setOnItemClickListener( new OnItemClickListener() {
                @Override
                public void onClick(View v, @NonNull int position) {
                    LoadingDialog loadingDialog = new LoadingDialog();
                    loadingDialog.loading(QuanlylophocAc.this);
                    Intent detail = new Intent(QuanlylophocAc.this, Chitiet_lophoc.class);
                    detail.putExtra("malophoc", malophocArr[position]);
                    startActivity(detail);
                }

                @Override
                public void onLongClick(View v, @NonNull int position) {

                }
            } );
        }
        btnTimlh.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                malophoc.clear();
                tentaikhoanhv.clear();
                caplop.clear();
                tenmonhoc.clear();
                diadiem.clear();
                ngaydukien.clear();
                soluonggio.clear();
                ngayhoctrongtuan.clear();
                giobatdau.clear();
                loaitrinhdo.clear();
                mota.clear();
                ngaytao.clear();
                trangthailop.clear();
                tentaikhoangs.clear();
                hocphi.clear();
                lophocs.clear();
                try {
                    ConnectHelper connectHelper = new ConnectHelper();
                    connect = connectHelper.connections();
                    if (connect==null){
                        Toast.makeText(getApplicationContext(),"Lỗi kết nối", Toast.LENGTH_LONG).show();
                    } else if (edtTimlh.getText().toString().trim().equals("")){
                        edtTimlh.setError("Nhập thông tin tìm kiếm");
                        edtTimlh.requestFocus();
                    } else {
                        String query = "select * from Quanlylop where Malophoc = '"+edtTimlh.getText().toString().trim()+"'";
                        Statement st = connect.createStatement();
                        ResultSet rs = st.executeQuery(query);
                        while (rs.next()){
                            malophoc.add(rs.getString("Malophoc"));
                            tentaikhoanhv.add(rs.getString("Tentaikhoanhv"));
                            caplop.add(rs.getString("Caplop"));
                            tenmonhoc.add(rs.getString("Tenmonhoc"));
                            diadiem.add(rs.getString("Diadiem"));
                            ngaydukien.add(rs.getString("Ngaydukien"));
                            soluonggio.add(rs.getString("Soluonggio"));
                            ngayhoctrongtuan.add(rs.getString("Ngayhoctrongtuan"));
                            giobatdau.add(rs.getString("Giobatdau"));
                            loaitrinhdo.add(rs.getString("Loaitrinhdo"));
                            mota.add(rs.getString("Mota"));
                            ngaytao.add(rs.getString("Ngaytao"));
                            trangthailop.add(rs.getString("Trangthailop"));
                            tentaikhoangs.add(rs.getString("Tentaikhoangs"));
                            hocphi.add(rs.getString("Hocphi"));
                        }
                        if (malophoc.size()==0){
                            Toast.makeText(getApplicationContext(),"Không tìm thấy lớp nào",Toast.LENGTH_LONG).show();
                        }
                        malophocArr = new String[malophoc.size()];
                        malophocArr = malophoc.toArray(malophocArr);
                        tentaikhoanhvArr = new String[tentaikhoanhv.size()];
                        tentaikhoanhvArr = tentaikhoanhv.toArray(tentaikhoanhvArr);
                        caplopArr = new String[caplop.size()];
                        caplopArr = caplop.toArray(caplopArr);
                        tenmonhocArr = new String[tenmonhoc.size()];
                        tenmonhocArr = tenmonhoc.toArray(tenmonhocArr);
                        diadiemArr = new String[diadiem.size()];
                        diadiemArr = diadiem.toArray(diadiemArr);
                        ngaydukienArr = new String[ngaydukien.size()];
                        ngaydukienArr = ngaydukien.toArray(ngaydukienArr);
                        soluonggioArr = new String[soluonggio.size()];
                        soluonggioArr = soluonggio.toArray(soluonggioArr);
                        ngayhoctrongtuanArr = new String[ngayhoctrongtuan.size()];
                        ngayhoctrongtuanArr = ngayhoctrongtuan.toArray(ngayhoctrongtuanArr);
                        giobatdauArr = new String[giobatdau.size()];
                        giobatdauArr = giobatdau.toArray(giobatdauArr);
                        loaitrinhdoArr = new String[loaitrinhdo.size()];
                        loaitrinhdoArr = loaitrinhdo.toArray(loaitrinhdoArr);
                        motaArr = new String[mota.size()];
                        motaArr = mota.toArray(motaArr);
                        ngaytaoArr = new String[ngaytao.size()];
                        ngaytaoArr = ngaytao.toArray(ngaytaoArr);
                        trangthailopArr = new String[trangthailop.size()];
                        trangthailopArr = trangthailop.toArray(trangthailopArr);
                        tentaikhoangsArr = new String[tentaikhoangs.size()];
                        tentaikhoangsArr = tentaikhoangs.toArray(tentaikhoangsArr);
                        hocphiArr = new String[hocphi.size()];
                        hocphiArr = hocphi.toArray(hocphiArr);
                        for (int i = 0; i < caplop.size(); i++) {
                            lophocs.add(new Lophoc(malophocArr[i],tentaikhoanhvArr[i],caplopArr[i],tenmonhocArr[i],diadiemArr[i],ngaydukienArr[i],soluonggioArr[i],ngayhoctrongtuanArr[i],giobatdauArr[i],loaitrinhdoArr[i],motaArr[i],ngaytaoArr[i],trangthailopArr[i],tentaikhoangsArr[i],hocphiArr[i]));
                        }
                        connect.close();

                    }
                } catch (Exception e) {
                    Log.d("BBB", e.getMessage());
                }
                recyclerViewAdapterLH = new RecyclerViewAdapterLH(lophocs);
                recyclerViewAdapterLH.notifyDataSetChanged();
                recyclerView.setLayoutManager(new LinearLayoutManager(QuanlylophocAc.this));
                recyclerView.setAdapter(recyclerViewAdapterLH);
                if (recyclerView.getAdapter() != null) {
                    ((RecyclerViewAdapterLH) recyclerView.getAdapter()).setOnItemClickListener( new OnItemClickListener() {
                        @Override
                        public void onClick(View v, @NonNull int position) {
                            LoadingDialog loadingDialog = new LoadingDialog();
                            loadingDialog.loading(QuanlylophocAc.this);
                            Intent detail = new Intent(QuanlylophocAc.this, Chitiet_lophoc.class);
                            detail.putExtra("malophoc", malophocArr[position]);
                            startActivity(detail);
                        }

                        @Override
                        public void onLongClick(View v, @NonNull int position) {

                        }
                    } );
                }

            }
        } );
        PushDownAnim.setPushDownAnimTo(btnChuacogs).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                option(0);
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
                option(3);
            }
        } );
    }
    private void option(Integer status){
        malophoc.clear();
        tentaikhoanhv.clear();
        caplop.clear();
        tenmonhoc.clear();
        diadiem.clear();
        ngaydukien.clear();
        soluonggio.clear();
        ngayhoctrongtuan.clear();
        giobatdau.clear();
        loaitrinhdo.clear();
        mota.clear();
        ngaytao.clear();
        trangthailop.clear();
        tentaikhoangs.clear();
        hocphi.clear();
        lophocs.clear();
        try {
            ConnectHelper connectHelper = new ConnectHelper();
            connect = connectHelper.connections();
            if (connect==null){
                Toast.makeText(getApplicationContext(),"Lỗi kết nối", Toast.LENGTH_LONG).show();
            } else {
                String query = "SELECT * FROM Quanlylop WHERE Trangthailop='"+status+"'";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    malophoc.add(rs.getString("Malophoc"));
                    tentaikhoanhv.add(rs.getString("Tentaikhoanhv"));
                    caplop.add(rs.getString("Caplop"));
                    tenmonhoc.add(rs.getString("Tenmonhoc"));
                    diadiem.add(rs.getString("Diadiem"));
                    ngaydukien.add(rs.getString("Ngaydukien"));
                    soluonggio.add(rs.getString("Soluonggio"));
                    ngayhoctrongtuan.add(rs.getString("Ngayhoctrongtuan"));
                    giobatdau.add(rs.getString("Giobatdau"));
                    loaitrinhdo.add(rs.getString("Loaitrinhdo"));
                    mota.add(rs.getString("Mota"));
                    ngaytao.add(rs.getString("Ngaytao"));
                    trangthailop.add(rs.getString("Trangthailop"));
                    tentaikhoangs.add(rs.getString("Tentaikhoangs"));
                    hocphi.add(rs.getString("Hocphi"));
                }
                if (malophoc.size()==0){
                    Toast.makeText(getApplicationContext(),"Không tìm thấy lớp nào",Toast.LENGTH_LONG).show();
                }
                malophocArr = new String[malophoc.size()];
                malophocArr = malophoc.toArray(malophocArr);
                tentaikhoanhvArr = new String[tentaikhoanhv.size()];
                tentaikhoanhvArr = tentaikhoanhv.toArray(tentaikhoanhvArr);
                caplopArr = new String[caplop.size()];
                caplopArr = caplop.toArray(caplopArr);
                tenmonhocArr = new String[tenmonhoc.size()];
                tenmonhocArr = tenmonhoc.toArray(tenmonhocArr);
                diadiemArr = new String[diadiem.size()];
                diadiemArr = diadiem.toArray(diadiemArr);
                ngaydukienArr = new String[ngaydukien.size()];
                ngaydukienArr = ngaydukien.toArray(ngaydukienArr);
                soluonggioArr = new String[soluonggio.size()];
                soluonggioArr = soluonggio.toArray(soluonggioArr);
                ngayhoctrongtuanArr = new String[ngayhoctrongtuan.size()];
                ngayhoctrongtuanArr = ngayhoctrongtuan.toArray(ngayhoctrongtuanArr);
                giobatdauArr = new String[giobatdau.size()];
                giobatdauArr = giobatdau.toArray(giobatdauArr);
                loaitrinhdoArr = new String[loaitrinhdo.size()];
                loaitrinhdoArr = loaitrinhdo.toArray(loaitrinhdoArr);
                motaArr = new String[mota.size()];
                motaArr = mota.toArray(motaArr);
                ngaytaoArr = new String[ngaytao.size()];
                ngaytaoArr = ngaytao.toArray(ngaytaoArr);
                trangthailopArr = new String[trangthailop.size()];
                trangthailopArr = trangthailop.toArray(trangthailopArr);
                tentaikhoangsArr = new String[tentaikhoangs.size()];
                tentaikhoangsArr = tentaikhoangs.toArray(tentaikhoangsArr);
                hocphiArr = new String[hocphi.size()];
                hocphiArr = hocphi.toArray(hocphiArr);
                for (int i = 0; i < caplop.size(); i++) {
                    lophocs.add(new Lophoc(malophocArr[i],tentaikhoanhvArr[i],caplopArr[i],tenmonhocArr[i],diadiemArr[i],ngaydukienArr[i],soluonggioArr[i],ngayhoctrongtuanArr[i],giobatdauArr[i],loaitrinhdoArr[i],motaArr[i],ngaytaoArr[i],trangthailopArr[i],tentaikhoangsArr[i],hocphiArr[i]));
                }
                connect.close();
            }
        } catch (Exception e) {
            Log.d("BBB", e.getMessage());
        }
        recyclerViewAdapterLH = new RecyclerViewAdapterLH(lophocs);
        recyclerViewAdapterLH.notifyDataSetChanged();
        recyclerView.setLayoutManager(new LinearLayoutManager(QuanlylophocAc.this));
        recyclerView.setAdapter(recyclerViewAdapterLH);
        if (recyclerView.getAdapter() != null) {
            ((RecyclerViewAdapterLH) recyclerView.getAdapter()).setOnItemClickListener( new OnItemClickListener() {
                @Override
                public void onClick(View v, @NonNull int position) {
                    LoadingDialog loadingDialog = new LoadingDialog();
                    loadingDialog.loading(QuanlylophocAc.this);
                    Intent detail = new Intent(QuanlylophocAc.this, Chitiet_lophoc.class);
                    detail.putExtra("malophoc", malophocArr[position]);
                    startActivity(detail);
                }

                @Override
                public void onLongClick(View v, @NonNull int position) {

                }
            } );
        }


    }
}
