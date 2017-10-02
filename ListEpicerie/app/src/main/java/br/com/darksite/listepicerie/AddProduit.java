package br.com.darksite.listepicerie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddProduit extends AppCompatActivity {

    private BDSQLiteHelper bd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_produit);

        bd = new BDSQLiteHelper(this);

        final EditText nom = (EditText)findViewById(R.id.edtNomProduit);
        final EditText quantite = (EditText)findViewById(R.id.edtQttProduit);
        final EditText prix = (EditText)findViewById(R.id.edtPrixProduit);

        Button btnsave = (Button) findViewById(R.id.btnEdit);

        btnsave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Produit produit = new Produit();
                produit.setNom(nom.getText().toString());
                produit.setQuantite(quantite.getText().toString());
                produit.setPrix(prix.getText().toString());

                bd.addProduit(produit);

                Toast.makeText(getBaseContext(),"Produit enregistré", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(AddProduit.this, Main.class);
                startActivity(i);

            }
        });


    }


}
