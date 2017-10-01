package br.com.darksite.listadecursos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //vai criar e popular o adapter, linkando com o ListView da activity

        ListView lista = (ListView)findViewById(R.id.lvCursos);
        // joga o array dentro de "cursos"
        final ArrayList<Curso> cursos = adicionaCursos();
        ArrayAdapter adapter = new CursoAdapter(this, cursos);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // em item clicado vamos adicionar a posicao do array conforme click usando o array get e passando o
                // valor position . getNome()
               // Toast.makeText(getBaseContext(), "Curso Selecionado: "+cursos.get(position).getNome(), Toast.LENGTH_SHORT).show();


                //===============================================================================

                /**
                 * Agora vamos passar para uma nova Activity. Primeiro criamos uma nova activity.
                 * Próximo passo é programar a intent na primeira linha
                 * buscar o nome do curso na segunda linha, passando a posicao por parametro
                 * iniciar a activity na terceira linha
                 */
                Intent i = new Intent(MainActivity.this, Main2Activity.class);

                i.putExtra("nome", cursos.get(position).getNome());
                startActivity(i);
            }
        });
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
