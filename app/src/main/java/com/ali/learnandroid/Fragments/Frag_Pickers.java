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

import com.ali.learnandroid.Activities.PickerColor;
import com.ali.learnandroid.Activities.PickerDate;
import com.ali.learnandroid.Activities.PickerGalleryyFile;
import com.ali.learnandroid.Activities.Home;
import com.ali.learnandroid.Activities.PickerCameraImage;
import com.ali.learnandroid.Activities.PickerGalleryImage;
import com.ali.learnandroid.Activities.PickerTime;
import com.ali.learnandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Frag_Pickers extends Fragment {

    View view;
    Button btnGallery, btnCamera, btnFile, btnTimePicker, btnDatePicker, btnColorPicker;
    RelativeLayout rlPickers;
    Button[] buttons;
    Animation animationMove, animationFadeOut;

    public Frag_Pickers() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pickers, container, false);

        getActivity().setTitle("Pickers");

        init();

        animationMove = AnimationUtils.loadAnimation(getActivity(), R.anim.move);
        animationFadeOut = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out);
        rlPickers.startAnimation(animationMove);

        btnGallery .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rlPickers.startAnimation(animationFadeOut);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getActivity(), PickerGalleryImage.class));
                    }
                }, 1100);
            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rlPickers.startAnimation(animationFadeOut);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getActivity(), PickerCameraImage.class));
                    }
                }, 1100);
            }
        });

        btnFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rlPickers.startAnimation(animationFadeOut);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getActivity(), PickerGalleryyFile.class));
                    }
                }, 1100);
            }
        });

        btnTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rlPickers.startAnimation(animationFadeOut);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getActivity(), PickerTime.class));
                    }
                }, 1100);
            }
        });

        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rlPickers.startAnimation(animationFadeOut);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getActivity(), PickerDate.class));
                    }
                }, 1100);
            }
        });

        btnColorPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rlPickers.startAnimation(animationFadeOut);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getActivity(), PickerColor.class));
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
        rlPickers.startAnimation(animationMove);
        super.onResume();
    }

    private void init() {
        btnCamera = view.findViewById(R.id.btnCameraPick);
        btnGallery = view.findViewById(R.id.btnGalleryPick);
        btnFile = view.findViewById(R.id.btnFilePick);
        btnTimePicker = view.findViewById(R.id.btnTimePick);
        btnDatePicker = view.findViewById(R.id.btnDatePicker);
        btnColorPicker = view.findViewById(R.id.btnColorPicker);
        rlPickers = view.findViewById(R.id.RL_Pickers);

        buttons = new Button[]{btnCamera,btnGallery, btnFile, btnTimePicker, btnDatePicker, btnColorPicker};

    }


}
