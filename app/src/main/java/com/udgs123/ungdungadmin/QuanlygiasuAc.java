package com.udgs123.ungdungadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.udgs123.ungdungadmin.Adapter.RecyclerViewAdapterGS;
import com.udgs123.ungdungadmin.Adapter.RecyclerViewAdapterHV;
import com.udgs123.ungdungadmin.Model.Giasu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuanlygiasuAc extends AppCompatActivity {
    RecyclerView myrecyclerview1;
    Connection connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_quanlygiasu);

        myrecyclerview1 = findViewById( R.id.giasu_recyclerview);

        myrecyclerview1.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapterGS recyclerViewAdapter = new RecyclerViewAdapterGS(mGiasu());
        myrecyclerview1.setAdapter(recyclerViewAdapter);
    }
    public List<Giasu> mGiasu() {
        List<Giasu> giasus = new ArrayList<>();
        try {
            ConnectHelper connectHelper = new ConnectHelper();
            connect=connectHelper.connections();
            if (connect==null) {
                Toast.makeText(this, "Lỗi kết nối",Toast.LENGTH_SHORT).show();
            } else {
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery("Select * from ttgs");
                while (rs.next()) {
                    giasus.add( new Giasu(
                            rs.getString("Tentaikhoangs"),
                            rs.getString("Hotengs"),
                            rs.getString("Ngaysinhgs"),
                            rs.getString("Emailgs"),
                            rs.getString("Sdtgs"),
                            rs.getString("Diachigs"),
                            rs.getString("Truongtheohoc"),
                            rs.getString("Chuyennganh"),
                            rs.getString("Tenmongs"),
                            rs.getString("Tentrinhdo")
                    ) );
                }
            }
        } catch (SQLException e) {
            Toast.makeText(this, e.getMessage(),Toast.LENGTH_SHORT).show();
        }
        return giasus;
    }
}
