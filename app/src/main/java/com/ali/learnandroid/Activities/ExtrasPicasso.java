package com.ali.learnandroid.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.ali.learnandroid.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.io.File;

public class ExtrasPicasso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extras_picasso);

        ImageView imageView = findViewById(R.id.ivCode);

        Picasso.get()
                //.load(R.drawable.tenor) // loading from drawable OR
                //.load(new File("file:///android_asset/image.png")) //loading from storage path OR
                .load("http://i.imgur.com/DvpvklR.png") //loading url image
                .placeholder(R.drawable.custom_toast_image) // during loading this image will be set imageview
                .error(R.drawable.logo) //if image is failed to load - this image is set to imageview
                .networkPolicy(NetworkPolicy.OFFLINE) //stores images for offline view
                .resize(50, 50) //resize
                .centerCrop()   // apply scaling OR
                .fit()          //apply scaling OR
                .centerInside() //scaling
                //.into(imageView)  //OR
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        //called when image is loaded successfully..
                    }
                    @Override
                    public void onError(Exception e) {
                        //called when image is failed to be loaded into.
                    }
                });




    }
}
