package br.com.darksite.repeater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.content.*;

public class ActTerceiraTela extends AppCompatActivity implements View.OnClickListener{

    private EditText edtResultado;
    private Button btnEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_terceira_tela);

        edtResultado = (EditText)findViewById(R.id.edtResultado);
        btnEnd = (Button)findViewById(R.id.btnEnd);

        btnEnd.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();

        if (bundle.containsKey("VALOR"))
        {
            String valor  = bundle.getString("VALOR");
            edtResultado.setText(valor);
        }
    }

    @Override
    public void onClick(View v)
    {
        Intent it = new Intent(this, ActivityMain.class);
        startActivity(it);
    }
}
