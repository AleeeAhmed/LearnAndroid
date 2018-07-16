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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.ali.learnandroid.R;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomGIF;
import com.ali.learnandroid.Utils.ZoomImage;

import es.dmoral.toasty.Toasty;


public class ToolbarCollapsing extends AppCompatActivity {

    ImageView ivCodeStep1,ivCodeStep2,ivCodeStep3,ivCodeStep4,
            ivCodeStep5,ivCodeStep6,ivCodeStep7,ivCodeStep8, ivCodeStep9;

    Button btnDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_collapsing);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        init();

        ivCodeStep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ToolbarCollapsing.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);

                } else {
                    ZoomImage.show(ToolbarCollapsing.this, R.drawable.collapsing_toolbar_step1);
                }

            }
        });
        ivCodeStep1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ToolbarCollapsing.this,
                        getResources().getString(R.string.collapsing_toolbar_step1));
                return true;
            }
        });

        ivCodeStep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ToolbarCollapsing.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);

                } else {
                    ZoomImage.show(ToolbarCollapsing.this, R.drawable.collapsing_toolbar_step2);
                }

            }
        });
        ivCodeStep2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ToolbarCollapsing.this,
                        getResources().getString(R.string.collapsing_toolbar_step2));
                return true;
            }
        });

        ivCodeStep3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ToolbarCollapsing.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);

                } else {
                    ZoomImage.show(ToolbarCollapsing.this, R.drawable.collapsing_toolbar_step3);
                }
            }
        });
        ivCodeStep3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ToolbarCollapsing.this,
                        getResources().getString(R.string.collapsing_toolbar_step3));
                return true;
            }
        });

        ivCodeStep4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ToolbarCollapsing.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);

                } else {
                    ZoomImage.show(ToolbarCollapsing.this, R.drawable.collapsing_toolbar_step4);
                }

            }
        });
        ivCodeStep4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ToolbarCollapsing.this,
                        getResources().getString(R.string.collapsing_toolbar_step4));
                return true;
            }
        });

        ivCodeStep5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ToolbarCollapsing.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);

                } else {
                    ZoomImage.show(ToolbarCollapsing.this, R.drawable.collapsing_toolbar_step5);
                }
            }
        });
        ivCodeStep5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ToolbarCollapsing.this,
                        getResources().getString(R.string.collapsing_toolbar_step5));
                return true;
            }
        });

        ivCodeStep6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ToolbarCollapsing.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);

                } else {
                    ZoomImage.show(ToolbarCollapsing.this, R.drawable.collapsing_toolbar_step6);
                }

            }
        });
        ivCodeStep6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ToolbarCollapsing.this,
                        getResources().getString(R.string.collapsing_toolbar_step6));
                return true;
            }
        });

        ivCodeStep7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ToolbarCollapsing.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);

                } else {
                    ZoomImage.show(ToolbarCollapsing.this, R.drawable.collapsing_toolbar_step7);
                }

            }
        });
        ivCodeStep7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ToolbarCollapsing.this,
                        getResources().getString(R.string.collapsing_toolbar_step7));
                return true;
            }
        });

        ivCodeStep8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ToolbarCollapsing.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);

                } else {
                    ZoomImage.show(ToolbarCollapsing.this, R.drawable.collapsing_toolbar_step8);
                }

            }
        });
        ivCodeStep8.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ToolbarCollapsing.this,
                        getResources().getString(R.string.collapsing_toolbar_step8));
                return true;
            }
        });

        ivCodeStep9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ToolbarCollapsing.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);

                } else {
                    ZoomImage.show(ToolbarCollapsing.this, R.drawable.collapsing_toolbar_step9);
                }

            }
        });
        ivCodeStep9.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ToolbarCollapsing.this,
                        getResources().getString(R.string.collapsing_toolbar_step9));
                return true;
            }
        });

        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ToolbarCollapsing.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);

                } else {
                    ZoomGIF.show(ToolbarCollapsing.this, R.drawable.collapsing_toolbar_gif);
                }
            }
        });

    }

    private void init() {
        ivCodeStep1 = findViewById(R.id.ivCodeCollapsingToolbarStep1);
        ivCodeStep2 = findViewById(R.id.ivCodeCollapsingToolbarStep2);
        ivCodeStep3 = findViewById(R.id.ivCodeCollapsingToolbarStep3);
        ivCodeStep4 = findViewById(R.id.ivCodeCollapsingToolbarStep4);
        ivCodeStep5 = findViewById(R.id.ivCodeCollapsingToolbarStep5);
        ivCodeStep6 = findViewById(R.id.ivCodeCollapsingToolbarStep6);
        ivCodeStep7 = findViewById(R.id.ivCodeCollapsingToolbarStep7);
        ivCodeStep8 = findViewById(R.id.ivCodeCollapsingToolbarStep8);
        ivCodeStep9 = findViewById(R.id.ivCodeCollapsingToolbarStep9);

        btnDemo = findViewById(R.id.btnDemoCollapsingToolbar);

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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull
            String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == 100) {
            if (grantResults.length > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                Toasty.success(this, "Permission allowed." +
                        "You can now view and share images. Thank you.", Toast.LENGTH_SHORT).show();

            } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {

                if (ActivityCompat.shouldShowRequestPermissionRationale(ToolbarCollapsing.this,
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
