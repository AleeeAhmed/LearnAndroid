package com.ali.learnandroid.Activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ali.learnandroid.R;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomImage;

public class AlertDialogWithEditText extends AppCompatActivity {

    ImageView ivCode, ivCode2;
    Button btnDemo, btnDemo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_with_edit_text);


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ivCode = findViewById(R.id.ivCodeEditText);
        btnDemo = findViewById(R.id.btnDemoAlertDialogEditText);

        ivCode2 = findViewById(R.id.ivCode2EditText);
        btnDemo2 = findViewById(R.id.btnDemo2AlertDialogEditText);


        ivCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(AlertDialogWithEditText.this, R.drawable.alert_dialog_edittext_image);
            }
        });


        ivCode.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(AlertDialogWithEditText.this,
                        getResources().getString(R.string.edittext_alert_dialog_first));
                return true;
            }
        });


        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(AlertDialogWithEditText.this);
                dialog.setTitle("Password");
                dialog.setMessage("Enter Password");

                final EditText input = new EditText(AlertDialogWithEditText.this); //creating custom editText
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT ); //setting its width(layout_width) and height(layout_height)
                input.setLayoutParams(lp); //attaching with editText
                dialog.setView(input); //setting view to AlertDialog
                dialog.setIcon(R.drawable.logo); // setting up AlertDialog Icon

                //positive button(Ok) click listener,
                dialog.setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                String password = input.getText().toString();
                                Toast.makeText(AlertDialogWithEditText.this ,
                                        "your password is "+password, Toast.LENGTH_SHORT).show();
                            }
                        });
                dialog.setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                dialog.show(); //finally Showing the alert dialog,

            }
        });

        ivCode2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(AlertDialogWithEditText.this, R.drawable.alert_dialog_edittext2_image);
            }
        });

        ivCode2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(AlertDialogWithEditText.this,
                        getResources().getString(R.string.edittext_alert_dialog_second));
                return true;
            }
        });

        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(AlertDialogWithEditText.this);
                dialog.setTitle("Password");
                View mView = getLayoutInflater().inflate(R.layout.sample_edittext, null);
                final EditText editText = mView.findViewById(R.id.etPassword);
                dialog.setView(mView);

                dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String password = editText.getText().toString();
                        Toast.makeText(getApplicationContext(), "your password is " + password, Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.show();



            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
