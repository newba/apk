package br.com.darksite.listviewpersonalizado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList cidades = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cidades.add(new Cidade("Uberlândia", "Capital do Triângulo Mineiro", "MG", R.drawable.uberlandia));
        cidades.add(new Cidade("Curitiba", "Capital do Paraná", "PR", R.drawable.curitiba));
        cidades.add(new Cidade("São Paulo", "Capital de São Paulo", "SP",R.drawable.sp));
        cidades.add(new Cidade("Porto Alegre", "Capital do Rio Grande do Sul", "RS", R.drawable.poa));



    }
}
