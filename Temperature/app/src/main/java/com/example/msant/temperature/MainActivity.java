package com.example.msant.temperature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    EditText temp;
    RadioButton toF;
    RadioButton toC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        temp = (EditText)findViewById(R.id.TemperatureEditText);
        toC = (RadioButton)findViewById(R.id.toCelsiusRadioButton);
        toF = (RadioButton)findViewById(R.id.toFarenheitRadioButton);
    }

    public void convertir(View v){
        double valeur = new Double(temp.getText().toString());

       if  (toC.isChecked()) {
            valeur = UnitConverter.farenheit2Celsius(valeur);
        }
        else
            valeur = UnitConverter.celsius2Farenheit(valeur);
        temp.setText(new Double(valeur).toString());


        }

    }

