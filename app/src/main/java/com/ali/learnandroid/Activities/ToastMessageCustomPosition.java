package com.ali.learnandroid.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import com.ali.learnandroid.Utils.Alert_Dialog_Settings;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ali.learnandroid.R;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomImage;

import es.dmoral.toasty.Toasty;

public class ToastMessageCustomPosition extends AppCompatActivity {

    Button btnDemo;
    ImageView ivCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_message_custom_position);

        btnDemo = findViewById(R.id.btnDemoCustomToastPosition);
        ivCode = findViewById(R.id.ivCodeCustomToastPosition);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ivCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ToastMessageCustomPosition.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);

                } else {
                    ZoomImage.show(ToastMessageCustomPosition.this,R.drawable.custom_toast_postion);
                }
            }
        });
        ivCode.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ToastMessageCustomPosition.this,
                        getResources().getString(R.string.position_toast));
                return true;
            }
        });

        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast toast = new Toast(ToastMessageCustomPosition.this); //intializing

                View view = getLayoutInflater().inflate(R.layout.sample_toast_pos,  // xml layout to be displayed in Toast
                        (ViewGroup) findViewById(R.id.custom_toast_container_position)); // Layout Name

                TextView text = (TextView) view.findViewById(R.id.toast_text);
                text.setText("Here is Custom Toast");
                //Three arguments are passed in below line.
                //First shows the position, where it will be displayed, 2nd is X-Axis 3rd is Y-Axis
                //Negative X value will move message to Left, -ve Y value will move towards Top
                toast.setGravity(Gravity.CENTER, -50, 200);

                //toast.setGravity(Gravity.BOTTOM, 120, 200);
                // toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, -120, 200); you can add two value to position like this
                // toast.setGravity(Gravity.CENTRE, -20, -20);
                //toast.setGravity(Gravity.END | Gravity.TOP, 0, 0);

                toast.setDuration(Toast.LENGTH_LONG); // duration it displayed on screen
                toast.setView(view);

                toast.show();

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

                if (ActivityCompat.shouldShowRequestPermissionRationale(ToastMessageCustomPosition.this,
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
