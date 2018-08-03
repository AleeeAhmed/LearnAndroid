package com.ali.learnandroid.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ali.learnandroid.R;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomImage;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.io.File;

public class ExtrasPicasso extends AppCompatActivity {

    ImageView ivCode1, ivCode2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extras_picasso);

        ivCode1 = findViewById(R.id.ivCodePicassoStep1);
        ivCode2 = findViewById(R.id.ivCodePicassoStep2);

        ivCode1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(ExtrasPicasso.this, R.drawable.picasso_step1,
                        getResources().getString(R.string.picasso_step1));
            }
        });

        ivCode1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ExtrasPicasso.this,
                        getResources().getString(R.string.picasso_step1));
                return true;
            }
        });

        ivCode2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(ExtrasPicasso.this, R.drawable.picasso_step2,
                        getResources().getString(R.string.picasso_step2));
            }
        });

        ivCode2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ExtrasPicasso.this,
                        getResources().getString(R.string.picasso_step2));
                return true;
            }
        });

    }
}
