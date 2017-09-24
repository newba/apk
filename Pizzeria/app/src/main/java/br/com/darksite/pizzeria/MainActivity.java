package br.com.darksite.pizzeria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox pepeBox, xtraFromBox;
    TextView textViewAffiche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pepeBox = (CheckBox) findViewById(R.id.checkBoxPepe);
        xtraFromBox = (CheckBox) findViewById(R.id.checkBoxExtra);
        textViewAffiche = (TextView) findViewById(R.id.textView);
    }

    public void onButtonClick(View view) {

        StringBuilder str = new StringBuilder("");
        if (pepeBox.isChecked()) {
            str.append("Pepperoni");
        }
        if (xtraFromBox.isChecked()) {
            str.append("Extra cheese");
        }

        if (str.length() == 0) {
            str.append("Nature");
        }

        textViewAffiche.setText(str);

        Intent i = new Intent(this, Other.class);
        i.putExtra("Pepperoni", pepeBox.isChecked());
        i.putExtra("Extra cheese", xtraFromBox.isChecked());
        startActivity(i);
    }
}
