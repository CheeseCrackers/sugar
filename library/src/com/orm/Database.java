package com.orm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


public class Database {
    private SugarDb sugarDb;
    private SQLiteDatabase sqLiteDatabase;

    public Database(Context context) {
        this.sugarDb = new SugarDb(context);
    }


    public synchronized SQLiteDatabase getDB() {

        if (this.sqLiteDatabase == null) {
            Log.d("SeedingSugar", "Sqlitedatabase is null and hasn't been created yet");
            this.sqLiteDatabase = this.sugarDb.importDatabase();

            if (this.sqLiteDatabase == null) {
                Log.d("SeedingSugar", "Database import failed");
                this.sqLiteDatabase = this.sugarDb.getWritableDatabase();

            } else {
                Log.d("SeedingSugar", "Database import succeeded");
            }
        }

        return this.sqLiteDatabase;
    }
}
