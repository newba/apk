package br.com.darksite.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // garder l'instance de la view
        private View view;

    //Const de la tag de chaque button
    //j'utilise ce const pour recuperer le button utilisant le methode getCarre
        private final String CARRE = "carre";
    // const que sera imprimé no text du button
        private final String BULE = "O";
    // const que sera imprimé no text du button
        private final String XIS = "X";
        private String lastPlay = "X";

        //Matriz(pt-br) pour les conditions de victoire
        int [][] etatFinal = new int[][]{

                //Horizontal: si les buttons contient le meme text, le jeu est fini
                {1,2,3}, // 1 option
                {4,5,6}, // 2 option
                {7,8,9}, // 3 option

                //Vertical: si les buttons contient le meme text, le jeu est fini
                {1,4,7}, // 4 option
                {2,5,8}, // 5 option
                {3,6,9}, // 6 option

                //Diagonal: si les buttons contient le meme text, le jeu est fini
                {1,5,9}, // 7 option
                {3,5,7}, // 8 option

        };

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setView(getLayoutInflater().inflate(R.layout.activity_main, null));
            setContentView(getView());
        }

        public void clickCarre (View v) {

            if (!isEnd()) {

                if (((Button) v).getText().equals("")) {

                    if (getLastPlay().equals(XIS)) {
                        ((Button) v).setText(BULE);
                        setLastPlay(BULE);
                    } else {
                        ((Button) v).setText(XIS);
                        setLastPlay(XIS);
                    }

                } else {
                    Toast.makeText(getView().getContext(), "Il faut choisir autre carre.", Toast.LENGTH_LONG).show();

                }
                isEnd();

            }
        }

        public Button getCarre(int tagNum){
            return (Button)getView().findViewWithTag("carre"+tagNum);
        }

        public void newGame(View v){

            setEnableGame(true);
            setColorBlack();
           setColorNormal();

            for (int i = 1; i <=9; i++){
                if(getCarre(i)!=null){
                    getCarre(i).setText("");
                }
            }
        }

    public void setEnableGame(boolean b){
        for (int i = 1; i <=9; i++){
            if(getCarre(i)!=null){
                getCarre(i).setEnabled(b);
            }
        }
    }

    public void setColorText(int bot, int colorX){
        getCarre(bot).setTextColor(getResources().getColor(colorX));



    }

    public void setColorBot(int bot, int colorX){
        getCarre(bot).setBackgroundColor(getResources().getColor(colorX));

    }

    public void setColorBlack(){
        for(int j=0; j<=9; ++j){
            if(getCarre(j)!=null){
                setColorText(j,R.color.black);
            }
        }
    }

    public void setColorNormal(){
        for(int j=0; j<=9; ++j){
            if(getCarre(j)!=(null)){
                setColorBot(j,R.color.grey);
            }
        }
    }

    public boolean isEnd(){

        for(int x=0; x<=7; ++x){

            String s1 = getCarre(etatFinal[x][0]).getText().toString();
            String s2 = getCarre(etatFinal[x][1]).getText().toString();
            String s3 = getCarre(etatFinal[x][2]).getText().toString();

            if ((!s1.equals(""))&&
                    (!s2.equals(""))&&
                    (!s3.equals(""))){



                if(s1.equals(s2)&& s2.equals(s3)){
                    //change la couleur de X ou de O
                    setColorText(etatFinal[x][0],R.color.red);
                    setColorText(etatFinal[x][1],R.color.red);
                    setColorText(etatFinal[x][2],R.color.red);
                    setColorBot(etatFinal[x][0],R.color.magenta);
                    setColorBot(etatFinal[x][1],R.color.magenta);
                    setColorBot(etatFinal[x][2],R.color.magenta);


                    Toast.makeText(getView().getContext(),"Fim do jogo!", Toast.LENGTH_LONG).show();

                    return true;
                }
            }
        }return false;
    }



    //getters, setters

    public View getView() {
        return view;
    }

    public View setView(View view){
        return this.view = view;
    }

    public String getLastPlay(){
        return lastPlay;
    }

    public void setLastPlay(String lastPlay){
        this.lastPlay = lastPlay;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the main; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Inflate the main; this adds items to the action bar if it is present.
        //int id = item.getItemId();

        switch (item.getItemId()) {
            case R.id.action_newgame:
                newGame();
                return true;
            case R.id.action_about:
                Toast.makeText(getView().getContext(),"TicTacToe - Marcelo !", Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_version:
                Toast.makeText(getView().getContext(),"TicTacToe - Version 20.9.17!", Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_contact:
                Toast.makeText(getView().getContext(),"mmsprogramador@gmail.com", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

    }
}

    private void newGame() {
        setEnableGame(true);
        setColorBlack();
        setColorNormal();

        for (int i = 1; i <=9; i++){
            if(getCarre(i)!=null){
                getCarre(i).setText("");
            }
        }
    }
    }
