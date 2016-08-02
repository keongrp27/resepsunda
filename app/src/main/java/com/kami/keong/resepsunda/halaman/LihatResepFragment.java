package com.kami.keong.resepsunda.halaman;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.kami.keong.resepsunda.DBHelper;
import com.kami.keong.resepsunda.R;
import com.kami.keong.resepsunda.Resep.ResepBaseAdapter;
import com.kami.keong.resepsunda.Resep.TabelResep;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class LihatResepFragment extends Fragment {

    private ListView mListView;
    private ResepBaseAdapter mAdapter;
    private ArrayList<TabelResep> mList;
    private DBHelper database;

    public LihatResepFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v =  inflater.inflate(R.layout.fragment_lihat_resep, container, false);

        database = new DBHelper(getActivity());
        mList = database.getResep();
        mAdapter = new ResepBaseAdapter(getActivity(), mList);

        mListView = (ListView) v.findViewById(R.id.list_resep);
        mListView.setAdapter(mAdapter);

        return v;
    }

}
