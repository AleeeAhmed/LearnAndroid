package com.ali.learnandroid.Utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ali.learnandroid.R;
import com.github.chrisbanes.photoview.PhotoView;

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
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_STREAM, image);
                //sendIntent.setType("text/plain");
                sendIntent.setType("image/*");
                activity.startActivity(sendIntent);
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
}
