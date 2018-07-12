package com.ali.learnandroid.Activities;

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

public class ToastMessageCustomImage extends AppCompatActivity {

    Button btnDemo;
    ImageView ivCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_message_custom_image);

        btnDemo = findViewById(R.id.btnDemoCustomToastImage);
        ivCode = findViewById(R.id.ivCodeCustomToastImage);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ivCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(ToastMessageCustomImage.this,R.drawable.custom_toast_image);
            }
        });

        ivCode.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ToastMessageCustomImage.this,
                        getResources().getString(R.string.image_toast));
                return true;
            }
        });

        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflaterr = getLayoutInflater();
                View view = inflaterr.inflate(R.layout.sample_toast,  // xml layout to be displayed in Toast
                        (ViewGroup) findViewById(R.id.custom_toast_container)); // Layout Name

                TextView text = (TextView) view.findViewById(R.id.text);
                text.setText("Here is Custom Toast with Image");

                Toast toast = new Toast(ToastMessageCustomImage.this);
                toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 20, 20); // you can change the position from here
                toast.setDuration(Toast.LENGTH_LONG); // increase decrese time duration of display on screen
                toast.setView(view); // setting xml layout to toast
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


}
