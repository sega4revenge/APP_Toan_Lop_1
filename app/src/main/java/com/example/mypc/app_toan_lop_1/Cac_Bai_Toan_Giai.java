package com.example.mypc.app_toan_lop_1;

import android.database.SQLException;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Cac_Bai_Toan_Giai extends AppCompatActivity {
    MyDatabaseHelper myData;
    TextView txtbaitoan;
    EditText edtkq;
    Button btnok;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_cac__bai__toan__giai);
        myData = new MyDatabaseHelper(this);
        try {

            myData.createDataBase();

        }
        catch (IOException ioe)
        {
            throw new Error("Unable to create database");
        }
        try
        {
            myData.openDatabase();
        }
        catch(SQLException sqle)
        {
            throw sqle;
        }
        xuly();
        Button btnok = (Button) findViewById(R.id.btnok);
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText edtkq = (EditText) findViewById(R.id.edtkq);
                String str = edtkq.getText().toString();
                if (str.equals(""))
                {
                    Toast toast = Toast.makeText(Cac_Bai_Toan_Giai.this, "Bạn Chưa Trả Lời ", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    int dapan = Integer.parseInt(edtkq.getText().toString());
                    ArrayList<Integer> DapAn = myData.getdapso();
                    int a = DapAn.get(id);
                    if (a == dapan)
                    {
                        animaD();
                        MediaPlayer mp = MediaPlayer.create(Cac_Bai_Toan_Giai.this,R.raw.good);
                        mp.start();
                        edtkq.setText("");
                        xuly();
                    }
                    else
                    {
                        animaS();
                        MediaPlayer mp = MediaPlayer.create(Cac_Bai_Toan_Giai.this,R.raw.error);
                        mp.start();
                        edtkq.setText("");
                    }
                }
            }
        });
    }
    public void xuly(){
        TestRandomID();
        ArrayList<String> arr = myData.getname();
        txtbaitoan = (TextView) findViewById(R.id.txtbaitoan);
        txtbaitoan.setText(arr.get(id)+"");
    }
    public  void ramdom()
    {
        TestRandomID();
    }
    private int TestRandomID(){
        Random d = new Random();
        id=d.nextInt(10);
        return id;
    }
    public void animaD()
    {
        final ImageView zoom = (ImageView) findViewById(R.id.imageView);
        final Animation zoomanimation = AnimationUtils.loadAnimation(Cac_Bai_Toan_Giai.this, R.anim.zoom);
        zoom.startAnimation(zoomanimation);
    }
    public void animaS()
    {
        final ImageView zoom = (ImageView) findViewById(R.id.imageView2);
        final Animation zoomanimation = AnimationUtils.loadAnimation(Cac_Bai_Toan_Giai.this, R.anim.zoom);
        zoom.startAnimation(zoomanimation);
    }

}
