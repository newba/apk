package br.com.darksite.listepicerie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main extends AppCompatActivity {

    private BDSQLiteHelper bd;
    ArrayList<Produit> listProduits;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //instanciar o banco de dados aqui
        bd = new BDSQLiteHelper(this);
    }

    /**
     * Associa o listView da activity com o elemento chamado lista
     */
    @Override
    protected void onStart() {

        super.onStart();

        ListView lista = (ListView) findViewById(R.id.lvProduits);
        //chamada do banco de dados e chama o método getallproduits que faz um select * from no banco de dados
        // e traz todos os elementos, montando um arraylist de produtos.
        //resumindo: ele pega a resposta do getallproduits e joga dentro de listproduit
        listProduits = bd.getAllProduits();
        // list produit é chamado no arrayadapter, pois o adapter é que popula a lista
        ProduitAdapter adapter = new ProduitAdapter(this, listProduits);
        lista.setAdapter(adapter);

        //clicar na linha para editar o produto

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Main.this, EditProduit.class);
                intent.putExtra("ID", listProduits.get(position).getId());
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the main; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Inflate the main; this adds items to the action bar if it is present.
        //int id = item.getItemId();

        switch (item.getItemId()) {
            case R.id.action_newproduct:
                Intent i = new Intent(this, AddProduit.class);
                startActivity(i);

                return true;
            case R.id.action_about:

                return true;
            case R.id.action_version:

                return true;
            case R.id.action_contact:

                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
