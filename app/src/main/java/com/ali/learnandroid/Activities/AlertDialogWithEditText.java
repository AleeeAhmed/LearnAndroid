package com.ali.learnandroid.Activities;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.ali.learnandroid.Utils.Alert_Dialog_Settings;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
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

import es.dmoral.toasty.Toasty;

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
                if (ContextCompat.checkSelfPermission(AlertDialogWithEditText.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(AlertDialogWithEditText.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
                } else {
                    ZoomImage.show(AlertDialogWithEditText.this, R.drawable.alert_dialog_edittext_image);
                }
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
                if (ContextCompat.checkSelfPermission(AlertDialogWithEditText.this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(AlertDialogWithEditText.this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
            } else {
                    ZoomImage.show(AlertDialogWithEditText.this, R.drawable.alert_dialog_edittext2_image);
                }
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


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull
            String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == 100) {
            if (grantResults.length > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                Toasty.success(this, "Permission allowed." +
                        "You can now view and share images. Thank you.", Toast.LENGTH_SHORT).show();

            } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {

                if (ActivityCompat.shouldShowRequestPermissionRationale(AlertDialogWithEditText.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                    Toasty.warning(getApplicationContext(),
                            "Please allow Storage Permission to view and share images.",
                            Toast.LENGTH_LONG).show();
                } else {
                    String message = "Storage Permission required."
                            +"Goto Permissions and allow the Storage permission.";
                    Alert_Dialog_Settings.showDialog(this,"Permission", message);
                }
            }
        }

    }

}
