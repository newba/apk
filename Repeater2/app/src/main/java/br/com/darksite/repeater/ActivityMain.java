package br.com.darksite.repeater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.content.*;


public class ActivityMain extends AppCompatActivity implements View.OnClickListener {

    private EditText edtValor;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtValor = (EditText)findViewById(R.id.edtResultado);
        btnOk = (Button)findViewById(R.id.btnOk);

        btnOk.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent it = new Intent(this, ActSegundaTela.class);
        it.putExtra("VALOR", edtValor.getText().toString());
        startActivity(it);
    }
}
