package br.com.darksite.newlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //vai criar e popular o adapter, linkando com o ListView da activity

        ListView lista = (ListView)findViewById(R.id.lvCursos);
        ArrayAdapter adapter = new CursoAdapter(this, adicionaCursos());
        lista.setAdapter(adapter);
    }


    // cria um conjunto de cursos e retorna um arraylist
    private ArrayList<Curso> adicionaCursos() {
        ArrayList<Curso> escolas = new ArrayList<Curso>();
        Curso e = new Curso("Curso de C#",
                "Apenas iniciantes", R.drawable.escola4);
                escolas.add(e);
        e = new Curso("Curso de Java",
                "Noob nível médio", R.drawable.escola1);
        escolas.add(e);
        e = new Curso("Curso de JavaScript",
                "Avançado", R.drawable.escola2);
        escolas.add(e);
        e = new Curso("Curso de HTML",
                "Para quem nem imagina o que é programar", R.drawable.escola3);
        escolas.add(e);
        e = new Curso("Curso de CSS",
                "Vai te ajudar no Html", R.drawable.escola5);
        escolas.add(e);
        e = new Curso("Curso de jQuery",
                "Complementa o curso de JavaScript", R.drawable.escola6);
        escolas.add(e);
        e = new Curso("Curso de PHP",
                "Do básico ao Avançado", R.drawable.escola7);
        escolas.add(e);
        e = new Curso("Curso de Python",
                "Para você estudar DataScience", R.drawable.escola8);
        escolas.add(e);
        e = new Curso("Curso de Ruby",
                "Nao sei pra que serve", R.drawable.escola9);
        escolas.add(e);


        return escolas;
    }
}
