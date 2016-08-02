package com.kami.keong.resepsunda.Resep;

/**
 * Created by keong on 19/06/2016.
 */
public class TabelGabung {

    public int id_resep;
    public int id_bahan;

    public String
        ket_bahan = "",
        alt_bahan1 = "",
        alt_bahan2 = "",
        nama_bahan = "",
        nama_resep = "",
        cara_masak = "",
        foto = "";

    public TabelGabung() {}

    public TabelGabung(int id_resep, int id_bahan, String ket_bahan, String alt_bahan1, String alt_bahan2,
                       String nama_bahan, String nama_resep, String cara_masak, String foto) {
        this.id_resep = id_resep;
        this.id_bahan = id_bahan;
        this.ket_bahan = ket_bahan;
        this.alt_bahan1 = alt_bahan1;
        this.alt_bahan2 = alt_bahan2;
        this.nama_bahan = nama_bahan;
        this.nama_resep = nama_resep;
        this.cara_masak = cara_masak;
        this.foto = foto;
    }
}