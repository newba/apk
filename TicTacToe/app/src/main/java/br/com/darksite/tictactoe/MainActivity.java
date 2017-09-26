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
		
	// ici on garde le dernier valeur du jeu	
        private String lastPlay = "X";

        //Matrice que define les conditions de victoire
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
			
			//ici on recupere le XML et on garde l'instance de VIEW utilisant le setView

            setView(getLayoutInflater().inflate(R.layout.activity_main, null));
			
			//ici on passe l'instance de notre VIEW à notre Activity
            setContentView(getView());
        }

        public void clickCarre (View v) {

            if (!isEnd()) { // on vérifie si le jeu est fini

                if (((Button) v).getText().equals("")) { // vérifie si le text du button était venu de la variable v
				// est different de ""(vide)
                    if (getLastPlay().equals(XIS)) {//vérifie si la dernière valeur est égale à XIS
                        ((Button) v).setText(BULE);// si la valeur est égale a X on jeu BULE
                        setLastPlay(BULE); // set lastPlay comme Bule
						//pour la prochaine fois il ne entrer pas dans cette condition
                    } else {
                        ((Button) v).setText(XIS);//Set le text du button comme XIS
                        setLastPlay(XIS); //set lastPlay comme XIS
                    }
				// message au jouer qu'il devrait choisir une carre vide 
                } else {
                    Toast.makeText(getView().getContext(), "Il faut choisir autre carre.", Toast.LENGTH_LONG).show();

                }
                isEnd(); // on verifie se est le fin du jeu

            }
        }

        public Button getCarre(int tagNum){
			//retorna o respectivo quadrado requerido pela variavel tagNum
            return (Button)getView().findViewWithTag("carre"+tagNum);
        }
		
		//funçao para iniciar um novo jogo
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
	//habilitar os quadrados para jogar.
    public void setEnableGame(boolean b){
        for (int i = 1; i <=9; i++){
            if(getCarre(i)!=null){
                getCarre(i).setEnabled(b);
            }
        }
    }
	//funçao para setar a cor do texto X ou O no jogo
    public void setColorText(int bot, int colorX){
        getCarre(bot).setTextColor(getResources().getColor(colorX));
    }

	// funçao para setar a cor do botao (mudar a cor do botão quando o jogo for ganho)
    public void setColorBot(int bot, int colorX){
        getCarre(bot).setBackgroundColor(getResources().getColor(colorX));

    }
	
	// setar a cor preta do texto depois que terminar o jogo
    public void setColorBlack(){
        for(int j=0; j<=9; ++j){
            if(getCarre(j)!=null){
                setColorText(j,R.color.black);
            }
        }
    }

	// setar a cor original dos botoes depois que terminar o jogo. 
	// serve voltar a cor normal dos botões quando o jogo for reiniciado 
	// metodo chamado no outro méthodo newGame( o que inicia as funcoes do jogo voltando a cor do texto para preto) 

    public void setColorNormal(){
        for(int j=0; j<=9; ++j){
            if(getCarre(j)!=(null)){
                setColorBot(j,R.color.grey);
            }
        }
    }

    public boolean isEnd(){
		
		// vamos percorrer todas as nosas condições definidas na nossa matriz

        for(int x=0; x<=7; ++x){

            String s1 = getCarre(etatFinal[x][0]).getText().toString();
            String s2 = getCarre(etatFinal[x][1]).getText().toString();
            String s3 = getCarre(etatFinal[x][2]).getText().toString();

			
			// verificamos se os botoes sao diferentes de vazio
			// pois se nao houver verificaçao o jogo acaba assim que iniciado
			// pois os botoes terao o mesmo conteúdo
            if ((!s1.equals(""))&&
                    (!s2.equals(""))&&
                    (!s3.equals(""))){


				//verifica a igualdade
                if(s1.equals(s2)&& s2.equals(s3)){
                    //change la couleur de X ou de O (aquele que ganhou o jogo)
                    setColorText(etatFinal[x][0],R.color.red);
                    setColorText(etatFinal[x][1],R.color.red);
                    setColorText(etatFinal[x][2],R.color.red);
					//muda a cor dos botoes que ganharam o jogo
                    setColorBot(etatFinal[x][0],R.color.magenta);
                    setColorBot(etatFinal[x][1],R.color.magenta);
                    setColorBot(etatFinal[x][2],R.color.magenta);

					//indicamos aqui que o jogo acabou
                    Toast.makeText(getView().getContext(),"Fim do jogo!", Toast.LENGTH_LONG).show();

                    return true; // sim o jogo acabou
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
// menu new game
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
