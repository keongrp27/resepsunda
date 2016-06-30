package com.example.keong.resepsunda.halaman;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.keong.resepsunda.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BahanSaya_Fragment extends Fragment {


    public BahanSaya_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_bahan_saya_, container, false);
        return v;
    }

}
