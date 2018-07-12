package com.ali.learnandroid.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ali.learnandroid.R;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomImage;
import com.ramotion.foldingcell.FoldingCell;

import at.blogc.android.views.ExpandableTextView;

public class AnimationFoldingCell extends AppCompatActivity {

    private FoldingCell fc;
    private Button btnDemo;
    private ImageView ivCodeStep1,ivCodeStep2,ivCodeStep3;
    private RelativeLayout rlFoldingCell;
    private LinearLayout llFoldingExplanation;

    private void init() {
        fc = findViewById(R.id.folding);
        rlFoldingCell = findViewById(R.id.RL_FoldingCell);
        llFoldingExplanation = findViewById(R.id.LL_FoldingExplain);
        ivCodeStep1 = findViewById(R.id.ivCodeFoldingAnimationStep1);
        ivCodeStep2 = findViewById(R.id.ivCodeFoldingAnimationStep2);
        ivCodeStep3 = findViewById(R.id.ivCodeFoldingAnimationStep3);

        btnDemo = findViewById(R.id.btnDemoFoldingAnimation);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_folding_cell);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();

        //region ImageView Clicks
        ivCodeStep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(AnimationFoldingCell.this, R.drawable.folding_anim_step1);
            }
        });
        ivCodeStep1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(AnimationFoldingCell.this,
                        getResources().getString(R.string.folding_step1));
                return true;
            }
        });

        ivCodeStep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(AnimationFoldingCell.this, R.drawable.folding_anim_step2);
            }
        });
        ivCodeStep2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(AnimationFoldingCell.this,
                        getResources().getString(R.string.folding_step2));
                return true;
            }
        });

        ivCodeStep3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(AnimationFoldingCell.this, R.drawable.folding_anim_step3);
            }
        });
        ivCodeStep3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(AnimationFoldingCell.this,
                        getResources().getString(R.string.folding_step3));
                return true;
            }
        });
        //endregion

        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rlFoldingCell.setVisibility(View.VISIBLE);
                llFoldingExplanation.setVisibility(View.GONE);
            }
        });

        fc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AnimationFoldingCell.this, "Toggled..", Toast.LENGTH_SHORT).show();
                fc.toggle(false);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (rlFoldingCell.getVisibility() == View.VISIBLE) {
            rlFoldingCell.setVisibility(View.GONE);
            llFoldingExplanation.setVisibility(View.VISIBLE);
        } else {
            finish();
        }
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
