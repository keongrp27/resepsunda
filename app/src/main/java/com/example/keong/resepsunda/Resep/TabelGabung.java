package com.example.keong.resepsunda.Resep;

/**
 * Created by keong on 19/06/2016.
 */
public class TabelGabung {

    public String
            id_resep = "",
            id_bahan = "",
            ket_bahan = "",
            alt_bahan1 = "",
            alt_bahan2 = "";

    public TabelGabung() {
    }

    public TabelGabung(String id_resep, String id_bahan, String ket_bahan, String alt_bahan1, String alt_bahan2)
    {
        this.id_resep = id_resep;
        this.id_bahan = id_bahan;
        this.ket_bahan = ket_bahan;
        this.alt_bahan1 = alt_bahan1;
        this.alt_bahan2 = alt_bahan2;
    }
}