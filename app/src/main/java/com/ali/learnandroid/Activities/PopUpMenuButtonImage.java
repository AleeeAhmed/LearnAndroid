package com.ali.learnandroid.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.ali.learnandroid.R;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomImage;

import pl.droidsonroids.gif.GifImageView;

public class PopUpMenuButtonImage extends AppCompatActivity {

    ImageView ivCode2,ivCode3;
    GifImageView ivCode;
    Button btnDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_menu_button_image);


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        /*Intializations*/
        ivCode = findViewById(R.id.ivCodePopupButtonImageStep1);
        ivCode2 = findViewById(R.id.ivCodePopupButtonImageStep2);
        ivCode3 = findViewById(R.id.ivCodePopupButtonImageStep3);
        btnDemo = findViewById(R.id.btnDemoPopupButtonImage);


        ivCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(PopUpMenuButtonImage.this, R.drawable.popup_butn_menu_gif_images);
            }
        });

        ivCode.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(PopUpMenuButtonImage.this,
                        R.string.nothing_here, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        ivCode2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(PopUpMenuButtonImage.this, R.drawable.pop_up_menu_xml);
            }
        });

        ivCode2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(PopUpMenuButtonImage.this,
                        getResources().getString(R.string.pop_up_menu_xml_string));
                return true;
            }
        });

        ivCode3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(PopUpMenuButtonImage.this, R.drawable.pop_up_menu_java);
            }
        });

        ivCode3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(PopUpMenuButtonImage.this,
                        getResources().getString(R.string.pop_up_menu_java_string));
                return true;
            }
        });

        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(PopUpMenuButtonImage.this, btnDemo);
                popupMenu.getMenuInflater().inflate(R.menu.sample_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.changePassword) {
                            Toast.makeText(PopUpMenuButtonImage.this,
                                    "Change Password Clicked..", Toast.LENGTH_SHORT).show();
                            return true;
                        }
                        if (item.getItemId() == R.id.logout) {
                            Toast.makeText(PopUpMenuButtonImage.this,
                                    "Logout Clicked...", Toast.LENGTH_SHORT).show();
                            return true;
                        }
                        return false;
                    }
                });
                popupMenu.show();
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
