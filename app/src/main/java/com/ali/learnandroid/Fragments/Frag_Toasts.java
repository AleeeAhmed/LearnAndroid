package com.ali.learnandroid.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ali.learnandroid.Activities.Home;
import com.ali.learnandroid.Activities.ToastMessageColored;
import com.ali.learnandroid.Activities.ToastMessageSimple;
import com.ali.learnandroid.R;
import com.ali.learnandroid.Activities.ToastMessageCustom;

/**
 * A simple {@link Fragment} subclass.
 */
public class Frag_Toasts extends Fragment {

    View view;
    Button btnSimpleToast,btnColoredToast, btnCustomToast;

    public Frag_Toasts() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_toasts, container, false);

        getActivity().setTitle("Toasts");

        btnSimpleToast = view.findViewById(R.id.btnSimpleToastMessage);
        btnColoredToast = view.findViewById(R.id.btnColoredToastMessage);
        btnCustomToast = view.findViewById(R.id.btnCustomToastMessage);

        btnSimpleToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ToastMessageSimple.class));
            }
        });

        btnColoredToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ToastMessageColored.class));
            }
        });

        btnCustomToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ToastMessageCustom.class));
            }
        });

        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {

                    Intent intent = new Intent(getActivity(), Home.class);
                    startActivity(intent);
                    getActivity().finish();
                    return true;
                }
                return false;
            }
        });


        return view;
    }

}
