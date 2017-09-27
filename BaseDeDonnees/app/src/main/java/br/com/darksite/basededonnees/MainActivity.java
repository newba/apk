package br.com.darksite.basededonnees;

import android.app.Activity;
import android.content.ContentValues;
import android.database.*;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends Activity {

    TextView textView;
    // cursor de base de données
     Cursor cursor = null;
    //dbhelper
    DBHelper helper = null;
    SQLiteDatabase db = null;
    ContentValues values = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.txtHello);
        helper = new DBHelper(this, "simpleDb", null, 1);
        db = helper.getWritableDatabase();

        values = new ContentValues();

        values.put("name", "barry");
        values.put("amount", "100");
        db.insert("simpletable", "", values);
        values.clear();

        values.put("name", "Harriet");
        values.put("amount", "300");
        db.insert("simpletable", "", values);
        values.clear();

        addToTexView();

        values.clear();
        values.put("amount", "500");
        db.update("simpletable", values, "name='Barry'", null);

        addToTexView();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        helper.close();
    }


    void addToTexView(){
        cursor = db.rawQuery("SELECT * FROM simpletable;", null);
        if (cursor != null && cursor.moveToFirst()){
            String name;

            do{
                String id_ = cursor.getString(0);
                name = cursor.getString(1);
                int amount = cursor.getInt(2);
                textView.append(id_ + " "+ name+ " "+ amount + "\n");
            }
            while (cursor.moveToNext());
        }
    }
}
