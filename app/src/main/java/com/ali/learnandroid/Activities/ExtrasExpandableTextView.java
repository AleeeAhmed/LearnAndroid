package com.ali.learnandroid.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
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
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ali.learnandroid.R;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomImage;
import com.ramotion.foldingcell.FoldingCell;

import at.blogc.android.views.ExpandableTextView;
import es.dmoral.toasty.Toasty;
import tyrantgit.explosionfield.ExplosionField;

public class ExtrasExpandableTextView extends AppCompatActivity {

    private Button buttonToggle, btnDemo;
    private ImageView ivCodeStep1,ivCodeStep2,ivCodeStep3;
    private ExpandableTextView expandableTextView;
    private RelativeLayout rlExpandableTextView, rlExpandableExplanation;



    private void init() {
        expandableTextView =  findViewById(R.id.expandableTextView);
        buttonToggle =  findViewById(R.id.button_toggle);
        rlExpandableTextView = findViewById(R.id.RL_ExpandableTextView);
        rlExpandableExplanation = findViewById(R.id.RL_ExpandableExplain);
        ivCodeStep1 = findViewById(R.id.ivCodeExpandableTextViewStep1);
        ivCodeStep2 = findViewById(R.id.ivCodeExpandableTextViewStep2);
        ivCodeStep3 = findViewById(R.id.ivCodeExpandableTextViewStep3);

        btnDemo = findViewById(R.id.btnDemoExpandableTextView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extras_expandable_text_view);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();

        //region Button Toggle On Click
        buttonToggle.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(final View v)
            {
                AnimationDrawable imgC = (AnimationDrawable) getResources().getDrawable( R.drawable.collapse );
                AnimationDrawable imgE = (AnimationDrawable) getResources().getDrawable( R.drawable.expand );
                imgC.setBounds( 0, 0, 100, 100 );
                imgE.setBounds( 0, 0, 100, 100 );
                buttonToggle.setCompoundDrawables(
                        null,
                        null,
                        expandableTextView.isExpanded() ?
                                imgC :
                                imgE,
                        null);
                if (expandableTextView.isExpanded()) {
                    imgC.start();
                } else {
                    imgE.start();
                }
                expandableTextView.toggle();
            }
        });
        //endregion

        //region ImageView Clicks
        ivCodeStep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(ExtrasExpandableTextView.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(ExtrasExpandableTextView.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
                } else {
                    ZoomImage.show(ExtrasExpandableTextView.this, R.drawable.expandable_text_step1);
                }
            }
        });
        ivCodeStep1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ExtrasExpandableTextView.this,
                        getResources().getString(R.string.expandable_textview_step1));
                return true;
            }
        });

        ivCodeStep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(ExtrasExpandableTextView.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(ExtrasExpandableTextView.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
                } else {
                    ZoomImage.show(ExtrasExpandableTextView.this, R.drawable.expandable_text_step2);
                }

            }
        });
        ivCodeStep2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ExtrasExpandableTextView.this,
                        getResources().getString(R.string.expandable_textview_step2));
                return true;
            }
        });

        ivCodeStep3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(ExtrasExpandableTextView.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(ExtrasExpandableTextView.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
                } else {
                    ZoomImage.show(ExtrasExpandableTextView.this, R.drawable.expandable_text_step3);
                }

            }
        });
        ivCodeStep3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ExtrasExpandableTextView.this,
                        getResources().getString(R.string.expandable_textview_step3));
                return true;
            }
        });
        //endregion

        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rlExpandableExplanation.setVisibility(View.GONE);
                rlExpandableTextView.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (rlExpandableTextView.getVisibility() == View.VISIBLE) {
            rlExpandableTextView.setVisibility(View.GONE);
            rlExpandableExplanation.setVisibility(View.VISIBLE);
        } else {
            finish();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
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

                if (ActivityCompat.shouldShowRequestPermissionRationale(ExtrasExpandableTextView.this,
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
