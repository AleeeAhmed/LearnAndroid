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

import com.ali.learnandroid.Activities.AlertDialogSimple;
import com.ali.learnandroid.Activities.AlertDialogWithCheckBoxes;
import com.ali.learnandroid.Activities.AlertDialogWithEditText;
import com.ali.learnandroid.Activities.AlertDialogWithImages;
import com.ali.learnandroid.Activities.AlertDialogWithRadioButtons;
import com.ali.learnandroid.Activities.AnimationCustom;
import com.ali.learnandroid.Activities.AnimationExplosion;
import com.ali.learnandroid.Activities.AnimationFoldingCell;
import com.ali.learnandroid.Activities.AnimationLibrary;
import com.ali.learnandroid.Activities.Home;
import com.ali.learnandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Frag_Anim extends Fragment {

    View view;
    Button btnCustomAnimation, btnAnimationLib, btnExplosionAnimation, btnFoldingAnimation;
    RelativeLayout rlAnimation;
    private Animation animation;

    public Frag_Anim() {
        // Required empty public constructor
    }


    private void init() {

        btnCustomAnimation = view.findViewById(R.id.btnCustomAnimation);
        btnAnimationLib = view.findViewById(R.id.btnAnimationLibrary);
        btnExplosionAnimation = view.findViewById(R.id.btnExplosionAnimation);
        btnFoldingAnimation = view.findViewById(R.id.btnFoldingAnimation);

        rlAnimation = view.findViewById(R.id.RL_Animations);

    }

    @Override
    public void onResume() {
        rlAnimation.startAnimation(animation);
        getActivity().setTitle("Animations");
        super.onResume();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_anim, container, false);


        init();

        animation = AnimationUtils.loadAnimation(getActivity(), R.anim.move);

        rlAnimation.startAnimation(animation);
        getActivity().setTitle("Animations");

        btnCustomAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AnimationCustom.class));
            }
        });

        btnAnimationLib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AnimationLibrary.class));
            }
        });

        btnExplosionAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AnimationExplosion.class));
            }
        });

        btnFoldingAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AnimationFoldingCell.class));
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
