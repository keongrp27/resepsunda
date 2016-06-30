package com.example.keong.resepsunda;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by keong on 19/06/2016.
 */
public class Database extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "resep.db";
    private static final int DATABASE_VERSION = 1;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
