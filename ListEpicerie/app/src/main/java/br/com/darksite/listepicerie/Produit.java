package br.com.darksite.listepicerie;

/**
 * Created by msant on 2017-10-01.
 */

/**
 * Botao direito GENERATE (ou alt+insert) gera construtores e getters e setters
 */
// classe produto
public class Produit {

    private int id;
    private String nom;
    private String quantite;
    private String prix;

    // construtor padrao


    public Produit() {
    }

    // construtor com atributos

    public Produit(int id, String nom, String quantite, String prix) {
        this.id = id;
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
    }


    // getters e setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }
}
