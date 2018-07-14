package com.ali.learnandroid.Activities;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.ali.learnandroid.R;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomGIF;
import com.ali.learnandroid.Utils.ZoomImage;

import es.dmoral.toasty.Toasty;

public class ToastMessageLibrary extends AppCompatActivity {


    ImageView ivCodeStep1,ivCodeStep2,ivCodeStep3,ivCodeStep4;
    Button btnSuccessToast,btnErrorToast,btnInfoToast;

    private void init() {
        ivCodeStep1 = findViewById(R.id.ivCodeToastLibraryStep1);
        ivCodeStep2 = findViewById(R.id.ivCodeToastLibraryStep2);
        ivCodeStep3 = findViewById(R.id.ivCodeToastLibraryStep3);
        ivCodeStep4 = findViewById(R.id.ivCodeToastLibraryStep4);

        btnSuccessToast = findViewById(R.id.btnDemoToastLibrary1);
        btnErrorToast = findViewById(R.id.btnDemoToastLibrary2);
        btnInfoToast = findViewById(R.id.btnDemoToastLibrary3);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_message_library);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        init();


        ivCodeStep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(ToastMessageLibrary.this, R.drawable.toast_lib_step1);
            }
        });
        ivCodeStep1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ToastMessageLibrary.this,
                        getResources().getString(R.string.toast_library_step1));
                return true;
            }
        });

        ivCodeStep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(ToastMessageLibrary.this, R.drawable.toast_lib_step2);
            }
        });
        ivCodeStep2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ToastMessageLibrary.this,
                        getResources().getString(R.string.toast_library_step2));
                return true;
            }
        });

        ivCodeStep3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(ToastMessageLibrary.this, R.drawable.toast_lib_step3);
            }
        });
        ivCodeStep3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ToastMessageLibrary.this,
                        getResources().getString(R.string.toast_library_step3));
                return true;
            }
        });
        ivCodeStep4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(ToastMessageLibrary.this, R.drawable.toast_lib_step4);
            }
        });
        ivCodeStep4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ToastMessageLibrary.this,
                        getResources().getString(R.string.toast_library_step4));
                return true;
            }
        });


        btnSuccessToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toasty.success(getApplicationContext(),
                        "Download Completed Successfully !!", Toast.LENGTH_SHORT, true).show();
            }
        });


        btnErrorToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toasty.error(getApplicationContext(),
                        "Sorry ! An Error Occurred !! ", Toast.LENGTH_SHORT, true).show();
            }
        });


        btnInfoToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toasty.info(getApplicationContext(),
                        "Here is some info for you.", Toast.LENGTH_SHORT, true).show();
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
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
