package com.ali.learnandroid.Utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.ali.learnandroid.R;
import com.github.chrisbanes.photoview.PhotoView;

public class ZoomImage {

    public static void show(Activity activity, int image) {
        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(activity);
        View mView = activity.getLayoutInflater().inflate(R.layout.image_zoom_dialog, null);

        PhotoView photoView = mView.findViewById(R.id.imageView);
        photoView.setImageResource(image);


        mBuilder.setView(mView);
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
