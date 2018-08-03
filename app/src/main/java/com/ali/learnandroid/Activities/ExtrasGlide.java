package com.ali.learnandroid.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.ali.learnandroid.R;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomImage;


public class ExtrasGlide extends AppCompatActivity {


    ImageView ivCode1, ivCode2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extras_glide);


        ivCode1 = findViewById(R.id.ivCodeGlideStep1);
        ivCode2 = findViewById(R.id.ivCodeGlideStep2);

        ivCode1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(ExtrasGlide.this, R.drawable.glide_step1,
                        getResources().getString(R.string.glide_step1));
            }
        });

        ivCode1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ExtrasGlide.this,
                        getResources().getString(R.string.glide_step1));
                return true;
            }
        });

        ivCode2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(ExtrasGlide.this, R.drawable.glide_step2,
                        getResources().getString(R.string.glide_step2));
            }
        });

        ivCode2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ExtrasGlide.this,
                        getResources().getString(R.string.glide_step2));
                return true;
            }
        });

    }

}
