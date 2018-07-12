package com.ali.learnandroid.Activities;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ali.learnandroid.R;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomImage;

import tyrantgit.explosionfield.ExplosionField;

public class AnimationExplosion extends AppCompatActivity {

    Button btnDemo;
    ExplosionField explosionField;
    private ImageView ivCodeStep1,ivCodeStep2;


    private void init() {
        ivCodeStep1 = findViewById(R.id.ivCodeExplosionAnimationStep1);
        ivCodeStep2 = findViewById(R.id.ivCodeExplosionAnimationStep2);

        explosionField = ExplosionField.attach2Window(this);
        btnDemo = findViewById(R.id.btnDemoExplosionAnimation);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_explosion);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();

        //region ImageView Clicks
        ivCodeStep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(AnimationExplosion.this, R.drawable.explosion_anim_step1);
            }
        });
        ivCodeStep1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(AnimationExplosion.this,
                        getResources().getString(R.string.explosion_step1));
                return true;
            }
        });

        ivCodeStep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(AnimationExplosion.this, R.drawable.explosion_anim_step2);
            }
        });
        ivCodeStep2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(AnimationExplosion.this,
                        getResources().getString(R.string.explosion_step2));
                return true;
            }
        });
        //endregion
        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                explosionField.explode(btnDemo);
                explosionField.expandExplosionBound(111,111);
            }
        });
    }

    @Override
    public void onBackPressed() {
            finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
