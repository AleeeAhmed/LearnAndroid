package com.ali.learnandroid.Activities;


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ali.learnandroid.Fragments.Frag_AlertDialogs;
import com.ali.learnandroid.Fragments.Frag_Anim;
import com.ali.learnandroid.Fragments.Frag_AsyncTasks;
import com.ali.learnandroid.Fragments.Frag_Extras;
import com.ali.learnandroid.Fragments.Frag_FAB;
import com.ali.learnandroid.Fragments.Frag_Lists;
import com.ali.learnandroid.Fragments.Frag_Pickers;
import com.ali.learnandroid.Fragments.Frag_MainMenu;
import com.ali.learnandroid.Fragments.Frag_PopUpMenu;
import com.ali.learnandroid.Fragments.Frag_SnackBars;
import com.ali.learnandroid.Fragments.Frag_Toasts;
import com.ali.learnandroid.Fragments.Frag_Toolbar;
import com.ali.learnandroid.R;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_Home, new Frag_MainMenu()).addToBackStack(null).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_exit) {
            finishAffinity();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fl_Home, new Frag_MainMenu()).addToBackStack(null).commit();

        } else if (id == R.id.nav_alert_dialogs) {

            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fl_Home, new Frag_AlertDialogs()).addToBackStack(null).commit();

        } else if (id == R.id.nav_toasts) {

            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fl_Home, new Frag_Toasts()).addToBackStack(null).commit();

        } else if (id == R.id.nav_snackbars) {

            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fl_Home, new Frag_SnackBars()).addToBackStack(null).commit();
        } else if (id == R.id.nav_async_task) {

            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fl_Home, new Frag_AsyncTasks()).addToBackStack(null).commit();

        } else if (id == R.id.nav_extras) {

            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fl_Home, new Frag_Extras()).addToBackStack(null).commit();

        } else if (id == R.id.nav_pop_up_menu) {

            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fl_Home, new Frag_PopUpMenu()).addToBackStack(null).commit();
        } else if (id == R.id.nav_pickers) {

            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fl_Home, new Frag_Pickers()).addToBackStack(null).commit();
        } else if (id == R.id.nav_fab) {

            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fl_Home, new Frag_FAB()).addToBackStack(null).commit();

        } else if (id == R.id.nav_toolbar) {

            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fl_Home, new Frag_Toolbar()).addToBackStack(null).commit();

        } else if (id == R.id.nav_animations) {

            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fl_Home, new Frag_Anim()).addToBackStack(null).commit();
        } else if (id == R.id.nav_lists) {

            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fl_Home, new Frag_Lists()).addToBackStack(null).commit();
        } else if (id == R.id.nav_about) {
            Toast.makeText(this, "under constrction..", Toast.LENGTH_SHORT).show();
        }else if (id == R.id.nav_exit) {
            finishAffinity();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
