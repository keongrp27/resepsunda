package com.example.keong.resepsunda;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.keong.resepsunda.halaman.BahanSaya_Fragment;
import com.example.keong.resepsunda.halaman.Bantuan_Fragment;
import com.example.keong.resepsunda.halaman.Favorite_Fragment;
import com.example.keong.resepsunda.halaman.LihatResep_fragment;
import com.example.keong.resepsunda.halaman.Tentang_Fragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


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

        //halaman yg mau tampil pertama
        if (savedInstanceState == null) {
            displayView(0);
        }
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // aksi menu di klik
        int id = item.getItemId();

        if (id == R.id.nav_bahan) {
            displayView(0);
        } else if (id == R.id.nav_lihat) {
            displayView(1);
        } else if (id == R.id.nav_favorite) {
            displayView(2);
        } else if (id == R.id.nav_bantuan) {
            displayView(3);
        } else if (id == R.id.nav_tentang) {
            displayView(4);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void displayView(int position) {
        Fragment fragment = null;
        //posisi fragment
        switch (position) {
            case 0:
                fragment = new BahanSaya_Fragment();
                break;
            case 1:
                fragment = new LihatResep_fragment();
                break;
            case 2:
                fragment = new Favorite_Fragment();
                break;
            case 3 :
                fragment = new Bantuan_Fragment();
                break;
            case 4 :
                fragment = new Tentang_Fragment();
                break;

            default:
                break;
        }

        //pengganti container (ada di content main.xml)
        if (fragment != null) {
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction()
                    .replace(R.id.halaman, fragment).commit();

        }
    }


}
