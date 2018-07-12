package com.ali.learnandroid.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ali.learnandroid.R;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomImage;

public class AsyncTaskGET extends AppCompatActivity {
    Animation animFadeIn;
    RelativeLayout rlAsyncPost;
    ImageView ivStep1, ivStep2, ivStep3, ivStep4, ivStep5, ivStep6;
    Button btnCopyCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_get);


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        init();

        rlAsyncPost.startAnimation(animFadeIn);

        ivStep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(AsyncTaskGET.this, R.drawable.background_get_step1);
            }
        });

        ivStep1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(AsyncTaskGET.this,
                        R.string.copy_code, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        ivStep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(AsyncTaskGET.this, R.drawable.background_get_step2);
            }
        });

        ivStep2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(AsyncTaskGET.this,
                        R.string.copy_code, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        ivStep3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(AsyncTaskGET.this, R.drawable.background_get_step3);
            }
        });

        ivStep3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(AsyncTaskGET.this,
                        R.string.copy_code, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        ivStep4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(AsyncTaskGET.this, R.drawable.background_post_step4);
            }
        });

        ivStep4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(AsyncTaskGET.this,
                        R.string.copy_code, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        ivStep5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(AsyncTaskGET.this, R.drawable.background_get_step5);
            }
        });

        ivStep5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(AsyncTaskGET.this,
                        R.string.copy_code, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        ivStep6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(AsyncTaskGET.this, R.drawable.background_post_step6);
            }
        });

        ivStep6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(AsyncTaskGET.this, R.string.copy_code, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        btnCopyCode .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CopyToClipBoard.Copy(AsyncTaskGET.this,
                        getResources().getString(R.string.background_get_step1));
            }
        });

    }


    private void init() {
        animFadeIn = AnimationUtils.loadAnimation(AsyncTaskGET.this, R.anim.fade_in);
        rlAsyncPost = findViewById(R.id.RL_AsyncTaskGET);

        ivStep1 = findViewById(R.id.ivCodeAsyncTaskGetStep1);
        ivStep2 = findViewById(R.id.ivCodeAsyncTaskGetStep2);
        ivStep3 = findViewById(R.id.ivCodeAsyncTaskGetStep3);
        ivStep4 = findViewById(R.id.ivCodeAsyncTaskGetStep4);
        ivStep5 = findViewById(R.id.ivCodeAsyncTaskGetStep5);
        ivStep6 = findViewById(R.id.ivCodeAsyncTaskGetStep6);

        btnCopyCode = findViewById(R.id.btnCopyCodeAsyncTaskGet);
    }

    @Override
    protected void onResume() {
        rlAsyncPost.startAnimation(animFadeIn);
        super.onResume();
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
