package com.ali.learnandroid.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.ali.learnandroid.R;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomImage;

public class AlertDialogWithRadioButtons extends AppCompatActivity {


    ImageView ivCode, ivCode2;
    Button btnDemo, btnDemo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_with_radio_buttons);


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ivCode = findViewById(R.id.ivCodeRadionButtons);
        btnDemo = findViewById(R.id.btnDemoCRadioButtonsAlertDialog);


        ivCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(AlertDialogWithRadioButtons.this, R.drawable.alert_dialog_radio_buttons_image);
            }
        });

        ivCode.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(AlertDialogWithRadioButtons.this,
                        getResources().getString(R.string.radio_buttons_alert_dialog));
                return true;
            }
        });

        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(AlertDialogWithRadioButtons.this);
                dialog.setTitle("Gender");
                View mView = getLayoutInflater().inflate(R.layout.sample_radio_buttons, null);
                final RadioButton rbMale = mView.findViewById(R.id.rbMale);
                final RadioButton rbFeMale = mView.findViewById(R.id.rbFemale);
                dialog.setView(mView);

                dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (rbMale.isChecked()) {
                            Toast.makeText(getApplicationContext(), "you are " +
                                    rbMale.getText().toString(), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "you are " +
                                    rbFeMale.getText().toString() , Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                dialog.show(); //finally Showing the alert dialog,

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

}
