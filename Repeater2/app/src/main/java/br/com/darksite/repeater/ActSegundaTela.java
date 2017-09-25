package br.com.darksite.repeater;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

public class ActSegundaTela extends AppCompatActivity implements View.OnClickListener {

    private EditText edtValor;
    private Button btnFechar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_segunda_tela);

        edtValor = (EditText)findViewById(R.id.edtResultado);
        btnFechar = (Button)findViewById(R.id.btnFechar);

        btnFechar.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();

        if (bundle.containsKey("VALOR"))
        {
            String valor  = bundle.getString("VALOR");
            edtValor.setText(valor);
        }
    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent(this, ActTerceiraTela.class);
        it.putExtra("VALOR", edtValor.getText().toString());
        startActivity(it);
    }
}
