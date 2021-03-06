package com.ali.learnandroid.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.ali.learnandroid.Utils.Alert_Dialog_Settings;

import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.ali.learnandroid.R;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomImage;
import com.nbsp.materialfilepicker.MaterialFilePicker;
import com.nbsp.materialfilepicker.ui.FilePickerActivity;
import com.snatik.storage.Storage;

import es.dmoral.toasty.Toasty;

public class PickerGalleryyFile extends AppCompatActivity {

    private final int PERMISSIONS_REQUEST_CODE = 1000;
    private final int FILE_PICKER_REQUEST_CODE = 200;
    Button btnDemo;
    ImageView ivStep1,ivStep2, ivStep3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_picker_gallery);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        btnDemo = findViewById(R.id.btnDemoFilePicker);
        ivStep1 = findViewById(R.id.ivCodeFilePickerStep1);
        ivStep2 = findViewById(R.id.ivCodeFilePickerStep2);
        ivStep3 = findViewById(R.id.ivCodeFilePickerStep3);

        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermissionsAndOpenFilePicker();
            }
        });

        ivStep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(PickerGalleryyFile.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);

                } else {
                    ZoomImage.show(PickerGalleryyFile.this, R.drawable.file_picker_step1,
                            getResources().getString(R.string.pick_file_step1));
                }

            }
        });

        ivStep1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(PickerGalleryyFile.this,
                        getResources().getString(R.string.pick_file_step1));
                return true;
            }
        });

        ivStep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(PickerGalleryyFile.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);

                } else {
                    ZoomImage.show(PickerGalleryyFile.this, R.drawable.file_picker_step2,
                            getResources().getString(R.string.pick_file_step2));
                }

            }
        });

        ivStep2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(PickerGalleryyFile.this,
                        getResources().getString(R.string.pick_file_step2));
                return true;
            }
        });

        ivStep3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(PickerGalleryyFile.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);

                } else {
                    ZoomImage.show(PickerGalleryyFile.this, R.drawable.file_picker_step3,
                            getResources().getString(R.string.pick_file_step3));
                }
            }
        });

        ivStep3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(PickerGalleryyFile.this,
                        getResources().getString(R.string.pick_file_step3));
                return true;
            }
        });

    }

    //call this method on Button Click to Open File Picker
    private void checkPermissionsAndOpenFilePicker() {
        String permission = Manifest.permission.READ_EXTERNAL_STORAGE;
        if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
            if (!ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
                Toast.makeText(this, "Allow external storage reading", Toast.LENGTH_SHORT).show();
            } else {
                ActivityCompat.requestPermissions(this, new String[]{permission}, PERMISSIONS_REQUEST_CODE);
            }
        } else {
            openFilePicker();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST_CODE: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openFilePicker();
                }  else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {

                    if (ActivityCompat.shouldShowRequestPermissionRationale(PickerGalleryyFile.this,
                            Manifest.permission.READ_EXTERNAL_STORAGE)) {

                        Toasty.warning(getApplicationContext(),
                                "Please allow Storage Permission to pick file.",
                                Toast.LENGTH_LONG).show();
                    } else {
                        Toasty.error(getApplicationContext(),
                                "You have to allow Storage Permission to pick file.\n" +
                                        "Goto Permissions and allow the Storage permission.",
                                Toast.LENGTH_LONG).show();
                        Intent intent = new Intent();
                        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        Uri uri = Uri.fromParts("package", getPackageName(), null);
                        intent.setData(uri);
                        startActivity(intent);
                    }
                }}
            case 100: {
                if (grantResults.length > 0 &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Toasty.success(this, "Permission allowed." +
                            "You can now view and share images. Thank you.", Toast.LENGTH_SHORT).show();

                } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {

                    if (ActivityCompat.shouldShowRequestPermissionRationale(PickerGalleryyFile.this,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                        Toasty.warning(getApplicationContext(),
                                "Please allow Storage Permission to view and share images.",
                                Toast.LENGTH_LONG).show();
                    } else {
                        Toasty.error(getApplicationContext(),
                                "You have to allow Storage Permission to view and share images.\n" +
                                        "Goto Permissions and allow the Storage permission.",
                                Toast.LENGTH_LONG).show();
                        Intent intent = new Intent();
                        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        Uri uri = Uri.fromParts("package", getPackageName(), null);
                        intent.setData(uri);
                        startActivity(intent);
                    }
                }
            }
        }
    }

    private void openFilePicker() {
        //below code will open File Picker
        new MaterialFilePicker()
                .withActivity(this)
                .withRequestCode(FILE_PICKER_REQUEST_CODE)
                .withHiddenFiles(true)
                .withTitle("Pick up text file")
                .start();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == FILE_PICKER_REQUEST_CODE && resultCode == RESULT_OK) {
            String path = data.getStringExtra(FilePickerActivity.RESULT_FILE_PATH);
            if (path != null) {
                try {
                    Storage storage = new Storage(getApplicationContext());
                    String content = storage.readTextFile(path); //data inside file
                    byte[] bytes = storage.readFile(path); // converted to bytes to convert file to base-64 string
                    String value = Base64.encodeToString(bytes, Base64.DEFAULT); //base-64 string
                    Toast.makeText(this, "Picked file: " + path, Toast.LENGTH_LONG).show();

                } catch (Exception e) {
                    Toast.makeText(this, "Exception: "+ e.getMessage(), Toast.LENGTH_SHORT).show();
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
