package com.example.mypc.app_toan_lop_1;

import android.app.Fragment;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.mypc.app_toan_lop_1.R;

/**
 * Created by MyPC on 08/04/2016.
 */
public class sosanh_activity  extends Fragment {
    int sum1 = Phep_toan_TH.sum;
    int sum2 = Phep_toan_TH.sum1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_ketqua,container,false);
        Button btnlon = (Button) view.findViewById(R.id.btnLon);
        btnlon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sum1 > sum2) {
                    ((Phep_toan_TH)getActivity()).animaD();
                    MediaPlayer mp = MediaPlayer.create(getActivity(),R.raw.good);
                    mp.start();
                    ((Phep_toan_TH)getActivity()).xuly();

                } else {
                    ((Phep_toan_TH)getActivity()).animaS();
                    MediaPlayer mp = MediaPlayer.create(getActivity(),R.raw.error);
                    mp.start();
                }

            }
        });
        Button btnbe = (Button) view.findViewById(R.id.btnBe);
        btnbe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sum1 < sum2) {
                    ((Phep_toan_TH)getActivity()).animaD();
                    MediaPlayer mp = MediaPlayer.create(getActivity(),R.raw.good);
                    mp.start();
                    ((Phep_toan_TH)getActivity()).xuly();

                } else {
                    ((Phep_toan_TH)getActivity()).animaS();
                    MediaPlayer mp = MediaPlayer.create(getActivity(),R.raw.error);
                    mp.start();
                }

            }
        });
        Button btnbang = (Button) view.findViewById(R.id.btnBang);
        btnbang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sum1 == sum2) {
                    ((Phep_toan_TH)getActivity()).animaD();
                    MediaPlayer mp = MediaPlayer.create(getActivity(),R.raw.good);
                    mp.start();
                    ((Phep_toan_TH)getActivity()).xuly();

                } else {
                    ((Phep_toan_TH)getActivity()).animaS();
                    MediaPlayer mp = MediaPlayer.create(getActivity(),R.raw.error);
                    mp.start();
                }
            }
        });
        return view;
    }
}
