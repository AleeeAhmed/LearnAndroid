package com.ali.learnandroid.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ali.learnandroid.R;

public class ExtrasCall extends AppCompatActivity {

    EditText etPhone;
    Button btnCall, btnDemo;
    LinearLayout llCall;
    RelativeLayout rlCall;


    private void init() {
        etPhone = findViewById(R.id.etPhoneNoExtrasCall);
        btnCall = findViewById(R.id.btnCall);
        llCall = findViewById(R.id.LL_ExtrasCall);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extras_call);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();

        //region Button call click event..
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNo = etPhone.getText().toString();
                if (phoneNo.length() > 0 ) {
                    if (ActivityCompat.checkSelfPermission(ExtrasCall.this,
                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                        ActivityCompat.requestPermissions(
                                ExtrasCall.this,
                                new String[]{Manifest.permission.CALL_PHONE},
                                11);

                    } else {
                        Call(phoneNo);
                    }
                } else {
                    Toast.makeText(ExtrasCall.this,
                            "Please enter phone number.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        //endregion

    }

    private void Call(String phoneNo) {
        Uri call = Uri.parse("tel:" + phoneNo);
        Intent callIntent = new Intent(Intent.ACTION_DIAL, call);  //just open the dialer
        //Intent surf = new Intent(Intent.ACTION_CALL, call); // call automatically
        startActivity(callIntent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        if(requestCode == 11) {

            if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                String phoneNo = etPhone.getText().toString();
                Call(phoneNo);
            }
            else {
                Toast.makeText(ExtrasCall.this,
                        "Permission denied.", Toast.LENGTH_SHORT).show();
            }
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
    public void onBackPressed() {

    }
}
