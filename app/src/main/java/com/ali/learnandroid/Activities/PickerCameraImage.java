package com.ali.learnandroid.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ali.learnandroid.R;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomImage;
import com.esafirm.imagepicker.features.ImagePicker;
import com.esafirm.imagepicker.model.Image;
import com.github.chrisbanes.photoview.PhotoView;

public class PickerCameraImage extends AppCompatActivity {

    Button btnDemo;
    private ImageView ivStep1, ivStep2,ivStep3,ivStep4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_picker_camera);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        btnDemo = findViewById(R.id.btnDemoImagePicker);
        ivStep1 = findViewById(R.id.ivCodeImagePickerStep1);
        ivStep2 = findViewById(R.id.ivCodeImagePickerStep2);
        ivStep3 = findViewById(R.id.ivCodeImagePickerStep3);
        ivStep4 = findViewById(R.id.ivCodeImagePickerStep4);


        ivStep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(PickerCameraImage.this, R.drawable.image_picker_step1);
            }
        });

        ivStep1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(PickerCameraImage.this,
                        getResources().getString(R.string.pick_image_step1));
                return true;
            }
        });

        ivStep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(PickerCameraImage.this, R.drawable.image_picker_step2);
            }
        });

        ivStep2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(PickerCameraImage.this,
                        getResources().getString(R.string.pick_image_step2));
                return true;
            }
        });

        ivStep3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(PickerCameraImage.this, R.drawable.image_picker_step3);
            }
        });

        ivStep3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(PickerCameraImage.this,
                        getResources().getString(R.string.pick_image_step3));
                return true;
            }
        });

        ivStep4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(PickerCameraImage.this, R.drawable.image_picker_step4);
            }
        });

        ivStep4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(PickerCameraImage.this,
                        getResources().getString(R.string.pick_image_step4));
                return true;
            }
        });


        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call this line to Open camera (may need permissions)
                ImagePicker.cameraOnly().imageDirectory("LearnAndroid Images").start(PickerCameraImage.this);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, final int resultCode, Intent data) {

        if (ImagePicker.shouldHandle(requestCode, resultCode, data)) {
            Image image = ImagePicker.getFirstImageOrNull(data); // selecting single image

            final AlertDialog.Builder mBuilder = new AlertDialog.Builder(PickerCameraImage.this);
            View mView = getLayoutInflater().inflate(R.layout.image_zoom_dialog, null);
            PhotoView photoView = mView.findViewById(R.id.imageView);
            photoView.setImageURI(Uri.parse(image.getPath()));
            mBuilder.setView(mView);
            mBuilder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            final AlertDialog mDialog = mBuilder.create();
            mDialog.show();
        }
        super.onActivityResult(requestCode, resultCode, data);
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
