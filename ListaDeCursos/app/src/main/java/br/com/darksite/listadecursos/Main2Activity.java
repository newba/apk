package br.com.darksite.listadecursos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i = getIntent();
        String parametro = (String) i.getSerializableExtra("nome");

        TextView nome = (TextView)findViewById(R.id.txtNome2);

        nome.setText(parametro);
    }
}
