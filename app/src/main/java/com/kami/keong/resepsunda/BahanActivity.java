package com.kami.keong.resepsunda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.kami.keong.resepsunda.Resep.ResepBaseAdapter;
import com.kami.keong.resepsunda.Resep.TabelResep;

import java.util.ArrayList;

public class BahanActivity extends AppCompatActivity {

    private ListView mListView;
    private ResepBaseAdapter mAdapter;
    private ArrayList<TabelResep> mList;
    private DBHelper database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bahan);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent in = getIntent();
        String text1 = in.getStringExtra("cari1");
        String text2 = in.getStringExtra("cari2");
        String text3 = in.getStringExtra("cari3");

        database = new DBHelper(this);
        mList = database.getCariResep(text1, text2, text3);
        mAdapter = new ResepBaseAdapter(this, mList);

        mListView = (ListView) findViewById(R.id.list_resep);
        mListView.setAdapter(mAdapter);

    }

}
