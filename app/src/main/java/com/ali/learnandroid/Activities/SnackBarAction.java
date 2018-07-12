package com.ali.learnandroid.Activities;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.ali.learnandroid.R;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomImage;

public class SnackBarAction extends AppCompatActivity {

    Button btnDemo;
    ImageView ivCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar_action);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        btnDemo = findViewById(R.id.btnDemoSnackBarAction);
        ivCode = findViewById(R.id.ivCodeSnackBarAction);

        ivCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(SnackBarAction.this,
                        R.drawable.snackbar_action);
            }
        });

        ivCode.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(SnackBarAction.this,
                        getResources().getString(R.string.action_snackbar));
                return true;
            }
        });

        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(
                        view,
                        "Hello !! I'm Snackbar with Undo Option.", //Text to be displayed in SnackBar
                        Snackbar.LENGTH_LONG
                ).setAction(
                        "Undo",    //Text of Action
                        new View.OnClickListener() {     //When you click on action(Undo) then this method is called
                                                         // you can do anything inside this method
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(
                                        SnackBarAction.this,
                                        "Snackbar Undo Clicked",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                ).setActionTextColor(   //change the color of text of action
                        getResources().getColor(R.color.colorAccent)
                ).
                show();

            }
        });

    }
}
