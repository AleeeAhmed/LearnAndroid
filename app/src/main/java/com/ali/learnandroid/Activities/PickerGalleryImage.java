package com.ali.learnandroid.Activities;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import com.ali.learnandroid.Utils.Alert_Dialog_Settings;

import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.Toast;

import com.ali.learnandroid.R;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomImage;
import com.esafirm.imagepicker.features.ImagePicker;
import com.esafirm.imagepicker.model.Image;
import com.github.chrisbanes.photoview.PhotoView;

import java.util.List;

import es.dmoral.toasty.Toasty;


public class PickerGalleryImage extends AppCompatActivity {

    Button btnDemo;
    private ImageView ivStep1, ivStep2,ivStep3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_picker_gallery);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        btnDemo = findViewById(R.id.btnDemoImagePickerGallery);
        ivStep1 = findViewById(R.id.ivCodeImagePickerGalleryStep1);
        ivStep2 = findViewById(R.id.ivCodeImagePickerGalleryStep2);
        ivStep3 = findViewById(R.id.ivCodeImagePickerGalleryStep3);

        ivStep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(PickerGalleryImage.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);

                } else {
                    ZoomImage.show(PickerGalleryImage.this, R.drawable.image_picker_step1,
                            getResources().getString(R.string.pick_gallery_image_step1));
                }

            }
        });

        ivStep1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(PickerGalleryImage.this,
                        getResources().getString(R.string.pick_gallery_image_step1));
                return true;
            }
        });

        ivStep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(PickerGalleryImage.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);

                } else {
                    ZoomImage.show(PickerGalleryImage.this, R.drawable.image_picker_step2,
                            getResources().getString(R.string.pick_gallery_image_step2));
                }

            }
        });

        ivStep2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(PickerGalleryImage.this,
                        getResources().getString(R.string.pick_gallery_image_step2));
                return true;
            }
        });

        ivStep3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(PickerGalleryImage.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);

                } else {
                    ZoomImage.show(PickerGalleryImage.this, R.drawable.gallery_image_picker_step1,
                            getResources().getString(R.string.pick_gallery_image_step3));
                }
            }
        });

        ivStep3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(PickerGalleryImage.this,
                        getResources().getString(R.string.pick_gallery_image_step3));
                return true;
            }
        });

        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenGallery();
            }
        });

    }

    private void OpenGallery() {
        ImagePicker.create(this)
                .folderMode(true)
                .toolbarFolderTitle("Gallery")
                .toolbarImageTitle("Tap to select")
                .toolbarArrowColor(Color.WHITE)
                .multi() // or  .single()
                .limit(10) // max images can be selected
                .showCamera(true)
                .imageDirectory("LearnAndroid Images") // directory name for captured image
                .start();
    }

    @Override
    protected void onActivityResult(int requestCode, final int resultCode, Intent data) {
        if (ImagePicker.shouldHandle(requestCode, resultCode, data)) {
            List<Image> images = ImagePicker.getImages(data);

            ScrollView scrollView = new ScrollView(this);
            scrollView.setLayoutParams(new LayoutParams(
                    LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT
            ));
            LinearLayout linearLayout= new LinearLayout(this);
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            linearLayout.setLayoutParams(new LayoutParams(
                    LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));


            final AlertDialog.Builder mBuilder = new AlertDialog.Builder(PickerGalleryImage.this);

            for (Image image : images) {
                PhotoView imageView = new PhotoView(this);
                imageView.setImageURI(Uri.parse(image.getPath()));
                imageView.setLayoutParams(new LayoutParams(
                        LayoutParams.MATCH_PARENT, 700));
                imageView.setPadding(0,11,0,11);
                linearLayout.addView(imageView);
            }
            scrollView.addView(linearLayout);
            mBuilder.setView(scrollView);
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
    public void onRequestPermissionsResult(int requestCode, @NonNull
            String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == 100) {
            if (grantResults.length > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                Toasty.success(this, "Permission allowed." +
                        "You can now view and share images. Thank you.", Toast.LENGTH_SHORT).show();

            } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {

                if (ActivityCompat.shouldShowRequestPermissionRationale(PickerGalleryImage.this,
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


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
