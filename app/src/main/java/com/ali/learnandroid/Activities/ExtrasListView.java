package com.ali.learnandroid.Activities;

import android.Manifest;
import android.app.AlertDialog;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.ali.learnandroid.Adapters.MyAdapterListView;
import com.ali.learnandroid.Models.ListRowData;
import com.ali.learnandroid.R;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomImage;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;

public class ExtrasListView extends AppCompatActivity {

    ArrayList<ListRowData> dataArrayList = new ArrayList<>();
    MyAdapterListView adapter;
    ListView listView;

    ImageView ivCodeStep2,ivCodeStep3,ivCodeStep4,
            ivCodeStep5,ivCodeStep6;

    Button btnDemo;
    private void init() {

        ivCodeStep2 = findViewById(R.id.ivCodeListViewStep2);
        ivCodeStep3 = findViewById(R.id.ivCodeListViewStep3);
        ivCodeStep4 = findViewById(R.id.ivCodeListViewStep4);
        ivCodeStep5 = findViewById(R.id.ivCodeListViewStep5);
        ivCodeStep6 = findViewById(R.id.ivCodeListViewStep6);

        btnDemo = findViewById(R.id.btnDemoListView);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extras_list_view_alert_dialog);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //region inserting data into ArrayList...
        dataArrayList.add(new ListRowData("url_of_image", "Ali", "23", "Android Dev"));
        dataArrayList.add(new ListRowData("url_of_image", "Ammar", "24", "IOS Dev"));
        dataArrayList.add(new ListRowData("url_of_image", "Ab Hadi", "23", "Web Dev"));
        dataArrayList.add(new ListRowData("url_of_image", "Fazal", "23", "Java Dev"));
        dataArrayList.add(new ListRowData("url_of_image", "Zeeshan", "24", "IOS Dev"));
        dataArrayList.add(new ListRowData("url_of_image", "Junaid", "22", "Android Dev"));
        dataArrayList.add(new ListRowData("url_of_image", "Sayab", "23", "Web Dev"));
        //endregion

        init();

        ivCodeStep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(ExtrasListView.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(ExtrasListView.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
                } else {
                    ZoomImage.show(ExtrasListView.this, R.drawable.list_step1,
                            getResources().getString(R.string.list_view_step2));
                }

            }
        });
        ivCodeStep2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ExtrasListView.this,
                        getResources().getString(R.string.list_view_step2));
                return true;
            }
        });

        ivCodeStep3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(ExtrasListView.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(ExtrasListView.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
                } else {
                    ZoomImage.show(ExtrasListView.this, R.drawable.recycler_view_step3,
                            getResources().getString(R.string.recycler_view_step3));
                }

            }
        });
        ivCodeStep3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ExtrasListView.this,
                        getResources().getString(R.string.recycler_view_step3));
                return true;
            }
        });

        ivCodeStep4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(ExtrasListView.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(ExtrasListView.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
                } else {
                    ZoomImage.show(ExtrasListView.this, R.drawable.list_step3,
                            getResources().getString(R.string.list_view_step4));
                }

            }
        });
        ivCodeStep4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ExtrasListView.this,
                        getResources().getString(R.string.list_view_step4));
                return true;
            }
        });

        ivCodeStep5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(ExtrasListView.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(ExtrasListView.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
                } else {
                    ZoomImage.show(ExtrasListView.this, R.drawable.list_step4,
                            getResources().getString(R.string.list_view_step5));
                }

            }
        });
        ivCodeStep5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ExtrasListView.this,
                        getResources().getString(R.string.list_view_step5));
                return true;
            }
        });

        ivCodeStep6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(ExtrasListView.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(ExtrasListView.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
                } else {
                    ZoomImage.show(ExtrasListView.this, R.drawable.list_step5,
                            getResources().getString(R.string.list_view_step6));
                }
            }
        });
        ivCodeStep6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ExtrasListView.this,
                        getResources().getString(R.string.list_view_step6));
                return true;
            }
        });

        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

    }

    public void showDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("LiView");
        View mView = getLayoutInflater().inflate(R.layout.activity_extras_list_view, null);
        listView = mView.findViewById(R.id.listView);
        adapter = new MyAdapterListView(ExtrasListView.this, dataArrayList);
        listView.setAdapter(adapter);
        dialog.setView(mView);
        dialog.setPositiveButton("Close", null);

        dialog.show();
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

                if (ActivityCompat.shouldShowRequestPermissionRationale(ExtrasListView.this,
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
