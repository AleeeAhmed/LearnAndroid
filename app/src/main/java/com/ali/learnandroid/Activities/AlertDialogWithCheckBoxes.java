package com.ali.learnandroid.Activities;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ali.learnandroid.R;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomImage;
import com.github.chrisbanes.photoview.PhotoView;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;

public class AlertDialogWithCheckBoxes extends AppCompatActivity {

    Button btnDemo, btnDemoSecond;
    ImageView ivCode, ivCodeSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_with_check_boxes);


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        btnDemo = findViewById(R.id.btnDemoCheckBoxesAlertDialog);
        ivCode = findViewById(R.id.ivCodeCheckBoxes);
        btnDemoSecond = findViewById(R.id.btnDemoSecondCheckBoxesAlertDialog);
        ivCodeSecond = findViewById(R.id.ivCodeSecondCheckBoxes);

        ivCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(AlertDialogWithCheckBoxes.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(AlertDialogWithCheckBoxes.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
                } else {
                    ZoomImage.show(AlertDialogWithCheckBoxes.this, R.drawable.alert_dialog_check_boxes_image);
                }
            }
        });

        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String[] cities = {"Rawalpindi", "Islamabad","Karachi", "Lahore","Peshawar", "Quetta"}; //checkboxes values
                final ArrayList<String> checkedItems = new ArrayList<>();   //checkboxes that you select, will be stored in arraylist

                AlertDialog.Builder dialog = new AlertDialog.Builder(AlertDialogWithCheckBoxes.this); //MainActivity.this(for Activity)
                // or getActivity(for Fragment)

                dialog.setCancelable(true); //true->click anywhere on screen will hide alert dialog
                dialog.setTitle("Select cities");
                //dialog.setIcon(R.drawable.logo);

                dialog.setMultiChoiceItems(cities, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            checkedItems.add(cities[which]); //item added to arraylist
                        } else {
                            checkedItems.remove(cities[which]); //item removed from array list
                        }
                    }
                });

                dialog.setPositiveButton("Select", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (String item : checkedItems) {
                            stringBuilder.append(item).append(", ");
                        }
                        Toast.makeText(AlertDialogWithCheckBoxes.this, "You have selected: "+stringBuilder, Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(AlertDialogWithCheckBoxes.this, "cancelled..", Toast.LENGTH_SHORT).show();
                    }
                });


                dialog.show();

            }
        });


        ivCodeSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(AlertDialogWithCheckBoxes.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(AlertDialogWithCheckBoxes.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
                } else {
                    ZoomImage.show(AlertDialogWithCheckBoxes.this, R.drawable.alert_dialog_check_boxes_secondway_image);
                }
            }
        });

        ivCode.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(AlertDialogWithCheckBoxes.this,
                        getResources().getString(R.string.check_box_alert_dialog_first));
                return true;
            }
        });

        ivCodeSecond.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(AlertDialogWithCheckBoxes.this,
                        getResources().getString(R.string.check_box_alert_dialog_second));
                return true;
            }
        });

        btnDemoSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ArrayList<String> checkedItems = new ArrayList<>();   //checkboxes that you select, will be stored in arraylist

                AlertDialog.Builder dialog = new AlertDialog.Builder(AlertDialogWithCheckBoxes.this); //MainActivity.this(for Activity)
                // or getActivity(for Fragment)
                dialog.setCancelable(false); //false->click anywhere on screen will not hide alert dialog
                dialog.setTitle("Select cities");

                View mView = getLayoutInflater().inflate(R.layout.sample_check_boxes, null);
                final CheckBox cbRwp = mView.findViewById(R.id.checkBoxRawalpindi);
                final CheckBox cbIsb = mView.findViewById(R.id.checkBoxIslamabad);
                final CheckBox cbKhi = mView.findViewById(R.id.checkBoxKarachi);
                final CheckBox cbLhr = mView.findViewById(R.id.checkBoxLahore);
                final CheckBox cbPhwr = mView.findViewById(R.id.checkBoxPeshawar);
                final CheckBox cbQta = mView.findViewById(R.id.checkBoxQuetta);

                dialog.setView(mView);

                cbRwp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (cbRwp.isChecked()) {
                            checkedItems.add("Rawalpindi");
                        } else {
                            checkedItems.remove("Rawalpindi");
                        }
                    }
                });
                cbIsb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (cbIsb.isChecked()) {
                            checkedItems.add("Islamabad");
                        } else {
                            checkedItems.remove("Islamabad");
                        }
                    }
                });
                cbLhr.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (cbLhr.isChecked()) {
                            checkedItems.add("Lahore");
                        } else {
                            checkedItems.remove("Lahore");
                        }
                    }
                });

                cbKhi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (cbKhi.isChecked()) {
                            checkedItems.add("Karachi");
                        } else {
                            checkedItems.remove("Karachi");
                        }
                    }
                });
                cbPhwr.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (cbPhwr.isChecked()) {
                            checkedItems.add("Peshawar");
                        } else {
                            checkedItems.remove("Peshawar");
                        }
                    }
                });
                cbQta.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (cbQta.isChecked()) {
                            checkedItems.add("Quetta");
                        } else {
                            checkedItems.remove("Quetta");
                        }
                    }
                });

                dialog.setPositiveButton("Select", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (String item : checkedItems) {
                            stringBuilder.append(item).append(", ");
                        }
                        Toast.makeText(AlertDialogWithCheckBoxes.this, "You have selected: "+stringBuilder, Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(AlertDialogWithCheckBoxes.this, "cancelled..", Toast.LENGTH_SHORT).show();
                    }
                });


                dialog.show();

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

                if (ActivityCompat.shouldShowRequestPermissionRationale(AlertDialogWithCheckBoxes.this,
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
