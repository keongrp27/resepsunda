package com.kami.keong.resepsunda.halaman;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kami.keong.resepsunda.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TentangFragment extends Fragment {




    public TentangFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tentang_, container, false);
    }

}
