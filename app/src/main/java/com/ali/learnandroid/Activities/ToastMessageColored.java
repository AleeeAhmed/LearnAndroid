package com.ali.learnandroid.Activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ali.learnandroid.R;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomImage;

public class ToastMessageColored extends AppCompatActivity {
    ImageView ivCode;
    Button btnDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_message_colored);


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        ivCode = findViewById(R.id.ivCodeColoredToast);
        btnDemo = findViewById(R.id.btnDemoColoredToast);

        ivCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(ToastMessageColored.this, R.drawable.colored_toast);
            }
        });

        ivCode.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ToastMessageColored.this,
                        getResources().getString(R.string.colored_toast));
                return true;
            }
        });
        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast toast = Toast.makeText(ToastMessageColored.this, "This is advanced toast", Toast.LENGTH_LONG);
                View view = toast.getView(); // getting Toast view
                TextView view1 = view.findViewById(android.R.id.message); //custom textView
                view1.setTextColor(Color.WHITE);       //changing text color of toast
                view1.setPadding(11, 11, 11, 11); //setting inside padding
                view1.setTextSize(15f);     // text size for toast
                view.setBackgroundResource(android.R.color.holo_green_dark); //setting background color for toast
                toast.show();   // finally show the toast
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
