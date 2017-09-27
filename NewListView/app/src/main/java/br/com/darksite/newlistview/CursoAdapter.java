package br.com.darksite.newlistview;

import android.content.Context;
import android.view.*;
import android.widget.*;
import java.util.ArrayList;

/**
 * Created by msant on 2017-09-26.
 */

public class CursoAdapter extends ArrayAdapter<Curso> {

    //definindo quem é o contexto
    private final Context context;

    //definindo quais dados vamos usar
    private final ArrayList<Curso> elementos;

    //identificando qual é o layout que iremos utilizar
    public CursoAdapter(Context context, ArrayList<Curso> elementos) {
        super(context, R.layout.linha, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override

    //getView passa o layout (...)
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linha, parent, false);

        //(...) e associa estes elementos abaixo  - nome, endereço, imagem (...)
        TextView nomeEscola = (TextView) rowView.findViewById(R.id.nome);
        TextView endereco = (TextView) rowView.findViewById(R.id.endereco);
        ImageView imagem = (ImageView) rowView.findViewById(R.id.imagem);

        //(...) seta os atributos com o elemento do vetor
        nomeEscola.setText(elementos.get(position).getNome());
        endereco.setText(elementos.get(position).getEndereco());
        imagem.setImageResource(elementos.get(position).getImagem());

        //retorna a linha
        return rowView;
    }
}