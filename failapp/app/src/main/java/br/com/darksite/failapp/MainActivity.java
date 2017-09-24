package br.com.darksite.failapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //linha 1 add
        //TextView textview = (TextView) findViewById(R.id.textView);
        setContentView(R.layout.activity_main);

        //linha 1 transferida pra ca
        // a aplicacao vai foder no momento em que colocamos nosso textview antes de setar o conteudo
        TextView textview = (TextView) findViewById(R.id.textView);
        //linha 2 add
        textview.setText("Oopps!");
    }

}
