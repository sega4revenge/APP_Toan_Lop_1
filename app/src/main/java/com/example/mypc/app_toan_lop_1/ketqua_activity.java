package com.example.mypc.app_toan_lop_1;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mypc.app_toan_lop_1.Phep_toan_TH;
import com.example.mypc.app_toan_lop_1.R;

/**
 * Created by MyPC on 08/04/2016.
 */
public class ketqua_activity extends Fragment {
    int sum = Phep_toan_TH.sum;
    MediaPlayer mp;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view =inflater.inflate(R.layout.fragmet_tonghop,container,false);
        Button btnTL = (Button) view.findViewById(R.id.button);
        btnTL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edtkq = (EditText) view.findViewById(R.id.edtkq);
                String str = edtkq.getText().toString();
                if (str.equals("")) {
                    Toast toast = Toast.makeText(getActivity(), "Bạn Chưa Trả Lời ", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    int kqedt = Integer.parseInt(edtkq.getText().toString());
                    if (sum - kqedt == 0) {
                        edtkq.setText("");
                        ((Phep_toan_TH) getActivity()).animaD();
                       mp = MediaPlayer.create(getActivity(),R.raw.good);
                        if (mp.isPlaying())
                        {
                            mp.stop();
                            mp.release();
                            mp = MediaPlayer.create(getActivity(),R.raw.good);
                        }
                        mp.start();
                        ((Phep_toan_TH) getActivity()).xuly();

                    } else if (sum - kqedt != 0) {
                        edtkq.setText("");
                        ((Phep_toan_TH) getActivity()).animaS();
                        mp = MediaPlayer.create(getActivity(),R.raw.error);
                        if (mp.isPlaying())
                        {
                            mp.stop();
                            mp.release();
                            mp = MediaPlayer.create(getActivity(),R.raw.error);
                        }
                        mp.start();
                    }
                }
            }
        });
        return view;
    }
}
