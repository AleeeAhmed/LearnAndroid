package com.ali.learnandroid.Activities;

import android.Manifest;
import android.content.pm.PackageManager;
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
import com.ali.learnandroid.Utils.Alert_Dialog_Settings;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomImage;

import es.dmoral.toasty.Toasty;

public class AsyncTaskRetrofitLib extends AppCompatActivity {

    Animation animSlideDown;
    RelativeLayout rlAsyncRetrofit;
    ImageView ivStep1, ivStep2, ivStep3, ivStep4, ivStep5, ivStep6, ivStep7, ivStep8;

    private void init() {
        animSlideDown = AnimationUtils.loadAnimation(AsyncTaskRetrofitLib.this, R.anim.silde_down);
        rlAsyncRetrofit = findViewById(R.id.RL_AsyncTasksRetrofit);

        ivStep1 = findViewById(R.id.ivCodeAsyncTaskRetrofitStep1);
        ivStep2 = findViewById(R.id.ivCodeAsyncTaskRetrofitStep2);
        ivStep3 = findViewById(R.id.ivCodeAsyncTaskRetrofitStep3);
        ivStep4 = findViewById(R.id.ivCodeAsyncTaskRetrofitStep4);
        ivStep5 = findViewById(R.id.ivCodeAsyncTaskRetrofitStep5);
        ivStep6 = findViewById(R.id.ivCodeAsyncTaskRetrofitStep6);
        ivStep7 = findViewById(R.id.ivCodeAsyncTaskRetrofitStep7);
        ivStep8 = findViewById(R.id.ivCodeAsyncTaskRetrofitStep8);

    }

    @Override
    protected void onResume() {
        rlAsyncRetrofit.startAnimation(animSlideDown);
        super.onResume();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_retrofit_lib);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        init();

        rlAsyncRetrofit.startAnimation(animSlideDown);

        ivStep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(AsyncTaskRetrofitLib.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(AsyncTaskRetrofitLib.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
                } else {
                    ZoomImage.show(AsyncTaskRetrofitLib.this, R.drawable.retrofit_step1,
                            getResources().getString(R.string.retrofit_step1));
                }
            }
        });

        ivStep1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(AsyncTaskRetrofitLib.this,
                        getResources().getString(R.string.retrofit_step1));
                return true;
            }
        });

        ivStep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(AsyncTaskRetrofitLib.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(AsyncTaskRetrofitLib.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
                } else {
                    ZoomImage.show(AsyncTaskRetrofitLib.this, R.drawable.retrofit_step2,
                            getResources().getString(R.string.retrofit_step2));
                }
            }
        });

        ivStep2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(AsyncTaskRetrofitLib.this,
                        getResources().getString(R.string.retrofit_step2));
                return true;
            }
        });

        ivStep3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(AsyncTaskRetrofitLib.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(AsyncTaskRetrofitLib.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
                } else {
                    ZoomImage.show(AsyncTaskRetrofitLib.this, R.drawable.retrofit_step3,
                            getResources().getString(R.string.retrofit_step3));
                }

            }
        });

        ivStep3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(AsyncTaskRetrofitLib.this,
                        getResources().getString(R.string.retrofit_step3));
                return true;
            }
        });

        ivStep4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(AsyncTaskRetrofitLib.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(AsyncTaskRetrofitLib.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
                } else {
                    ZoomImage.show(AsyncTaskRetrofitLib.this, R.drawable.retrofit_step4,
                            getResources().getString(R.string.retrofit_step4));
                }

            }
        });

        ivStep4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(AsyncTaskRetrofitLib.this,
                        getResources().getString(R.string.retrofit_step4));
                return true;
            }
        });

        ivStep5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(AsyncTaskRetrofitLib.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(AsyncTaskRetrofitLib.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
                } else {
                    ZoomImage.show(AsyncTaskRetrofitLib.this, R.drawable.retrofit_step5,
                            getResources().getString(R.string.retrofit_step5));
                }
            }
        });

        ivStep5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(AsyncTaskRetrofitLib.this,
                        getResources().getString(R.string.retrofit_step5));
                return true;
            }
        });

        ivStep6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(AsyncTaskRetrofitLib.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(AsyncTaskRetrofitLib.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
                } else {
                    ZoomImage.show(AsyncTaskRetrofitLib.this, R.drawable.retrofit_step6,
                            getResources().getString(R.string.retrofit_step6));
                }
            }
        });

        ivStep6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(AsyncTaskRetrofitLib.this,
                        getResources().getString(R.string.retrofit_step6));
                return true;
            }
        });


        ivStep7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(AsyncTaskRetrofitLib.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(AsyncTaskRetrofitLib.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
                } else {
                    ZoomImage.show(AsyncTaskRetrofitLib.this, R.drawable.retrofit_step7,
                            getResources().getString(R.string.retrofit_step7));
                }
            }
        });

        ivStep7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(AsyncTaskRetrofitLib.this,
                        getResources().getString(R.string.retrofit_step7));
                return true;
            }
        });

        ivStep8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(AsyncTaskRetrofitLib.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(AsyncTaskRetrofitLib.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
                } else {
                    ZoomImage.show(AsyncTaskRetrofitLib.this, R.drawable.retrofit_step8,
                            getResources().getString(R.string.retrofit_step8));
                }
            }
        });

        ivStep8.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(AsyncTaskRetrofitLib.this,
                        getResources().getString(R.string.retrofit_step8));
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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull
            String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == 100) {
            if (grantResults.length > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                Toasty.success(this, "Permission allowed." +
                        "You can now view and share images. Thank you.", Toast.LENGTH_SHORT).show();

            } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {

                if (ActivityCompat.shouldShowRequestPermissionRationale(AsyncTaskRetrofitLib.this,
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
