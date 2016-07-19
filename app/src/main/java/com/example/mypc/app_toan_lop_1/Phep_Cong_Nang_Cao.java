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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Phep_Cong_Nang_Cao extends AppCompatActivity {
    int x,y,z;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_phep__cong__nang__cao);

        xuly();
        Button btnTL = (Button) findViewById(R.id.btnTL);
        btnTL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int kq = x + y + z;
                EditText edt = (EditText) findViewById(R.id.edtkq);
                String str = edt.getText().toString();
                if (str.equals("")) {
                    Toast toast = Toast.makeText(Phep_Cong_Nang_Cao.this, "Bạn Chưa Trả Lời ", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    int kqedt = Integer.parseInt(str);
                    if (kq - kqedt == 0) {
                        animaD();
                        MediaPlayer mp = MediaPlayer.create(Phep_Cong_Nang_Cao.this,R.raw.good);
                        mp.start();
                        edt.setText("");
                        xuly();

                    } else if (kq - kqedt != 0) {
                        animaS();
                        MediaPlayer mp = MediaPlayer.create(Phep_Cong_Nang_Cao.this,R.raw.error);
                        mp.start();
                        edt.setText("");
                    }

                }
            }
        });
    }
    public void xuly(){
        TextView txtso1= (TextView) findViewById(R.id.txtso1);
        TextView txtso2 = (TextView) findViewById(R.id.txtso2);
        TextView txtso3 = (TextView) findViewById(R.id.txtso3);
        TestRandomX();
        TestRandomY();
        TestRandomZ();
        if(x + y >10)
        {
            xuly();
        }
        txtso1.setText(x + "");
        txtso2.setText(y + "");
        txtso3.setText(z + "");
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
    public void animaD()
    {
        final ImageView zoom = (ImageView) findViewById(R.id.imageView);
        final Animation zoomanimation = AnimationUtils.loadAnimation(Phep_Cong_Nang_Cao.this, R.anim.zoom);
        zoom.startAnimation(zoomanimation);
    }
    public void animaS()
    {
        final ImageView zoom = (ImageView) findViewById(R.id.imageView2);
        final Animation zoomanimation = AnimationUtils.loadAnimation(Phep_Cong_Nang_Cao.this, R.anim.zoom);
        zoom.startAnimation(zoomanimation);
    }

}
