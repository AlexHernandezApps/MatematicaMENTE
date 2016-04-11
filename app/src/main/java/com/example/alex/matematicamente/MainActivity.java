package com.example.alex.matematicamente;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.afollestad.materialdialogs.MaterialDialog;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    AlgebraFragment algebraFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        algebraFragment = new AlgebraFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment,algebraFragment).addToBackStack("A").commit();

    }

    @Override
    public void onBackPressed() {

        this.finish();
        super.onBackPressed();

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
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_algebra){


            if(algebraFragment.isVisible()){
                Log.e("WAOOO", "ASAASASA");
            }else{
                AlgebraFragment fragment = new AlgebraFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment, fragment).addToBackStack("A").commit();
            }


        } else if(id == R.id.nav_trigonometría) {

            new MaterialDialog.Builder(this)
                    .title("FUNCIÓN NO DISPONIBLE")
                    .content("Esta función no se encuentra disponible")
                    .positiveText("OK")
                    .cancelable(false)
                    .show();

        } else if (id == R.id.nav_calculo_dif) {

            new MaterialDialog.Builder(this)
                    .title("FUNCIÓN NO DISPONIBLE")
                    .content("Esta función no se encuentra disponible")
                    .positiveText("OK")
                    .cancelable(false)
                    .show();

        } else if(id == R.id.nav_calculo_int){

            new MaterialDialog.Builder(this)
                    .title("FUNCIÓN NO DISPONIBLE")
                    .content("Esta función no se encuentra disponible")
                    .positiveText("OK")
                    .cancelable(false)
                    .show();

        } else if (id == R.id.nav_estadistica){

            new MaterialDialog.Builder(this)
                    .title("FUNCIÓN NO DISPONIBLE")
                    .content("Esta función no se encuentra disponible")
                    .positiveText("OK")
                    .cancelable(false)
                    .show();

        } else if (id == R.id.nav_geometry){

            new MaterialDialog.Builder(this)
                    .title("FUNCIÓN NO DISPONIBLE")
                    .content("Esta función no se encuentra disponible")
                    .positiveText("OK")
                    .cancelable(false)
                    .show();

        } else if (id == R.id.nav_exit) {
         finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
