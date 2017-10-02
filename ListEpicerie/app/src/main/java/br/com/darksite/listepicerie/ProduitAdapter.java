package br.com.darksite.listepicerie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by msant on 2017-10-01.
 */

public class ProduitAdapter extends ArrayAdapter<Produit> {
    private final Context context;
    private final ArrayList<Produit> elements;

    public ProduitAdapter(Context context, ArrayList<Produit> elementos) {
        super(context, R.layout.linha, elementos);
        this.context = context;
        this.elements = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.linha, parent, false);

        TextView nom = (TextView) rowView.findViewById(R.id.txtNomProduit);
        TextView qtte = (TextView) rowView.findViewById(R.id.txtQuantite);
        TextView prix = (TextView) rowView.findViewById(R.id.textPrix);

        nom.setText(elements.get(position).getNom());
        qtte.setText(elements.get(position).getQuantite());
        prix.setText(elements.get(position).getPrix());
        return rowView;
    }

}
