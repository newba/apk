package br.com.darksite.listepicerie;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by msant on 2017-10-01.
 */

public class BDSQLiteHelper extends SQLiteOpenHelper {

    /**
     * Trabalhar com constantes é sempre uma boa pratica no momento de usar SQLite
     */
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ProduitData";

    //o uso de constantes facilita a edicao de campos no momento da programacao dos metodos
    private static final String TABELA_PRODUIT = "produits";
    private static final String ID = "id";
    private static final String NOM = "nom";
    private static final String QUANTITE = "quantite";
    private static final String PRIX = "prix";

    private static final String[] COLUNAS = {ID, NOM, QUANTITE, PRIX};





    /**
     * construtor que recebe um parâmetro Context
     * @param context
     */
    public BDSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    /**
     * Cria a tabela
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE produits ("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nom TEXT,"+
                "quantite TEXT,"+
                "prix TEXT)";
        db.execSQL(CREATE_TABLE);

    }

    /**
     * Apaga a tabela de cria ela de novo
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS produits");
        this.onCreate(db);

    }

    /**
     * Metodo para criar um produto
     */
    public void addProduit(Produit produit) {
        //abrindo o banco de dados para GRAVAR dados
        SQLiteDatabase db = this.getWritableDatabase();
        //ContentValues vai montar o objeto que vai montar todos os objetos que eu quero inserir
        ContentValues values = new ContentValues();

        values.put(NOM, produit.getNom());
        values.put(QUANTITE, produit.getQuantite());
        values.put(PRIX, produit.getPrix());
        // insere um registro na tabela de livros
        db.insert(TABELA_PRODUIT, null, values);
        //fecha o banco de dados
        db.close();
    }

    /**
     * Você passa um identificador (ID) e ele vai trazer quem é aquele produto (quais sao os dados daquele produto)
     * @param id
     * @return
     */
    public Produit getProduit(int id) {
        //abrindo o banco de dados para LER dados
        SQLiteDatabase db = this.getReadableDatabase();
        //Cursor é o apontador para uma das linhas (varre o registro das linhas
        Cursor cursor = db.query(TABELA_PRODUIT, // a. tabela - consulta a tabela
                COLUNAS, // b. colunas - no array colunas que configuramos na constante
                " id = ?", // c. colunas para comparar
                new String[] { String.valueOf(id) }, // d. parâmetros - o id que foi passado em parametro
                // se quiser definir outras formas de pesquisa usar abaixo
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        if (cursor == null) {
            return null;
        } else {
            cursor.moveToFirst();
            Produit p = cursorToProduit(cursor);
            return p;
        }
    }

    /**
     * pega todos os dados do cursos e joga numa entidade produto
     * @param cursor
     * @return
     */
    private Produit cursorToProduit(Cursor cursor) {
        // cria uma instancia de produto
        Produit produit = new Produit();
        // traz na ordem das colunas
        produit.setId(Integer.parseInt(cursor.getString(0)));
        produit.setNom(cursor.getString(1));
        produit.setQuantite(cursor.getString(2));
        produit.setPrix(cursor.getString(3));
        return produit;
    }

    //metodo que recupera todos os produtos que estao cadastrados na base
    public ArrayList<Produit> getAllProduits() {
        //cria-se um arraylist de produtos vazio que vai ser preenchido
        ArrayList<Produit> listProduits = new ArrayList<Produit>();

        // faz uma requisicao selecionando toda a tabela de produtos
        String query = "SELECT * FROM " + TABELA_PRODUIT;

        // abre o banco de dados para leitura
        SQLiteDatabase db = this.getReadableDatabase();
        // chama um cursor para a query q foi definida
        Cursor cursor = db.rawQuery(query, null);
        // adiciona os produtos numa lista atraves de um laço
        if (cursor.moveToFirst()) {
            do {
                Produit produit = cursorToProduit(cursor);
                listProduits.add(produit);
            } while (cursor.moveToNext());
        }
        return listProduits;
    }

    /**
     * Metodo para atualizar um produto na tabela
     * @param produit
     * @return
     */
    public int updateProduit(Produit produit) {
        //abre o banco de dados para gravaçao de dados
        SQLiteDatabase db = this.getWritableDatabase();
        //ContentValues vai montar o objeto que vai montar todos os objetos que eu quero atualizar
        ContentValues values = new ContentValues();
        //indica os valores para atualizaçao
        values.put(NOM, produit.getNom());
        values.put(QUANTITE, produit.getQuantite());
        values.put(PRIX, produit.getPrix());

        //i = quantidade de linhas que foram modificadas
        int i = db.update(TABELA_PRODUIT, //tabela
                values, // valores
                ID+" = ?", // colunas para comparar
                new String[] { String.valueOf(produit.getId()) }); //parâmetros
        db.close();
        return i; // número de linhas modificadas
    }

    // metodo para excluir um produto da tabela
    public int deleteProduit(Produit produit) {
        //abre o banco para gravaçao de dados
        SQLiteDatabase db = this.getWritableDatabase();

        int i = db.delete(TABELA_PRODUIT, //tabela
                ID+" = ?", // colunas para comparar
                new String[] { String.valueOf(produit.getId()) });
        db.close();
        return i; // número de linhas excluídas
    }

}
