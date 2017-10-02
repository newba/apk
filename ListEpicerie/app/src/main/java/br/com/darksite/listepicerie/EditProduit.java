package br.com.darksite.listepicerie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditProduit extends AppCompatActivity {

    private BDSQLiteHelper bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_produit);

        Intent intent = getIntent();
        final int id = intent.getIntExtra("ID",0);
        bd = new BDSQLiteHelper(this);
        final Produit produit = bd.getProduit(id);

        final EditText nom = (EditText)findViewById(R.id.edtNomProduit);
        final EditText qtde = (EditText) findViewById(R.id.edtQttProduit);
        final EditText prix = (EditText) findViewById(R.id.edtPrixProduit);

        nom.setText(produit.getNom());
        qtde.setText(produit.getQuantite());
        prix.setText(produit.getPrix());

        //editar o produto
        Button btnEdit = (Button)findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Produit produit = new Produit();
                produit.setId(id);
                produit.setNom(nom.getText().toString());
                produit.setQuantite(qtde.getText().toString());
                produit.setPrix(prix.getText().toString());

                bd.updateProduit(produit);

                Toast.makeText(getBaseContext(),"Edition avec succes",Toast.LENGTH_SHORT).show();

                nom.setText("");
                qtde.setText("");
                prix.setText("");


            }
        });

        // deletar o produto
        Button btnDelete = (Button)findViewById(R.id.btnDelete);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bd.deleteProduit(produit);
                Toast.makeText(getBaseContext(),"Delete avec succes",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(EditProduit.this, Main.class);
                startActivity(i);
            }
        });

        //Home

        Button btnHome = (Button)findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EditProduit.this, Main.class);
                startActivity(i);
            }
        });
    }
}
