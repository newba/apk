package br.com.darksite.listadecursos;

/**
 * Created by msant on 2017-09-30.
 */

public class Curso {
    private String nome;
    private int imagem; // vai armazenar o identificador do recurso
    private String endereco;

    public Curso(String nome, String endereco, int imagem) {
        this.nome = nome;
        this.endereco = endereco;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
