package com.ali.learnandroid.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.ali.learnandroid.R;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomImage;

public class ExtrasChips extends AppCompatActivity {

    RelativeLayout rlChips;
    ImageView ivStep1, ivStep2, ivStep3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extras_chips);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        rlChips = findViewById(R.id.RL_ExtrasChips);

        ivStep1 = findViewById(R.id.ivCodeChipsStep1);
        ivStep2 = findViewById(R.id.ivCodeChipsStep2);
        ivStep3 = findViewById(R.id.ivCodeChipsStep3);

        Animation anim = AnimationUtils.loadAnimation(ExtrasChips.this, R.anim.zoom_in);
        rlChips.startAnimation(anim);

        ivStep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(ExtrasChips.this, R.drawable.extras_chips_step1);
            }
        });

        ivStep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(ExtrasChips.this, R.drawable.extras_chips_step2);
            }
        });

        ivStep3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(ExtrasChips.this, R.drawable.extras_chips_step3);
            }
        });

        ivStep1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ExtrasChips.this,
                        getResources().getString(R.string.chips_step1));
                return true;
            }
        });
        ivStep2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ExtrasChips.this,
                        getResources().getString(R.string.chips_step2));
                return true;
            }
        });
        ivStep3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ExtrasChips.this,
                        getResources().getString(R.string.chips_step3));
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
        return false;
    }
}
