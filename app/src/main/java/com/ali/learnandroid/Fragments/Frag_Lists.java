package com.ali.learnandroid.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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

import com.ali.learnandroid.Activities.ExtrasListView;
import com.ali.learnandroid.Activities.ExtrasRecyclerView;
import com.ali.learnandroid.Activities.Home;
import com.ali.learnandroid.Activities.PickerColor;
import com.ali.learnandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Frag_Lists extends Fragment {

    View view;
    RelativeLayout rlLists;
    Button btnListView, btnRecyclerView;
    Animation animationMove, animationFadeOut;

    public Frag_Lists() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_lists, container, false);

        getActivity().setTitle("Lists");

        btnListView = view.findViewById(R.id.btnListViewLists);
        btnRecyclerView = view.findViewById(R.id.btnRecyclerViewLists);
        rlLists = view.findViewById(R.id.RL_Lists);

        animationMove = AnimationUtils.loadAnimation(getActivity(), R.anim.move);
        animationFadeOut = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out);
        rlLists.startAnimation(animationMove);

        btnListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rlLists.startAnimation(animationFadeOut);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getActivity(), ExtrasListView.class));
                    }
                }, 1100);
            }
        });

        btnRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rlLists.startAnimation(animationFadeOut);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getActivity(), ExtrasRecyclerView.class));
                    }
                }, 1100);
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
        rlLists.startAnimation(animationMove); super.onResume();
    }
}
