package com.example.mypc.app_toan_lop_1;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Random;

public class Phep_Toan_So_Sanh extends AppCompatActivity {

    int x,y;
    MediaPlayer mp = new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_phep__toan__so__sanh);
        xuly();
        Button btnlon = (Button) findViewById(R.id.btnLon);
        btnlon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (x > y) {
                    animaD();
                    playSound(R.raw.good);
                    xuly();


                } else {
                    animaS();
                  playSound(R.raw.error);

                }

            }
        });
        Button btnbe = (Button) findViewById(R.id.btnBe);
        btnbe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (x < y ) {
                    animaD();
                    mp = MediaPlayer.create(Phep_Toan_So_Sanh.this,R.raw.wow);
                    if (mp.isPlaying())
                    {
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(Phep_Toan_So_Sanh.this,R.raw.wow);
                    }
                    mp.start();
                    xuly();

                } else{
                    animaS();
                    MediaPlayer mp = MediaPlayer.create(Phep_Toan_So_Sanh.this,R.raw.error);
                    if (mp.isPlaying())
                    {
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(Phep_Toan_So_Sanh.this,R.raw.error);
                    }
                    mp.start();
                }

            }
        });
        Button btnbang = (Button) findViewById(R.id.btnBang);
        btnbang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (x == y) {
                    animaD();
                    mp = MediaPlayer.create(Phep_Toan_So_Sanh.this, R.raw.wow);
                    if (mp.isPlaying()) {
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(Phep_Toan_So_Sanh.this, R.raw.wow);
                    }
                    mp.start();
                    xuly();

                } else {
                    animaS();
                    MediaPlayer mp = MediaPlayer.create(Phep_Toan_So_Sanh.this, R.raw.error);
                    if (mp.isPlaying()) {
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(Phep_Toan_So_Sanh.this, R.raw.error);
                    }
                    mp.start();
                }

            }
        });


    }
    public void xuly(){
        TextView txtso1= (TextView) findViewById(R.id.txtso1);
        TextView txtso2 = (TextView) findViewById(R.id.txtso2);
        TestRandomX();
        TestRandomY();
        txtso1.setText(x+"");
        txtso2.setText(y + "");
    }
    private int TestRandomX(){
        Random d = new Random();
        x=d.nextInt(10);
        return x;
    }
    private int TestRandomY(){
        Random d = new Random();
        y=d.nextInt(10);
        return y;
    }
    public void animaD()
    {
        final ImageView zoom = (ImageView) findViewById(R.id.imageView);
        final Animation zoomanimation = AnimationUtils.loadAnimation(Phep_Toan_So_Sanh.this, R.anim.zoom);
        zoom.startAnimation(zoomanimation);

    }
    public void animaS()
    {
        final ImageView zoom = (ImageView) findViewById(R.id.imageView2);
        final Animation zoomanimation = AnimationUtils.loadAnimation(Phep_Toan_So_Sanh.this, R.anim.zoom);
        zoom.startAnimation(zoomanimation);

    }
    public void playSound(int resources){
        try{
            boolean mStartPlaying = true;
            MediaPlayer  mPlayer=null;
            if (mStartPlaying==true){

                mPlayer = new MediaPlayer();
                Uri uri = Uri.parse("android.resource://com.example.mypc.app_toan_lop_1/" + resources);

                mPlayer.setDataSource(getApplicationContext(),uri);
                mPlayer.prepare();
                final MediaPlayer finalMPlayer = mPlayer;
                mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                    @Override
                    public void onCompletion(MediaPlayer mp) {
                       finalMPlayer.release();
                    }

                });
                mPlayer.start();

            }
            else{
                //   stopPlaying();
                //rePlay.setText("Replay");
                mPlayer.release();
                mPlayer = null;
            }
            mStartPlaying = !mStartPlaying;


        }
        catch (IOException e){
            Log.e("ERR", "prepare() failed");
        }
    }
}