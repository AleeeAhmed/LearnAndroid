package com.ali.learnandroid.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.ali.learnandroid.R;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomImage;

public class AlertDialogWithImages extends AppCompatActivity {


    Button btnDemo;
    ImageView ivCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_with_images);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        btnDemo = findViewById(R.id.btnDemoImagesAlertDialog);
        ivCode = findViewById(R.id.ivCodeImages);

        ivCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(AlertDialogWithImages.this,
                            R.drawable.alert_dialog_with_images);
            }
        });

        ivCode.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(AlertDialogWithImages.this,
                        getResources().getString(R.string.images_alert_dialog));
                return true;
            }
        });

        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder dialog = new AlertDialog.Builder(AlertDialogWithImages.this);
                dialog.setTitle("Images");
                View mView = getLayoutInflater().inflate(R.layout.sample_images_alert_dialog, null);
                //ImageView ivFirst = mView.findViewById(R.id.ivFirstImageAlertDialog);
                //ImageView ivSecond = mView.findViewById(R.id.ivSecondImageAlertDialog);
                dialog.setView(mView);
                dialog.setPositiveButton("Close", null);
/*
                ivSecond.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
*/
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
