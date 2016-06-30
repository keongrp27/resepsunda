package com.example.keong.resepsunda.halaman;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.keong.resepsunda.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LihatResep_fragment extends Fragment {



    public LihatResep_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lihat_resep, container, false);
    }

}
