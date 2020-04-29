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

import com.udgs123.ungdungadmin.Adapter.RecyclerViewAdapterHV;
import com.udgs123.ungdungadmin.Model.Hocvien;
import com.udgs123.ungdungadmin.Model.LoadingDialog;
import com.udgs123.ungdungadmin.Model.OnItemClickListener;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class QuanlyhocvienAc extends AppCompatActivity {
RecyclerViewAdapterHV recyclerViewAdapterHV;
RecyclerView recyclerView;
ArrayList<Hocvien> hocviens;
    ArrayList<String> tentaikhoan = new ArrayList<String>();
    ArrayList<String> hoten = new ArrayList<String>();
    ArrayList<String> email = new ArrayList<String>();
    ArrayList<String> sdt = new ArrayList<String>();
    ArrayList<String> diachi = new ArrayList<String>();
    String[] tentaikhoanArr, hotenArr, emailArr, sdtArr, diachiArr;
    Connection connect;
    EditText edtTimhv;
    String textTimhv;
    Button btnTimhv;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanlyhocvien);
        recyclerView = findViewById(R.id.hocvien_recyclerview);
        edtTimhv = findViewById(R.id.edt_timhv);
        btnTimhv = findViewById(R.id.btn_timhv);

        hocviens = new ArrayList<>();
        tentaikhoan.clear();
        hoten.clear();
        email.clear();
        sdt.clear();
        diachi.clear();
        try {
            ConnectHelper connectHelper = new ConnectHelper();
            connect = connectHelper.connections();
            if(connect==null){
                Toast.makeText(getApplicationContext(),"Loi", Toast.LENGTH_SHORT).show();
            } else {
                String query = "SELECT * FROM tthv";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()){
                    tentaikhoan.add(rs.getString("Tentaikhoanhv"));
                    hoten.add(rs.getString("Hotenhv"));
                    email.add(rs.getString("Emailhv"));
                    sdt.add(rs.getString("Sdthv"));
                    diachi.add(rs.getString("Diachihv"));
                }
                tentaikhoanArr = new String[tentaikhoan.size()];
                tentaikhoanArr = tentaikhoan.toArray(tentaikhoanArr);
                hotenArr = new String[hoten.size()];
                hotenArr = hoten.toArray(hotenArr);
                emailArr = new String[email.size()];
                emailArr = email.toArray(emailArr);
                sdtArr = new String[sdt.size()];
                sdtArr = sdt.toArray(sdtArr);
                diachiArr = new String[diachi.size()];
                diachiArr = diachi.toArray(diachiArr);
                for (int i = 0; i < hoten.size();i++){
                    hocviens.add(new Hocvien(tentaikhoanArr[i],hotenArr[i],emailArr[i],sdtArr[i],diachiArr[i]));
                }
                connect.close();

            }
        } catch (Exception e) {
            Log.d("BBB", e.getMessage());
        }

        recyclerViewAdapterHV = new RecyclerViewAdapterHV(hocviens);
        recyclerView.setLayoutManager(new LinearLayoutManager(QuanlyhocvienAc.this));
        recyclerView.setAdapter(recyclerViewAdapterHV);
        if (recyclerView.getAdapter() != null) {
            ((RecyclerViewAdapterHV) recyclerView.getAdapter()).setOnItemClickListener( new OnItemClickListener() {
                @Override
                public void onClick(View v, @NonNull int position) {
                    LoadingDialog loadingDialog = new LoadingDialog();
                    loadingDialog.loading(QuanlyhocvienAc.this);
                    Intent detail = new Intent(QuanlyhocvienAc.this,Chitiet_hocvien.class);
                    detail.putExtra("tentaikhoan",tentaikhoanArr[position]);
                    startActivity(detail);
                }

                @Override
                public void onLongClick(View v, @NonNull int position) {

                }
            } );
        }
        btnTimhv.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tentaikhoan.clear();
                hoten.clear();
                email.clear();
                sdt.clear();
                diachi.clear();
                hocviens.clear();
                try {
                    ConnectHelper connectHelper = new ConnectHelper();
                    connect = connectHelper.connections();
                    if (connect==null){
                        Toast.makeText(getApplicationContext(),"Loi", Toast.LENGTH_SHORT).show();
                    } else if (edtTimhv.getText().toString().trim().equals("")){
                        edtTimhv.setError("Nhap thong tin tim kiem");
                        edtTimhv.requestFocus();
                    } else {
                        String query = "select * from tthv where Hotenhv like '"+edtTimhv.getText().toString().trim()+"'";
                        Statement st = connect.createStatement();
                        ResultSet rs = st.executeQuery(query);
                        while (rs.next()){
                            tentaikhoan.add(rs.getString("Tentaikhoanhv"));
                            hoten.add(rs.getString("Hotenhv"));
                            email.add(rs.getString("Emailhv"));
                            sdt.add(rs.getString("Sdthv"));
                            diachi.add(rs.getString("Diachihv"));
                        }
                        if (hoten.size()==0){
                            Toast.makeText(getApplicationContext(),"Không tìm thấy học viên nào",Toast.LENGTH_SHORT).show();
                        }
                        tentaikhoanArr = new String[tentaikhoan.size()];
                        tentaikhoanArr = tentaikhoan.toArray(tentaikhoanArr);
                        hotenArr = new String[hoten.size()];
                        hotenArr = hoten.toArray(hotenArr);
                        emailArr = new String[email.size()];
                        emailArr = email.toArray(emailArr);
                        sdtArr = new String[sdt.size()];
                        sdtArr = sdt.toArray(sdtArr);
                        diachiArr = new String[diachi.size()];
                        diachiArr = diachi.toArray(diachiArr);
                        for (int i = 0; i < hoten.size();i++){
                            hocviens.add(new Hocvien(tentaikhoanArr[i],hotenArr[i],emailArr[i],sdtArr[i],diachiArr[i]));
                        }
                        connect.close();

                    }
                } catch (Exception e) {
                    Log.d("BBB", e.getMessage());
                }
                recyclerViewAdapterHV = new RecyclerViewAdapterHV(hocviens);
                recyclerViewAdapterHV.notifyDataSetChanged();
                recyclerView.setLayoutManager(new LinearLayoutManager(QuanlyhocvienAc.this));
                recyclerView.setAdapter(recyclerViewAdapterHV);
                if (recyclerView.getAdapter() != null){
                    ((RecyclerViewAdapterHV) recyclerView.getAdapter()).setOnItemClickListener( new OnItemClickListener() {
                        @Override
                        public void onClick(View v, @NonNull int position) {
                            LoadingDialog loadingDialog = new LoadingDialog();
                            loadingDialog.loading(QuanlyhocvienAc.this);
                            Intent detail = new Intent(QuanlyhocvienAc.this,Chitiet_hocvien.class);

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







    }


}
