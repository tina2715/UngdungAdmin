package com.udgs123.ungdungadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.udgs123.ungdungadmin.Adapter.RecyclerViewAdapterLH;
import com.udgs123.ungdungadmin.Model.Lophoc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuanlylophocAc extends AppCompatActivity {
    Connection connect;
    private RecyclerView myrecyclerview;
    private List<Lophoc> lophocs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_quanlylophoc );
        myrecyclerview = findViewById(R.id.lophoc_recyclerview);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        RecyclerViewAdapterLH recyclerViewAdapter = new RecyclerViewAdapterLH(mLophoc());
        myrecyclerview.setAdapter(recyclerViewAdapter);
    }
    public List<Lophoc>mLophoc(){
        List<Lophoc> lophocs = new ArrayList<>();
        try {
            ConnectHelper connectionHelper = new ConnectHelper();
            connect = connectionHelper.connections();
            if (connect==null){
                Toast.makeText(getApplicationContext(),"Loi",Toast.LENGTH_SHORT).show();
            } else {
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery("Select * from Quanlylop");
                while (rs.next()){
                    lophocs.add(new Lophoc( rs.getString("Malophoc"),
                            rs.getString("Tentaikhoanhv"),
                            rs.getString("Caplop"),
                            rs.getString("Tenmonhoc"),
                            rs.getString("Diadiem"),
                            rs.getString("Ngaydukien"),
                            rs.getString("Soluonggio"),
                            rs.getString("Ngayhoctrongtuan"),
                            rs.getString("Giobatdau"),
                            rs.getString("Loaitrinhdo"),
                            rs.getString("Mota"),
                            rs.getString("Ngaytao"),
                            rs.getString("Trangthailop"),
                            rs.getString("Tentaikhoangs"),
                            rs.getString("Hocphi")
                    ));
                }
            }
        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
        return lophocs;
    }
}
