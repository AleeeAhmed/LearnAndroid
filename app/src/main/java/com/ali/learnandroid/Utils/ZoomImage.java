package com.ali.learnandroid.Utils;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ali.learnandroid.R;
import com.github.chrisbanes.photoview.PhotoView;

import es.dmoral.toasty.Toasty;

public class ZoomImage {

    public static void show(final Activity activity, final int image) {
        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(activity);
        View mView = activity.getLayoutInflater().inflate(R.layout.image_zoom_dialog, null);

        ImageView share = mView.findViewById(R.id.shareButton);
        PhotoView photoView = mView.findViewById(R.id.imageView);
        photoView.setImageResource(image);


        mBuilder.setView(mView);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(activity,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                        Toasty.error(activity, "Please allow storage permission.", Toast.LENGTH_LONG, true).show();
                    } else {
                        ActivityCompat.requestPermissions(activity,
                                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
                    }
                } else {
                    shareFile(activity,image);
                }
            }
        });

        mBuilder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        final AlertDialog mDialog = mBuilder.create();
        mDialog.show();
    }

    private static void shareFile(Activity activity, int image) {
        Bitmap imgBitmap= BitmapFactory.decodeResource(activity.getResources(), image);
        String imgBitmapPath= MediaStore.Images.
                Media.insertImage(activity.getContentResolver(),imgBitmap,"title",null);
        Uri imgBitmapUri=Uri.parse(imgBitmapPath);
        Intent shareIntent=new Intent(Intent.ACTION_SEND);
        shareIntent.setType("image/*");
        shareIntent.putExtra(Intent.EXTRA_STREAM,imgBitmapUri);
        activity.startActivity(Intent.createChooser(shareIntent,"share image using"));
    }
}
