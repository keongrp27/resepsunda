package com.example.keong.resepsunda.halaman;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.keong.resepsunda.DBHelper;
import com.example.keong.resepsunda.R;
import com.example.keong.resepsunda.Resep.TabelGabung;

import java.util.ArrayList;

public class ResepDetailActivity extends AppCompatActivity {

    private DBHelper db;
    private int idResep;
    private ArrayList<TabelGabung> mDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resep_detail);


        Toolbar bar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(bar);
        getSupportActionBar().setTitle(getIntent().getStringExtra("nm_resep"));


        db = new DBHelper(this);
        idResep = getIntent().getIntExtra("id_resep",1);
        mDataset = db.getDetailResep(idResep);

        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("BAHAN BAHAN");
        spec.setContent(R.id.tab1);
        spec.setIndicator("BAHAN BAHAN");
        host.addTab(spec);


        //Tab 2
        spec = host.newTabSpec("CARA MASAK");
        spec.setContent(R.id.tab2);
        spec.setIndicator("CARA MASAK");
        host.addTab(spec);

        TextView textBahan = (TextView) host.getTabContentView().findViewById(R.id.detail_resep_bahan);
        TextView textCara = (TextView) host.getTabContentView().findViewById(R.id.detail_resep_text);

        String caraMasak = "";
        String foto = "";
        StringBuilder bahan = new StringBuilder();

        for(TabelGabung item : mDataset) {
            bahan.append(item.nama_bahan + " <b>"+item.ket_bahan+"</b><br>");
            caraMasak = item.cara_masak;
            foto = item.foto;
        }

        textBahan.setText(Html.fromHtml(bahan.toString()));
        textCara.setText(caraMasak);
        ImageView gambarResep = (ImageView) findViewById(R.id.detail_resep_gambar);

        Glide.with(this).load(Uri.parse("file:///android_asset/gambar/"+foto)).into(gambarResep);
    }
}
