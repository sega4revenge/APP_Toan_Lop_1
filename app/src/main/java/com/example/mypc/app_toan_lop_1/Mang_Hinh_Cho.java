package com.example.mypc.app_toan_lop_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Mang_Hinh_Cho extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_mang__hinh__cho);

        Button button = (Button) findViewById(R.id.btnch);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mang_Hinh_Cho.this,MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.animationright, R.anim.animationleft);

            }
        });
    }

}
