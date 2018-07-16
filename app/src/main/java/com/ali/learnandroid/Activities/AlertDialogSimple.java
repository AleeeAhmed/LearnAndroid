package com.ali.learnandroid.Activities;

import android.Manifest;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
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
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.ali.learnandroid.R;
import com.ali.learnandroid.Utils.Alert_Dialog_Settings;
import com.ali.learnandroid.Utils.BackgroundProcessPOST;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomImage;

import es.dmoral.toasty.Toasty;

public class AlertDialogSimple extends AppCompatActivity  {

    Button btnDemo;
    ImageView ivCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_alert_dialog);


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }



        btnDemo = findViewById(R.id.btnDemoSimpleAlertDialog);
        ivCode = findViewById(R.id.ivCode);

        ivCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(AlertDialogSimple.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(AlertDialogSimple.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
                } else {
                    ZoomImage.show(AlertDialogSimple.this, R.drawable.alert_dialog_simple_image);
                }
            }
        });

        ivCode.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(AlertDialogSimple.this, getResources().getString(R.string.simple_alert_dialog));
                return true;
            }
        });

        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(AlertDialogSimple.this
                        /*, R.style.DialogTheme*/); //MainActivity.this(for Activity)
                // or getActivity(for Fragment)
                dialog.setCancelable(true);
                dialog.setTitle("Title Of Dialog");
                dialog.setMessage("Message will be added here..");
                dialog.setIcon(R.drawable.logo);


                dialog.setPositiveButton("First", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(AlertDialogSimple.this, "you have clicked first button", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.setNegativeButton("Second", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(AlertDialogSimple.this, "you have clicked second button", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.setNeutralButton("Third", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(AlertDialogSimple.this, "you have clicked third button", Toast.LENGTH_SHORT).show();
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

                if (ActivityCompat.shouldShowRequestPermissionRationale(AlertDialogSimple.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                    Toasty.warning(getApplicationContext(),
                            "Please allow Storage Permission to view and share images.",
                            Toast.LENGTH_LONG).show();
                } else {
                    String message = "Storage Permission required.\nGoto Permissions and allow the Storage permission.";
                    Alert_Dialog_Settings.showDialog(this,"Permission", message);
                }
            }
        }

    }


}
