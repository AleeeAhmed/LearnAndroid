package com.ali.learnandroid.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ali.learnandroid.R;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomImage;

import pl.droidsonroids.gif.GifImageView;

public class PopUpMenuToolbar extends AppCompatActivity {

    ImageView ivCode2,ivCode3;
    GifImageView ivCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_menu_toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        /*Intializations*/
        ivCode = findViewById(R.id.ivCodePopupToolbarStep1);
        ivCode2 = findViewById(R.id.ivCodePopupToolbarStep2);
        ivCode3 = findViewById(R.id.ivCodePopupToolbarStep3);


        ivCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(PopUpMenuToolbar.this, R.drawable.popup_butn_menu_gif_images);
            }
        });

        ivCode.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(PopUpMenuToolbar.this,
                        R.string.nothing_here, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        ivCode2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(PopUpMenuToolbar.this, R.drawable.pop_up_menu_toolbar_java);
            }
        });

        ivCode2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(PopUpMenuToolbar.this,
                        getResources().getString(R.string.pop_up_menu_toolbar_java_string));
                return true;
            }
        });

        ivCode3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(PopUpMenuToolbar.this, R.drawable.pop_up_menu_xml);
            }
        });

        ivCode3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(PopUpMenuToolbar.this,
                        getResources().getString(R.string.pop_up_menu_xml_string));
                return true;
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.changePassword) {
            Toast.makeText(this, "Change Password Clicked..", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.logout) {
            Toast.makeText(this, "Logout Clicked..", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return false;
    }

}
