package br.com.darksite.basededonnees;

import android.content.*;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by msant on 2017-09-27.
 */

public class DBHelper extends SQLiteOpenHelper{

    public DBHelper(Context context, String dbName, SQLiteDatabase.CursorFactory factory, int version){

        super (context, dbName, factory, version);
    }

    @Override

    public void onCreate(SQLiteDatabase db){

        String createString = "CREATE TABLE IF NOT EXISTS simpleTable"
                + "(id_ INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT NOT NULL,"
                + "amount INTEGER NOT NULL);";
        db.execSQL(createString);
    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        String dropString = "Drop TABLE IF EXISTS simpleTable;";
        db.execSQL(dropString);
        onCreate(db);
    }

}
