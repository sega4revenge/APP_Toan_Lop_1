package com.example.mypc.app_toan_lop_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnPC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        Button btn = (Button) findViewById(R.id.btnPC);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Phep_cong.class);
                startActivity(intent);
                overridePendingTransition(R.anim.animationright, R.anim.animationleft);
            }
        });
        Button btnpcmot = (Button) findViewById(R.id.btnPC100);
        btnpcmot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Phep_Cong_PV_Mot_Tram.class);
                startActivity(intent);
                overridePendingTransition(R.anim.animationright, R.anim.animationleft);
            }
        });
        Button btnpcnc = (Button) findViewById(R.id.btnpcnc);
        btnpcnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Phep_Cong_Nang_Cao.class);
                startActivity(intent);
                overridePendingTransition(R.anim.animationright, R.anim.animationleft);
            }
        });
        Button btntru = (Button) findViewById(R.id.btnPtru);
        btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,phep_tru.class);
                startActivity(intent);
                overridePendingTransition(R.anim.animationright, R.anim.animationleft);
            }
        });
        Button btnPtru3so = (Button) findViewById(R.id.btnptbaso);
        btnPtru3so.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Phep_Tru_Ba_So.class);
                startActivity(intent);
                overridePendingTransition(R.anim.animationright, R.anim.animationleft);
            }
        });
        Button btnPT100 = (Button) findViewById(R.id.btnPT100);
        btnPT100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Phep_Tru_PV_100.class);
                startActivity(intent);
                overridePendingTransition(R.anim.animationright, R.anim.animationleft);
            }
        });
        Button btnssnc = (Button) findViewById(R.id.btnssnc);
        btnssnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Phep_ss_nangcao.class);
                startActivity(intent);
                overridePendingTransition(R.anim.animationright, R.anim.animationleft);
            }
        });
        Button btnss = (Button) findViewById(R.id.btnss);
        btnss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Phep_Toan_So_Sanh.class);
                startActivity(intent);
                overridePendingTransition(R.anim.animationright, R.anim.animationleft);
            }
        });

        Button btnth = (Button) findViewById(R.id.btnTH);
        btnth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Phep_toan_TH.class);
                startActivity(intent);
                overridePendingTransition(R.anim.animationright, R.anim.animationleft);
            }
        });
        Button btntoangiai = (Button) findViewById(R.id.btnTG);
        btntoangiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Cac_Bai_Toan_Giai.class);
                startActivity(intent);
                overridePendingTransition(R.anim.animationright, R.anim.animationleft);
            }
        });
        Button btntoangiainc = (Button) findViewById(R.id.btnTGnc);
        btntoangiainc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Cac_Bai_Toan_Giai_NC.class);
                startActivity(intent);
                overridePendingTransition(R.anim.animationright, R.anim.animationleft);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
