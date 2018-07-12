package com.ali.learnandroid.Activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import com.ali.learnandroid.Fragments.Frag_AlertDialogs;
import com.ali.learnandroid.Fragments.Frag_Anim;
import com.ali.learnandroid.Fragments.Frag_AsyncTasks;
import com.ali.learnandroid.Fragments.Frag_FAB;
import com.ali.learnandroid.Fragments.Frag_MainMenu;
import com.ali.learnandroid.R;
import com.ali.learnandroid.Utils.CopyToClipBoard;
import com.ali.learnandroid.Utils.ZoomImage;
import me.relex.circleindicator.CircleIndicator;

public class ExtrasViewPager extends AppCompatActivity {

    private ViewPager viewPager;
    private CircleIndicator indicator;
    ScrollView layout;

    ImageView ivCodeStep1,ivCodeStep2,ivCodeStep3;
    Button btnDemo;

    private void init() {
        ivCodeStep1 = findViewById(R.id.ivCodeViewPagerStep1);
        ivCodeStep2 = findViewById(R.id.ivCodeViewPagerStep2);
        ivCodeStep3 = findViewById(R.id.ivCodeViewPagerStep3);

        btnDemo = findViewById(R.id.btnDemoViewPager);

        layout = findViewById(R.id.viewPagerLayout);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extras_view_pager);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();

        ivCodeStep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(ExtrasViewPager.this, R.drawable.view_pager_step1);
            }
        });
        ivCodeStep1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ExtrasViewPager.this,
                        getResources().getString(R.string.view_pager_step1));
                return true;
            }
        });

        ivCodeStep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(ExtrasViewPager.this, R.drawable.view_pager_step2);
            }
        });
        ivCodeStep2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ExtrasViewPager.this,
                        getResources().getString(R.string.view_pager_step2));
                return true;
            }
        });

        ivCodeStep3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZoomImage.show(ExtrasViewPager.this, R.drawable.view_pager_step3);
            }
        });
        ivCodeStep3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CopyToClipBoard.Copy(ExtrasViewPager.this,
                        getResources().getString(R.string.view_pager_step3));
                return true;
            }
        });

        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

    }

    private void showDialog() {

        layout.setVisibility(View.GONE);
        viewPager = findViewById(R.id.viewpagerAlert);
        viewPager.setVisibility(View.VISIBLE);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        indicator = findViewById(R.id.indicator);
        indicator.setVisibility(View.VISIBLE);
        indicator.setViewPager(viewPager);
    }

    private class MyPagerAdapter extends FragmentStatePagerAdapter {

        MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int pos) {
            //region Switch
            switch(pos) {
                case 0:
                    return new Frag_AlertDialogs();
                case 1:
                    return new Frag_Anim();
                case 2:
                    return new Frag_AsyncTasks();
                case 3:
                    return new Frag_FAB();
                default:
                    return new Frag_MainMenu();
            }
            //endregion
        }

        @Override
        public int getCount() {
            return 4;
        }
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
