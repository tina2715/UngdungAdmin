package com.udgs123.ungdungadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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
import com.udgs123.ungdungadmin.Adapter.RecyclerViewAdapterHV;
import com.udgs123.ungdungadmin.Model.Hocvien;
import com.udgs123.ungdungadmin.Model.LoadingDialog;
import com.udgs123.ungdungadmin.Model.OnItemClickListener;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuanlyhocvienAc extends AppCompatActivity {
    RecyclerView myrecyclerview;
    Connection connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanlyhocvien);

        myrecyclerview = findViewById(R.id.hocvien_recyclerview);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapterHV recyclerViewAdaptador1 = new RecyclerViewAdapterHV( obtenerCantantesBD() );
        myrecyclerview.setAdapter(recyclerViewAdaptador1);
    }



    public List<Hocvien> obtenerCantantesBD() {
        List<Hocvien> hocviens = new ArrayList<>();

        try {
            ConnectHelper connectionHelper = new ConnectHelper();
            connect = connectionHelper.connections();
            if (connect == null) {
                Toast.makeText(this, "Kiểm tra kết nối", Toast.LENGTH_SHORT).show();
            } else {
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery("Select * from taikhoan_hv");
                while (rs.next()) {
                    hocviens.add(new Hocvien(rs.getString("hoten_hv"),
                            rs.getString("email_hv"), rs.getString("sdt_hv"),
                            rs.getString("diachi_hv")));
                }
            }

        } catch (SQLException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        return hocviens;
    }
}
