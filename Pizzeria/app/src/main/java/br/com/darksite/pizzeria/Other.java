package br.com.darksite.pizzeria;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;

public class Other extends Activity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        textView = (TextView) findViewById(R.id.textView2);
        Intent intent = getIntent();
        StringBuilder str = new StringBuilder("");
        if(intent.getBooleanExtra("Pepperoni", false)){
            str.append("Pepperoni");
        }
        if(intent.getBooleanExtra("Extra cheese", false)){
            str.append("Extra cheese");
        }
        textView.setText(str);
    }
}
