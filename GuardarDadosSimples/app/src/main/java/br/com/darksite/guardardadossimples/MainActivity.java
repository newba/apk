package br.com.darksite.guardardadossimples;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nom = (EditText) findViewById(R.id.txtNom);
        final EditText qtt = (EditText) findViewById(R.id.txtQtte);

        Button save = (Button) findViewById(R.id.btnSave);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("preferencias",
                        Context.MODE_PRIVATE);
                SharedPreferences.Editor ed = prefs.edit();

                ed.putString("nom", nom.getText().toString());
                ed.putString("qtt", qtt.getText().toString());
                ed.apply();

                Toast.makeText(getBaseContext(), "Gravado", Toast.LENGTH_SHORT).show();
            }
        });

        Button clear = (Button) findViewById(R.id.btnClear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nom.setText("");
                qtt.setText("");
            }
        });

        Button afficher = (Button) findViewById(R.id.btnAfficher);
        afficher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("preferencias",
                        Context.MODE_PRIVATE);
                nom.setText(prefs.getString("nom", "Not find"));
                qtt.setText(prefs.getString("qtt", "Not find"));
            }
        });

    }
}
