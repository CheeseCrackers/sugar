package com.orm;

import android.support.multidex.MultiDexApplication;

public class SugarApp extends MultiDexApplication{

    private Database database;
    private static SugarApp sugarContext;

    public void onCreate(){
        super.onCreate();
        SugarApp.sugarContext = this;
        this.database = new Database(this);
    }

    public void onTerminate(){
        if (this.database != null) {
            this.database.getDB().close();
        }
        super.onTerminate();
    }

    public static SugarApp getSugarContext(){
        return sugarContext;
    }

    protected Database getDatabase() {
        return database;
    }
}
