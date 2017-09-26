package br.com.darksite.listviewpersonalizado;

/**
 * Created by msant on 2017-09-26.
 */

public class Cidade {

    private String nome;
    private String descricao;
    private String uf;
    private int resIdImagem;

    /**
     * Construtor
     */

    public Cidade (String nome, String descricao, String uf, int resIdImagem){
        this.nome = nome;
        this.descricao = descricao;
        this.uf = uf;
        this.resIdImagem = resIdImagem;
    }

    /**
     * Get
     */

    public String getNome(){
        return this.nome;
    }
    public String getDescricao(){
        return this.descricao;
    }

    public String getUf(){
        return this.uf;
    }
    public int getResIdImagem(){
        return this.resIdImagem;
    }


}
