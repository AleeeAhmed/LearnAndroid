package com.ali.learnandroid.Activities;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.ali.learnandroid.R;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomGIF;
import com.ali.learnandroid.Utils.ZoomImage;

public class ToolbarRefresh extends AppCompatActivity {

    private MenuItem menuItem;
    ImageView ivCodeStep1,ivCodeStep2,ivCodeStep3,ivCodeStep4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_refresh);


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        init();

        ivCodeStep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(ToolbarRefresh.this, R.drawable.popup_butn_menu_gif_images);
            }
        });
        ivCodeStep1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(ToolbarRefresh.this,
                        R.string.nothing_here,
                        Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        ivCodeStep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(ToolbarRefresh.this, R.drawable.toolbar_refresh_step1);
            }
        });
        ivCodeStep2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ToolbarRefresh.this,
                        getResources().getString(R.string.refresh_toolbar_step1));
                return true;
            }
        });

        ivCodeStep3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(ToolbarRefresh.this, R.drawable.toolbar_refresh_step2);
            }
        });
        ivCodeStep3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ToolbarRefresh.this,
                        getResources().getString(R.string.refresh_toolbar_step2));
                return true;
            }
        });

        ivCodeStep4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(ToolbarRefresh.this, R.drawable.toolbar_refresh_step3);
            }
        });
        ivCodeStep4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ToolbarRefresh.this,
                        getResources().getString(R.string.refresh_toolbar_step3));
                return true;
            }
        });

    }


    private void init() {
        ivCodeStep1 = findViewById(R.id.ivCodeRefreshButtonToolbarStep1);
        ivCodeStep2 = findViewById(R.id.ivCodeRefreshButtonToolbarStep2);
        ivCodeStep3 = findViewById(R.id.ivCodeRefreshButtonToolbarStep3);
        ivCodeStep4 = findViewById(R.id.ivCodeRefreshButtonToolbarStep4);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_refresh, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
                case R.id.menu_refresh:
                Toast.makeText(this, "Refreshing..", Toast.LENGTH_SHORT).show();
                menuItem = item;
                menuItem.setActionView(R.layout.sample_progress_bar);
                menuItem.expandActionView();
                new TestTask().execute();
                break;
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return true;
    }

    private class TestTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            // Do something
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            menuItem.collapseActionView();
            menuItem.setActionView(null);
            Toast.makeText(ToolbarRefresh.this, "Refreshed..", Toast.LENGTH_SHORT).show();
        }
    }


}
