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
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.ali.learnandroid.Adapters.MyAdapterExtrasRecyclerView;
import com.ali.learnandroid.Models.RecyclerRowData;
import com.ali.learnandroid.R;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomImage;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;

public class ExtrasRecyclerView extends AppCompatActivity implements MyAdapterExtrasRecyclerView.ItemClickListener {

    ArrayList<RecyclerRowData> dataArrayList = new ArrayList<>();
    MyAdapterExtrasRecyclerView adapter;
    RecyclerView recyclerView;

    ImageView ivCodeStep1,ivCodeStep2,ivCodeStep3,ivCodeStep4,
            ivCodeStep5,ivCodeStep6,ivCodeStep7,ivCodeStep8;

    Button btnDemo;

    private void init() {
        ivCodeStep1 = findViewById(R.id.ivCodeRecyclerViewStep1);
        ivCodeStep3 = findViewById(R.id.ivCodeRecyclerViewStep3);
        ivCodeStep4 = findViewById(R.id.ivCodeRecyclerViewStep4);
        ivCodeStep2 = findViewById(R.id.ivCodeRecyclerViewStep2);
        ivCodeStep5 = findViewById(R.id.ivCodeRecyclerViewStep5);
        ivCodeStep6 = findViewById(R.id.ivCodeRecyclerViewStep6);
        ivCodeStep7 = findViewById(R.id.ivCodeRecyclerViewStep7);
        ivCodeStep8 = findViewById(R.id.ivCodeRecyclerViewStep8);

        btnDemo = findViewById(R.id.btnDemoRecyclerView);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extras_recycler_view);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //region inserting data into ArrayList...
        dataArrayList.add(new RecyclerRowData("url_of_image", "Ali", "23", "Android Dev"));
        dataArrayList.add(new RecyclerRowData("url_of_image", "Ammar", "24", "IOS Dev"));
        dataArrayList.add(new RecyclerRowData("url_of_image", "Ab Hadi", "23", "Web Dev"));
        dataArrayList.add(new RecyclerRowData("url_of_image", "Fazal", "23", "Java Dev"));
        dataArrayList.add(new RecyclerRowData("url_of_image", "Zeeshan", "24", "IOS Dev"));
        dataArrayList.add(new RecyclerRowData("url_of_image", "Junaid", "22", "Android Dev"));
        dataArrayList.add(new RecyclerRowData("url_of_image", "Sayab", "23", "Web Dev"));
        //endregion

        init();

        ivCodeStep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(ExtrasRecyclerView.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(ExtrasRecyclerView.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
                } else {
                    ZoomImage.show(ExtrasRecyclerView.this, R.drawable.recycler_view_step1);
                }
            }
        });
        ivCodeStep1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ExtrasRecyclerView.this,
                        getResources().getString(R.string.recycler_view_step1));
                return true;
            }
        });

        ivCodeStep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(ExtrasRecyclerView.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(ExtrasRecyclerView.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
                } else {
                    ZoomImage.show(ExtrasRecyclerView.this, R.drawable.recycler_view_step2);
                }

            }
        });
        ivCodeStep2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ExtrasRecyclerView.this,
                        getResources().getString(R.string.recycler_view_step2));
                return true;
            }
        });

        ivCodeStep3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(ExtrasRecyclerView.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(ExtrasRecyclerView.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
                } else {
                    ZoomImage.show(ExtrasRecyclerView.this, R.drawable.recycler_view_step3);
                }

            }
        });
        ivCodeStep3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ExtrasRecyclerView.this,
                        getResources().getString(R.string.recycler_view_step3));
                return true;
            }
        });

        ivCodeStep4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(ExtrasRecyclerView.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(ExtrasRecyclerView.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
                } else {
                    ZoomImage.show(ExtrasRecyclerView.this, R.drawable.recycler_view_step4);
                }

            }
        });
        ivCodeStep4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ExtrasRecyclerView.this,
                        getResources().getString(R.string.recycler_view_step4));
                return true;
            }
        });

        ivCodeStep5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(ExtrasRecyclerView.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(ExtrasRecyclerView.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
                } else {
                    ZoomImage.show(ExtrasRecyclerView.this, R.drawable.recycler_view_step5);
                }

            }
        });
        ivCodeStep5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ExtrasRecyclerView.this,
                        getResources().getString(R.string.recycler_view_step5));
                return true;
            }
        });

        ivCodeStep6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(ExtrasRecyclerView.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(ExtrasRecyclerView.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
                } else {
                    ZoomImage.show(ExtrasRecyclerView.this, R.drawable.recycler_view_step6);
                }

            }
        });
        ivCodeStep6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ExtrasRecyclerView.this,
                        getResources().getString(R.string.recycler_view_step6));
                return true;
            }
        });

        ivCodeStep7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(ExtrasRecyclerView.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(ExtrasRecyclerView.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
                } else {
                    ZoomImage.show(ExtrasRecyclerView.this, R.drawable.recycler_view_step7);
                }

            }
        });
        ivCodeStep7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ExtrasRecyclerView.this,
                        getResources().getString(R.string.recycler_view_step5));
                return true;
            }
        });

        ivCodeStep8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(ExtrasRecyclerView.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(ExtrasRecyclerView.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
                } else {
                    ZoomImage.show(ExtrasRecyclerView.this, R.drawable.recycler_view_step8);
                }

            }
        });
        ivCodeStep8.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ExtrasRecyclerView.this,
                        getResources().getString(R.string.recycler_view_step6));
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("RecyclerView");
        View mView = getLayoutInflater().inflate(R.layout.activity_extras_recycler_view_alert_dialog, null);
        recyclerView = mView.findViewById(R.id.recycler_view);
        adapter = new MyAdapterExtrasRecyclerView(dataArrayList, this);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(ExtrasRecyclerView.this);//or.. (ExtrasRecyclerView.this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.setLayoutManager(layoutManager1);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        dialog.setView(mView);

        dialog.setPositiveButton("Close", null);

        dialog.show();
    }

    @Override
    public void itemClicked(View view, int position) {
        Toast.makeText(this, "you clicked "+ dataArrayList.get(position).getName(), Toast.LENGTH_SHORT).show();
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

                if (ActivityCompat.shouldShowRequestPermissionRationale(ExtrasRecyclerView.this,
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
