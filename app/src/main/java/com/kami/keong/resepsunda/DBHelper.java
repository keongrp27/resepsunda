package com.kami.keong.resepsunda;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.kami.keong.resepsunda.Resep.TabelBahan;
import com.kami.keong.resepsunda.Resep.TabelGabung;
import com.kami.keong.resepsunda.Resep.TabelResep;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

/**
 * Created by keong on 23/07/2016.
 */
public class DBHelper extends SQLiteAssetHelper {

    public static final String DATABASE_NAME = "resep.db";

    public static final String
            tabel_bahan  = "TabelBahan",
            id_bahan = "id_bahan" ,
            nama_bahan = "nama_bahan",

            tabel_gabung = "TabelGabung",
            ket_bahan = "ket_bahan",
            altbahan1 = "altbahan1",
            altbahan2 = "altbahan2",

            tabel_resep  = "TabelResep",
            id_resep = "id_resep" ,
            nama_resep = "nama_resep," ,
            cara_masak =  "cara_masak" ,
            foto = "foto";

    public DBHelper(Context context) {super(context, DATABASE_NAME, null, 1);}

    public ArrayList<TabelResep> getResep() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<TabelResep> mDataset = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT  * FROM tabel_resep", null);

        if (c.moveToFirst()) {
            do {
                TabelResep item = new TabelResep(
                        c.getInt(c.getColumnIndex("id_resep")),
                        c.getString(c.getColumnIndex("nama_resep")),
                        c.getString(c.getColumnIndex("cara_masak")),
                        c.getString(c.getColumnIndex("foto")));
                mDataset.add(item);
            } while (c.moveToNext());
        }

        c.close();
        return mDataset;
    }

    public ArrayList<TabelGabung> getDetailResep(int idResep) {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<TabelGabung> mDataset = new ArrayList<>();
        Cursor c = db.rawQuery("select a.*, b.nama_bahan, c.nama_resep, c.cara_masak, c.foto  from tabel_gabung a inner join tabel_bahan b on a.id_bahan = b.id_bahan inner join tabel_resep c on a.id_resep = c.id_resep where a.id_resep = "+idResep, null);

        if (c.moveToFirst()) {
            do {
                TabelGabung item = new TabelGabung(
                    c.getInt(c.getColumnIndex("id_resep")),
                    c.getInt(c.getColumnIndex("id_bahan")),
                    c.getString(c.getColumnIndex("ket_bahan")),
                    c.getString(c.getColumnIndex("alt_bahan1")),
                    c.getString(c.getColumnIndex("alt_bahan2")),
                    c.getString(c.getColumnIndex("nama_bahan")),
                    c.getString(c.getColumnIndex("nama_resep")),
                    c.getString(c.getColumnIndex("cara_masak")),
                    c.getString(c.getColumnIndex("foto"))
                );
                mDataset.add(item);
            } while (c.moveToNext());
        }
        c.close();
        return mDataset;
    }

    public ArrayList<TabelResep> getCariResep(String cari1, String cari2, String cari3) {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<TabelResep> mDataset = new ArrayList<>();
        Cursor c = db.rawQuery("select c.id_resep, c.nama_resep, c.cara_masak, c.foto, count(*) jml  from tabel_gabung a inner join tabel_bahan b on a.id_bahan = b.id_bahan inner join tabel_resep c on a.id_resep = c.id_resep where b.id_bahan in ("+cari1+","+cari2+","+cari3+") group by nama_resep", null);

        if (c.moveToFirst()) {
            do {
                if(c.getInt(c.getColumnIndex("jml")) >= 3) {
                    TabelResep item = new TabelResep(
                            c.getInt(c.getColumnIndex("id_resep")),
                            c.getString(c.getColumnIndex("nama_resep")),
                            c.getString(c.getColumnIndex("cara_masak")),
                            c.getString(c.getColumnIndex("foto")));
                    mDataset.add(item);
                }
            } while (c.moveToNext());
        }

        c.close();
        return mDataset;
    }

    public ArrayList<TabelBahan> getBahan() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<TabelBahan> mDataset = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT  * FROM tabel_bahan", null);

        if (c.moveToFirst()) {
            do {
                TabelBahan item = new TabelBahan(
                    c.getString(c.getColumnIndex("id_bahan")),
                    c.getString(c.getColumnIndex("nama_bahan"))
                );
                mDataset.add(item);
            } while (c.moveToNext());
        }
        c.close();
        return mDataset;
    }

}
