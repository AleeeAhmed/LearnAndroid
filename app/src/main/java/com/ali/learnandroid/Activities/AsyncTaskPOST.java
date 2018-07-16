package com.ali.learnandroid.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.ali.learnandroid.Utils.Alert_Dialog_Settings;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
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
import com.ali.learnandroid.Utils.BackgroundProcessPOST;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomImage;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import es.dmoral.toasty.Toasty;

public class AsyncTaskPOST extends AppCompatActivity {

    Animation animSlideDown;
    RelativeLayout rlAsyncPost;
    ImageView ivStep1, ivStep2, ivStep3, ivStep4, ivStep5, ivStep6;
    Button btnCopyCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_post);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        init();

        rlAsyncPost.startAnimation(animSlideDown);

        ivStep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(AsyncTaskPOST.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(AsyncTaskPOST.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
                } else {
                    ZoomImage.show(AsyncTaskPOST.this, R.drawable.background_post_step1);
                }
            }
        });

        ivStep1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(AsyncTaskPOST.this,
                        R.string.copy_code, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        ivStep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(AsyncTaskPOST.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(AsyncTaskPOST.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
                } else {
                    ZoomImage.show(AsyncTaskPOST.this, R.drawable.background_post_step2);
                }
            }
        });

        ivStep2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(AsyncTaskPOST.this,
                        R.string.copy_code, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        ivStep3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(AsyncTaskPOST.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(AsyncTaskPOST.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
                } else {
                    ZoomImage.show(AsyncTaskPOST.this, R.drawable.background_post_step3);
                }

            }
        });

        ivStep3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(AsyncTaskPOST.this,
                        R.string.copy_code, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        ivStep4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(AsyncTaskPOST.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(AsyncTaskPOST.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
                } else {
                    ZoomImage.show(AsyncTaskPOST.this, R.drawable.background_post_step4);
                }

            }
        });

        ivStep4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(AsyncTaskPOST.this,
                        R.string.copy_code, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        ivStep5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(AsyncTaskPOST.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(AsyncTaskPOST.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
                } else {
                    ZoomImage.show(AsyncTaskPOST.this, R.drawable.background_post_step5);
                }
            }
        });

        ivStep5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(AsyncTaskPOST.this,
                        R.string.copy_code, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        ivStep6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(AsyncTaskPOST.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(AsyncTaskPOST.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
                } else {
                    ZoomImage.show(AsyncTaskPOST.this, R.drawable.background_post_step6);
                }
            }
        });

        ivStep6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(AsyncTaskPOST.this, R.string.copy_code, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        btnCopyCode .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CopyToClipBoard.Copy(AsyncTaskPOST.this,
                        getResources().getString(R.string.background_post_step1));
            }
        });
    }

    private void init() {
        animSlideDown = AnimationUtils.loadAnimation(AsyncTaskPOST.this, R.anim.silde_down);
        rlAsyncPost = findViewById(R.id.RL_AsyncTasksPOST);

        ivStep1 = findViewById(R.id.ivCodeAsyncTaskPostStep1);
        ivStep2 = findViewById(R.id.ivCodeAsyncTaskPostStep2);
        ivStep3 = findViewById(R.id.ivCodeAsyncTaskPostStep3);
        ivStep4 = findViewById(R.id.ivCodeAsyncTaskPostStep4);
        ivStep5 = findViewById(R.id.ivCodeAsyncTaskPostStep5);
        ivStep6 = findViewById(R.id.ivCodeAsyncTaskPostStep6);

        btnCopyCode = findViewById(R.id.btnCopyCodeAsyncTaskPost);
    }

    @Override
    protected void onResume() {
        rlAsyncPost.startAnimation(animSlideDown);
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


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull
            String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == 100) {
            if (grantResults.length > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                Toasty.success(this, "Permission allowed." +
                        "You can now view and share images. Thank you.", Toast.LENGTH_SHORT).show();

            } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {

                if (ActivityCompat.shouldShowRequestPermissionRationale(AsyncTaskPOST.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                    Toasty.warning(getApplicationContext(),
                            "Please allow Storage Permission to view and share images.",
                            Toast.LENGTH_LONG).show();
                } else {
                    String message = "Storage Permission required."
                            +"Goto Permissions and allow the Storage permission.";
                    Alert_Dialog_Settings.showDialog(this,"Permission", message);
                }
            }
        }

    }

}
