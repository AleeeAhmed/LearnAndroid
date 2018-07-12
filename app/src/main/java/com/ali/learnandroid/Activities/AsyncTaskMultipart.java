package com.ali.learnandroid.Activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ali.learnandroid.R;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomImage;

import net.gotev.uploadservice.MultipartUploadRequest;
import net.gotev.uploadservice.UploadNotificationConfig;

public class AsyncTaskMultipart extends AppCompatActivity {

    Animation animMove;
    RelativeLayout rlMultipart;
    ImageView ivCodeStep1, ivCodeStep2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_multipart);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ivCodeStep1 = findViewById(R.id.ivCodeAsyncTaskMultipartStep1);
        ivCodeStep2 = findViewById(R.id.ivCodeAsyncTaskMultipartStep2);
        rlMultipart = findViewById(R.id.RL_AsyncTaskMultipart);

        animMove = AnimationUtils.loadAnimation(AsyncTaskMultipart.this, R.anim.move);
        rlMultipart.startAnimation(animMove);

        ivCodeStep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(AsyncTaskMultipart.this, R.drawable.background_multipart_step1);
            }
        });

        ivCodeStep1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(AsyncTaskMultipart.this,
                        getResources().getString(R.string.background_multipart_step1));
                return true;
            }
        });

        ivCodeStep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(AsyncTaskMultipart.this, R.drawable.background_multipart_step2);
            }
        });

        ivCodeStep2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(AsyncTaskMultipart.this,
                        getResources().getString(R.string.background_multipart_step2));
                return true;
            }
        });
    }

//    public void uploadMultipart(final Context context) {
//        try {
//            String uploadId =
//                    new MultipartUploadRequest(context, "your URL here")
//
//                            .addFileToUpload("data.getData() here", "your param name")
//                            .addArrayParameter("parameter name", "item1","item2")
//                            .addParameter("parameter name", "param value")
//
//                            .setNotificationConfig(new UploadNotificationConfig())
//                            .setMaxRetries(2)
//                            .startUpload();
//
//        } catch (Exception exc) {
//            Toast.makeText(context, "Exception: "+exc.getMessage(), Toast.LENGTH_SHORT).show();
//        }
//    }


    @Override
    protected void onResume() {
        rlMultipart.startAnimation(animMove);
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
