package com.example.keong.resepsunda.Resep;

/**
 * Created by keong on 19/06/2016.
 */
public class tabel_resep {

    public String
            id_resep = "",
            nama_resep = "",
            cara_masak = "",
            foto = "";

    public tabel_resep() {
    }

    public tabel_resep(String id_resep, String nama_resep, String cara_masak, String foto)
    {
        this.id_resep = id_resep;
        this.nama_resep = nama_resep;
        this.cara_masak = cara_masak;
        this.foto = foto;
    }
}