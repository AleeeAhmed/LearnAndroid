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

import com.ali.learnandroid.Activities.AlertDialogWithCheckBoxes;
import com.ali.learnandroid.Activities.AlertDialogWithImages;
import com.ali.learnandroid.Activities.AlertDialogWithRadioButtons;
import com.ali.learnandroid.Activities.Home;
import com.ali.learnandroid.Activities.AlertDialogSimple;
import com.ali.learnandroid.Activities.AlertDialogWithEditText;
import com.ali.learnandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Frag_AlertDialogs extends Fragment {

    View view;
    Button btnSimple, btnWithEditText, btnWithCheckBoxes, btnWithRadioButtons, btnWithImages ;
    RelativeLayout rlAlertDialogs;
    private Animation animation;

    public Frag_AlertDialogs() {
        // Required empty public constructor
    }

    private void init() {

        btnSimple = view.findViewById(R.id.btnSimpleAlertDialog);
        btnWithCheckBoxes = view.findViewById(R.id.btnCheckBoxAlertDialog);
        btnWithEditText = view.findViewById(R.id.btnEditTextAlertDialog);
        btnWithRadioButtons = view.findViewById(R.id.btnRadioButtonsAlertDialog);
        btnWithImages = view.findViewById(R.id.btnImagesAlertDialog);

        rlAlertDialogs = view.findViewById(R.id.RLAlertDialogs);

    }

    @Override
    public void onResume() {
        rlAlertDialogs.startAnimation(animation);
        getActivity().setTitle("Alert Dialogs");
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_alert_dialogs, container, false);


        init();

        animation = AnimationUtils.loadAnimation(getActivity(), R.anim.move);

        rlAlertDialogs.startAnimation(animation);
        getActivity().setTitle("Alert Dialogs");

        btnSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AlertDialogSimple.class));
            }
        });

        btnWithCheckBoxes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AlertDialogWithCheckBoxes.class));
            }
        });

        btnWithEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AlertDialogWithEditText.class));
            }
        });

        btnWithRadioButtons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AlertDialogWithRadioButtons.class));
            }
        });

        btnWithImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AlertDialogWithImages.class));
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
