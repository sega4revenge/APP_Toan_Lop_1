package com.example.mypc.app_toan_lop_1;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Phep_toan_TH extends Activity {
    int x,d,y,z,dau1,dau2; static  int sum, sum1;
    TextView txtso1,txtso2,txtso3,txtd1,txtd2,txttitle;
    Fragment flag;
    FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_phep_toan__th);
        txttitle = (TextView) findViewById(R.id.txttitle);
        txtso1 = (TextView) findViewById(R.id.txtso1);
        txtso2 = (TextView) findViewById(R.id.txtso2);
        txtso3 = (TextView) findViewById(R.id.txtso3);
        txtd1 = (TextView) findViewById(R.id.txtd1);
        txtd2 = (TextView) findViewById(R.id.txtd2);
        xuly();
    }
    public void xuly() {
        TestRandomD();
        sum = 0;
        sum1 = 0;
        if (d == 0)
        {
            Pheptoansosanh();
            flag = new sosanh_activity();
            transaction = getFragmentManager().beginTransaction().replace(R.id.container, flag);
            transaction.commit();
        }
        else if (d == 1)
        {
            Pheptoan();
            flag = new ketqua_activity();
            transaction = getFragmentManager().beginTransaction().replace(R.id.container, flag);
            transaction.commit();
        }
    }
    public void Pheptoansosanh() {
        txttitle.setText("Phép Toán So Sánh");
        TestRandomE();
        TestRandomF();
        ramdom();

        if (dau1 == 0 && dau2 == 1) {
            txtso1.setText(x + "");
            txtso2.setText("(" + y + "");
            txtso3.setText(z + "" + ")");
            txtd1.setText("...");
            txtd2.setText("+");
            sum1 = (y + z);
            sum = x;
        }
        else if (dau1 == 0 && dau2 == 0) {
            txtso1.setText(x + "");
            txtso2.setText("(" + y + "");
            txtso3.setText(z + "" + ")");
            txtd1.setText("...");
            txtd2.setText("-");
            if (y < z) {
                Pheptoansosanh();
            }
            sum1 = (y - z);
            sum = x;
        }
        if (dau1 == 1 && dau2 == 1 )
        {
            txtso1.setText("(" + x + "");
            txtso2.setText(y + "" + ")");
            txtso3.setText(z + "");
            txtd1.setText("+");
            txtd2.setText("...");
            sum = x + y;
            sum1 = z;
        }
        else if (dau1 == 1 && dau2 == 0)
        {
            txtso1.setText("(" + x + "");
            txtso2.setText(y + "" + ")");
            txtso3.setText(z + "");
            txtd1.setText("-");
            txtd2.setText("...");
            if (x < y) {
                Pheptoansosanh();
            }
            sum = x - y;
            sum1 = z;
        }

    }
    public void Pheptoan() {
        txttitle.setText("Phép Toán Cộng Trừ");
        TestRandomE();
        TestRandomF();
        ramdom();
        if (dau1 == 1 && dau2 == 1) {
            txtso1.setText(x + "");
            txtso2.setText(y + "");
            txtso3.setText(z + "");
            txtd1.setText("+");
            txtd2.setText("+");
            sum = ((x + y) + z);
        }
        else if (dau1 == 1 && dau2 == 0) {
            txtso1.setText(x + "");
            txtso2.setText(y + "");
            txtso3.setText(z + "");
            txtd1.setText("+");
            txtd2.setText("-");
            if ((x + y) < z) {
                Pheptoan();
            }
            sum = (x + (y - z));
        }
        if (dau1 == 0) {
            if (dau2 ==1)
            {
                txtso1.setText(x + "");
                txtso2.setText(y + "");
                txtso3.setText(z + "");
                txtd1.setText("-");
                txtd2.setText("+");
                if (x < y) {
                    Pheptoan();
                }
                sum = ((x - y) + z);
            } else if (dau2 == 0)
            {
                txtso1.setText(x + "");
                txtso2.setText(y + "");
                txtso3.setText(z + "");
                txtd1.setText("-");
                txtd2.setText("-");
                if ((x - y - z) < 0) {
                    Pheptoan();
                }
                sum = (x - y - z);
            }
        }

    }
    public  void ramdom()
    {
        TestRandomX();
        TestRandomY();
        TestRandomZ();
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
        d=a.nextInt(2);
        return d;
    }
    private int TestRandomE(){
        Random a = new Random();
        dau1=a.nextInt(2);
        return dau1;
    }
    private int TestRandomF(){
        Random a = new Random();
        dau2=a.nextInt(2);
        return dau2;
    }
    public void animaD()
    {
        final ImageView zoom = (ImageView) findViewById(R.id.imageView);
        final Animation zoomanimation = AnimationUtils.loadAnimation(Phep_toan_TH.this, R.anim.zoom);
        zoom.startAnimation(zoomanimation);
    }
    public void animaS()
    {
        final ImageView zoom = (ImageView) findViewById(R.id.imageView2);
        final Animation zoomanimation = AnimationUtils.loadAnimation(Phep_toan_TH.this, R.anim.zoom);
        zoom.startAnimation(zoomanimation);
    }
}