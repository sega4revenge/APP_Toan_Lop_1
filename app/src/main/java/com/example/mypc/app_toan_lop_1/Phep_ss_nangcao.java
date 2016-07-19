package com.example.mypc.app_toan_lop_1;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Phep_ss_nangcao extends AppCompatActivity {
    int x,y,z,d,e,s;
    int sum1,sum2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_phep_ss_nangcao);

        xuly();
        Button btnlon = (Button) findViewById(R.id.btnLon);
        btnlon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sum1 > sum2) {
                    animaD();
                    MediaPlayer mp = MediaPlayer.create(Phep_ss_nangcao.this,R.raw.good);
                    mp.start();
                    xuly();

                } else {
                    animaS();
                    MediaPlayer mp = MediaPlayer.create(Phep_ss_nangcao.this,R.raw.error);
                    mp.start();
                }

            }
        });
        Button btnbe = (Button) findViewById(R.id.btnBe);
        btnbe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sum1 < sum2) {
                    animaD();
                    MediaPlayer mp = MediaPlayer.create(Phep_ss_nangcao.this,R.raw.good);
                    mp.start();
                    xuly();

                } else {
                    animaS();
                    MediaPlayer mp = MediaPlayer.create(Phep_ss_nangcao.this,R.raw.error);
                    mp.start();
                }

            }
        });
        Button btnbang = (Button) findViewById(R.id.btnBang);
        btnbang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sum1 == sum2) {
                    animaD();
                    MediaPlayer mp = MediaPlayer.create(Phep_ss_nangcao.this,R.raw.good);
                    mp.start();
                    xuly();

                } else {
                    animaS();
                    MediaPlayer mp = MediaPlayer.create(Phep_ss_nangcao.this,R.raw.error);
                    mp.start();
                }

            }
        });


    }
    public void xuly(){
        TextView txtso1= (TextView) findViewById(R.id.txtso1);
        TextView txtso2 = (TextView) findViewById(R.id.txtso2);
        TextView txtso3 = (TextView) findViewById(R.id.txtso3);
        TextView txtso4 = (TextView) findViewById(R.id.txtso4);
        TextView txtsocong = (TextView) findViewById(R.id.txtcong);
        TextView txtsotru = (TextView) findViewById(R.id.txttru);
        TestRandomX();
        TestRandomY();
        TestRandomZ();
        TestRandomD();
        TestRandomE();
        TestRandomS();
        txtso1.setText("("+ x );
        txtso2.setText(y + ")");
        txtso3.setText("(" + z);
        txtso4.setText(d + ")");
            if (e == 0 && s == 0) {
                txtsocong.setText("-");
                txtsotru.setText("-");
                if(x < y || z < d)
                {
                    xuly();
                }
                else{
                    sum1 = x - y;
                    sum2 = z - d;
                }
            } else if (e == 1 && s == 1) {
                txtsocong.setText("+");
                txtsotru.setText("+");
                sum1 = x + y;
                sum2 = z + d;
            } else if (e == 1 && s == 0) {
                txtsocong.setText("+");
                txtsotru.setText("-");
                if (z < d)
                {
                    xuly();
                }else
                {
                    sum1 = x + y;
                    sum2 = z - d;
                }
            } else {
                txtsocong.setText("-");
                txtsotru.setText("+");
                if (x < y)
                {
                    xuly();
                }else
                {
                    sum1 = z - y;
                    sum2 = z + d;
                }
            }

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
    private int TestRandomZ(){
        Random d = new Random();
        z=d.nextInt(10);
        return z;
    }
    private int TestRandomD(){
        Random a = new Random();
        d=a.nextInt(10);
        return d;
    }
    private int TestRandomE(){
        Random a = new Random();
        e=a.nextInt(2);
        return e;
    }
    private int TestRandomS(){
        Random a = new Random();
        s=a.nextInt(2);
        return s;
    }
    public void animaD()
    {
        final ImageView zoom = (ImageView) findViewById(R.id.imageView);
        final Animation zoomanimation = AnimationUtils.loadAnimation(Phep_ss_nangcao.this, R.anim.zoom);
        zoom.startAnimation(zoomanimation);
    }
    public void animaS()
    {
        final ImageView zoom = (ImageView) findViewById(R.id.imageView2);
        final Animation zoomanimation = AnimationUtils.loadAnimation(Phep_ss_nangcao.this, R.anim.zoom);
        zoom.startAnimation(zoomanimation);
    }

}