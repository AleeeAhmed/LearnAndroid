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

import com.ali.learnandroid.Activities.AsyncTaskGET;
import com.ali.learnandroid.Activities.AsyncTaskMultipart;
import com.ali.learnandroid.Activities.AsyncTaskPOST;
import com.ali.learnandroid.Activities.AsyncTaskRetrofitLib;
import com.ali.learnandroid.Activities.Home;
import com.ali.learnandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Frag_AsyncTasks extends Fragment {

    View view;
    Button btnPost, btnGet, btnMultipart, btnRetrofit;
    RelativeLayout rlAsyncTask;
    Animation animBounce, animSlideUp;

    public Frag_AsyncTasks() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        rlAsyncTask.startAnimation(animBounce);
        getActivity().setTitle("Async Task");
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_async_tasks, container, false);

        btnPost = view.findViewById(R.id.btnAsyncTaskPost);
        btnGet = view.findViewById(R.id.btnAsyncTaskGet);
        btnMultipart = view.findViewById(R.id.btnAsyncTaskMultipart);
        btnRetrofit = view.findViewById(R.id.btnRetrofitLibrary);
        rlAsyncTask = view.findViewById(R.id.RL_AsyncTasks);

        animBounce = AnimationUtils.loadAnimation(getActivity(), R.anim.bounce);
        animSlideUp = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_up);

        rlAsyncTask.startAnimation(animBounce);
        getActivity().setTitle("Async Task");


        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rlAsyncTask.startAnimation(animSlideUp);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getActivity(), AsyncTaskPOST.class));
                    }
                }, 1100);

            }
        });
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getActivity(), AsyncTaskGET.class));
                    }
                }, 1100);
                rlAsyncTask.startAnimation(animSlideUp);
            }
        });
        btnMultipart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getActivity(), AsyncTaskMultipart.class));
                    }
                }, 1100);
                rlAsyncTask.startAnimation(animSlideUp);
            }
        });

        btnRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getActivity(), AsyncTaskRetrofitLib.class));
                    }
                }, 1100);
                rlAsyncTask.startAnimation(animSlideUp);
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
