package com.ali.learnandroid.Activities;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.ali.learnandroid.R;
import com.ali.learnandroid.Utils.BackgroundProcessPOST;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomImage;

public class AlertDialogSimple extends AppCompatActivity implements BackgroundProcessPOST.AsyncResponse {

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
                ZoomImage.show(AlertDialogSimple.this, R.drawable.alert_dialog_simple_image);
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
    public void resultsFromBackgroundTask(String results) {
        //if result is JSON form. you can get it using json object or json array
        //we are just toast the results

        Toast.makeText(this, results, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void exceptionFromBackgroundTask(String exception) {
        //you can display Exception as you need.

        Toast.makeText(this, exception, Toast.LENGTH_SHORT).show();
    }
}
