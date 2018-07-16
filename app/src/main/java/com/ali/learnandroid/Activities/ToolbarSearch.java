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
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ali.learnandroid.R;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomImage;

import es.dmoral.toasty.Toasty;

public class ToolbarSearch extends AppCompatActivity {

    private SearchView searchView;
    ImageView ivCodeStep1,ivCodeStep2,ivCodeStep3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_search);


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        init();

        ivCodeStep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ToolbarSearch.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);

                } else {
                    ZoomImage.show(ToolbarSearch.this, R.drawable.popup_butn_menu_gif_images);
                }

            }
        });
        ivCodeStep1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(ToolbarSearch.this,
                        R.string.nothing_here,
                        Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        ivCodeStep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ToolbarSearch.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);

                } else {
                    ZoomImage.show(ToolbarSearch.this, R.drawable.toolbar_search_step1);
                }

            }
        });
        ivCodeStep2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ToolbarSearch.this,
                        getResources().getString(R.string.search_toolbar_step1));
                return true;
            }
        });

        ivCodeStep3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ToolbarSearch.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);

                } else {
                    ZoomImage.show(ToolbarSearch.this, R.drawable.toolbar_search_step2);
                }

            }
        });
        ivCodeStep3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ToolbarSearch.this,
                        getResources().getString(R.string.search_toolbar_step2));
                return true;
            }
        });
    }

    private void init() {
        ivCodeStep1 = findViewById(R.id.ivCodeSearchButtonToolbarStep1);
        ivCodeStep2 = findViewById(R.id.ivCodeSearchButtonToolbarStep2);
        ivCodeStep3 = findViewById(R.id.ivCodeSearchButtonToolbarStep3);

    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu) {
        getMenuInflater().inflate( R.menu.sample_search, menu);

        final MenuItem myActionMenuItem = menu.findItem( R.id.menu_search);
        searchView = (SearchView) myActionMenuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String searchText) {
                Toast.makeText(ToolbarSearch.this, "SearchText: " + searchText,
                        Toast.LENGTH_SHORT).show();
                if( !searchView.isIconified()) {
                    searchView.setIconified(true);
                }
                myActionMenuItem.collapseActionView();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String searchText) {
                //use this method if you want to search character by character.

/*                Toast.makeText(ToolbarSearch.this,
                        "Search: " + searchText, Toast.LENGTH_SHORT).show();*/
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
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

                if (ActivityCompat.shouldShowRequestPermissionRationale(ToolbarSearch.this,
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
