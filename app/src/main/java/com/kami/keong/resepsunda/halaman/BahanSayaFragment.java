package com.kami.keong.resepsunda.halaman;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.kami.keong.resepsunda.BahanActivity;
import com.kami.keong.resepsunda.DBHelper;
import com.kami.keong.resepsunda.R;
import com.kami.keong.resepsunda.Resep.TabelBahan;

/**
 * A simple {@link Fragment} subclass.
 */
public class BahanSayaFragment extends Fragment {

    private AutoCompleteTextView a1, a2, a3;
    private Button button;
    private DBHelper db;

    public BahanSayaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_bahan_saya_, container, false);

        a1 = (AutoCompleteTextView) v.findViewById(R.id.editText);
        a2 = (AutoCompleteTextView) v.findViewById(R.id.editText2);
        a3 = (AutoCompleteTextView) v.findViewById(R.id.editText3);

        db = new DBHelper(getActivity());
        String[] bahans =  new String[db.getBahan().size()];
        for(int i=0; i<db.getBahan().size(); i++) {
            bahans[i]= db.getBahan().get(i).nama_bahan;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.list_bahan, bahans);
        a1.setAdapter(adapter);
        a2.setAdapter(adapter);
        a3.setAdapter(adapter);

        button = (Button) v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), BahanActivity.class);
                in.putExtra("cari1", getIdBahan(a1.getText().toString()));
                in.putExtra("cari2", getIdBahan(a2.getText().toString()));
                in.putExtra("cari3", getIdBahan(a3.getText().toString()));
                startActivity(in);
            }
        });


        return v;
    }

    private String getIdBahan(String cari) {
        String idBahan = "0";
        for(TabelBahan item : db.getBahan()) {
            if(item.nama_bahan.equalsIgnoreCase(cari)) {
                idBahan = item.id_bahan;
                break;
            }
        }
        return idBahan;
    }


}
