package com.kami.keong.resepsunda.Resep;

/**
 * Created by keong on 19/06/2016.
 */
public class TabelResep {

    public int id_resep;
    public String
            nama_resep = "",
            cara_masak = "",
            foto = "";

    public TabelResep(int id_resep, String nama_resep, String cara_masak, String foto)
    {
        this.id_resep = id_resep;
        this.nama_resep = nama_resep;
        this.cara_masak = cara_masak;
        this.foto = foto;
    }
}