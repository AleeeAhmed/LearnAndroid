package com.ali.learnandroid.Activities;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ali.learnandroid.R;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomImage;
import com.pes.androidmaterialcolorpickerdialog.ColorPicker;
import com.pes.androidmaterialcolorpickerdialog.ColorPickerCallback;

public class PickerColor extends AppCompatActivity {

    Button btnDemo;
    ImageView ivCodeStep1, ivCodeStep2;
    int red = 0, green = 0 , blue = 0, alpha = 255;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker_color);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ivCodeStep1 = findViewById(R.id.ivCodeColorPickerStep1);
        ivCodeStep2 = findViewById(R.id.ivCodeColorPickerStep2);
        btnDemo = findViewById(R.id.btnDemoColorPicker);

        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ColorPicker colorPicker =
                        new ColorPicker(PickerColor.this, alpha,red, green, blue);
                colorPicker.show();
                colorPicker.setCallback(new ColorPickerCallback() {
                    @Override
                    public void onColorChosen(@ColorInt int color) {
                        alpha = colorPicker.getAlpha();
                        red = colorPicker.getRed();
                        green = colorPicker.getGreen();
                        blue = colorPicker.getBlue();

                        btnDemo.setBackgroundColor(color);   //setting selected color as buttons background
                        colorPicker.dismiss();
                    }
                });
            }
        });



        ivCodeStep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(PickerColor.this, R.drawable.color_picker_step1);
            }
        });

        ivCodeStep1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(PickerColor.this,
                        getResources().getString(R.string.pick_color_step1));
                return true;
            }
        });

        ivCodeStep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(PickerColor.this, R.drawable.color_picker_step2);
            }
        });

        ivCodeStep2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(PickerColor.this,
                        getResources().getString(R.string.pick_color_step2));
                return true;
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
