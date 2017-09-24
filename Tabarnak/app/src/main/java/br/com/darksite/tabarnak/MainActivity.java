package br.com.darksite.tabarnak;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clicktab01(View v){
        MediaPlayer mp = MediaPlayer.create(this, R.raw.tab01);
        mp.start();
    }

    public void clicktab02(View v){
        MediaPlayer mp = MediaPlayer.create(this, R.raw.tab02);
        mp.start();
    }

    public void clicktab03(View v){
        MediaPlayer mp = MediaPlayer.create(this, R.raw.tab03);
        mp.start();
    }

    public void clicktab04(View v){
        MediaPlayer mp = MediaPlayer.create(this, R.raw.tab04);
        mp.start();
    }

    public void clicktab05(View v){
        MediaPlayer mp = MediaPlayer.create(this, R.raw.tab05);
        mp.start();
    }

    public void clicktab06(View v){
        MediaPlayer mp = MediaPlayer.create(this, R.raw.tab06);
        mp.start();
    }

    public void clicktabgde(View v){
        MediaPlayer mp = MediaPlayer.create(this, R.raw.tab07);
        mp.start();
    }
}
