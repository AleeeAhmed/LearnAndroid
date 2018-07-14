package com.ali.learnandroid.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ali.learnandroid.Activities.ExtrasCall;
import com.ali.learnandroid.Activities.ExtrasCardView;
import com.ali.learnandroid.Activities.ExtrasChips;
import com.ali.learnandroid.Activities.ExtrasColors;
import com.ali.learnandroid.Activities.ExtrasExpandableTextView;
import com.ali.learnandroid.Activities.ExtrasGIF;
import com.ali.learnandroid.Activities.ExtrasSendSms;
import com.ali.learnandroid.Activities.ExtrasStrings;
import com.ali.learnandroid.Activities.ExtrasViewPager;
import com.ali.learnandroid.Activities.Home;
import com.ali.learnandroid.R;

import es.dmoral.toasty.Toasty;

/**
 * A simple {@link Fragment} subclass.
 */
public class Frag_Extras extends Fragment {

    View view;
    RelativeLayout rlExtras;
    Button btnColors , btnStrings, btnGIF, btnViewPager,
            btnChips, btnExpanable, btnCall, btnSendSMS, btnCardView, btn;

    private Animation animation;

    public Frag_Extras() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_extras, container, false);

        getActivity().setTitle("Extras");

        init();

        rlExtras.startAnimation(animation);

        btnColors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ExtrasColors.class));
            }
        });

        btnStrings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ExtrasStrings.class));
            }
        });

        btnGIF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ExtrasGIF.class));
            }
        });
        btnViewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ExtrasViewPager.class));
            }
        });
        btnChips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ExtrasChips.class));
            }
        });
        btnExpanable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ExtrasExpandableTextView.class));
            }
        });
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ExtrasCall.class));
            }
        });
        btnSendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ExtrasSendSms.class));
            }
        });
        btnCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ExtrasCardView.class));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toasty.normal(getActivity(), "Under Construction..!!").show();
            }
        });

        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    startActivity(new Intent(getActivity(), Home.class));
                    getActivity().finish();
                    return true;
                }
                return false;
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        rlExtras.startAnimation(animation);
        super.onResume();
    }

    private void init() {
        btnColors = view.findViewById(R.id.btnColors);
        btnStrings = view.findViewById(R.id.btnStrings);
        btnGIF = view.findViewById(R.id.btnGif);
        btnViewPager = view.findViewById(R.id.btnViewPager);
        btnChips = view.findViewById(R.id.btnChips);
        btnExpanable = view.findViewById(R.id.btnExpandableTextView);
        btnCall = view.findViewById(R.id.btnCall);
        btnSendSMS = view.findViewById(R.id.btnSMS);
        btnCardView= view.findViewById(R.id.btnCardView);
        btn = view.findViewById(R.id.btn);

        animation = AnimationUtils.loadAnimation(getActivity(), R.anim.extras_move);
        rlExtras = view.findViewById(R.id.RL_Extras);

    }

}
