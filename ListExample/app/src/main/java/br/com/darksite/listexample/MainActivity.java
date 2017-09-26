package br.com.darksite.listexample;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

//we need to extends ListActivity
public class MainActivity extends ListActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		//build one string
        String[] values = new String[] { "Marcelo", "Elisia", "Isabella", "Geovanna", "Au Au da Isabella",
                "Au Au da Geovanna",
                "Vovó Wanda",
                "Vovó Tina",
                "Tia Vanez",
                "Tio Nado",
                "Tio Adalto",
                "Tia Vania",
                "Marina",
                "Tio Cidorlando",
                "Tia Nice",
                "Joao Vitor",
                "Pedro Henrique",
                "Luis Felipe",
                "Tio Anderson",
                "Tia Lucimar",
                "Thiago",
                "Ludmilla",
                "Tio Evaldo",
                "Julia",
                "Vinicius"

        };
		
		//use the Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);

		//set our list
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        // ListView Clicked item index
        int itemPosition = position;

        // ListView Clicked item value
        String itemValue = (String) l.getItemAtPosition(position);

        // Do something when a list item is clicked
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Você clicou: ");
        alertDialog.setMessage(itemValue);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Sair",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}