package com.ali.learnandroid.Fragments;


import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;

import com.ali.learnandroid.Activities.ToolbarSearch;
import com.ali.learnandroid.Utils.Alert_Dialog_Settings;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.ali.learnandroid.Activities.AlertDialogSimple;
import com.ali.learnandroid.Activities.AlertDialogWithImages;
import com.ali.learnandroid.Activities.Home;
import com.ali.learnandroid.Activities.SnackBarAction;
import com.ali.learnandroid.R;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomImage;

import es.dmoral.toasty.Toasty;

/**
 * A simple {@link Fragment} subclass.
 */
public class Frag_FAB extends Fragment {

    View view;
    Button btnDemo;
    ImageView ivCode;


    public Frag_FAB() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        getActivity().setTitle("Floating Action Button");
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fab, container, false);

        getActivity().setTitle("Floating Action Button");

        FloatingActionButton fab = view.findViewById(R.id.fabBack);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "FAB clicked..", Toast.LENGTH_SHORT).show();
            }
        });

        btnDemo = view.findViewById(R.id.btnDemoFAB);
        ivCode = view.findViewById(R.id.ivCodeFAB);

        ivCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);

                } else {
                    ZoomImage.show(getActivity(), R.drawable.fab_code);
                }
            }
        });

        ivCode.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(getActivity(),
                        getResources().getString(R.string.fab_code));
                return true;
            }
        });

        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setTitle("Floating Action Buttons");
                //dialog.setMessage("These pink circular buttons are FABs");
                View mView = getLayoutInflater().inflate(R.layout.sample_images_alert_dialog, null);
                ImageView ivFirst = mView.findViewById(R.id.ivFirstImageAlertDialog);
                ImageView ivSecond = mView.findViewById(R.id.ivSecondImageAlertDialog);
                dialog.setView(mView);
                dialog.setPositiveButton("Close", null);
                ivFirst.setImageResource(R.drawable.fab);
                ivSecond.setImageResource(R.drawable.fab_1);
                dialog.show();

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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull
            String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == 100) {
            if (grantResults.length > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                Toasty.success(getActivity(), "Permission allowed." +
                        "You can now view and share images. Thank you.", Toast.LENGTH_SHORT).show();

            } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {

                if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                    Toasty.warning(getActivity(),
                            "Please allow Storage Permission to view and share images.",
                            Toast.LENGTH_LONG).show();
                } else {
                    String message = "Storage Permission required."
                            +"Goto Permissions and allow the Storage permission.";
                    Alert_Dialog_Settings.showDialog(getActivity(),"Permission", message);
                }
            }
        }

    }



}
