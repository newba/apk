package br.com.darksite.listviewpersonalizado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by msant on 2017-09-26.
 */

public class CidadeAdapter extends ArrayAdapter<Cidade> {
    private List<Cidade> items;

    public CidadeAdapter(Context context, int textViewResourceId, List<Cidade> items) {
        super(context, textViewResourceId, items);
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            Context ctx = getContext();
            LayoutInflater vi = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.item_model, null);
        }
        Cidade cidade = items.get(position);
        if (cidade != null) {
            ((TextView) v.findViewById(R.id.lblCidade)).setText(cidade.getNome());
            ((TextView) v.findViewById(R.id.lblUF)).setText("/" + cidade.getUf());
            ((TextView) v.findViewById(R.id.lblDescricao)).setText(cidade.getDescricao());

            ((ImageView) v.findViewById(R.id.imgCidade)).setImageResource(cidade.getResIdImagem());
        }
        return v;
    }
}

