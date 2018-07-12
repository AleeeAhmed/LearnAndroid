package com.ali.learnandroid.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ali.learnandroid.Activities.Home;
import com.ali.learnandroid.Activities.SnackBarAction;
import com.ali.learnandroid.R;
import com.ali.learnandroid.Activities.SnackBarSimple;

/**
 * A simple {@link Fragment} subclass.
 */
public class Frag_SnackBars extends Fragment {

    View view;
    Button btnSimpleSnackbar, btnSnackBarAction;

    public Frag_SnackBars() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_snack_bars, container, false);

        getActivity().setTitle("SnackBar");

        btnSimpleSnackbar = view.findViewById(R.id.btnSimpleSnackBar);
        btnSnackBarAction = view.findViewById(R.id.btnActionSnackBar);

        btnSimpleSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SnackBarSimple.class));
            }
        });

        btnSnackBarAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SnackBarAction.class));
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
