package com.sportivity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Debug;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;

import com.sportivity.fragments.TrainerListFragment;
import com.crashlytics.android.Crashlytics;
import com.sportivity.views.HexDrawable;
import com.sportivity.web.Server;
import com.sportivity.web.entities.AuthDataApi;

import io.fabric.sdk.android.Fabric;
import jp.wasabeef.blurry.Blurry;
import jp.wasabeef.blurry.internal.Blur;
import jp.wasabeef.blurry.internal.BlurFactor;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());

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
        navigationView.getMenu().getItem(0).setIcon(new HexDrawable());
        ImageView avatarView = (ImageView) navigationView.getHeaderView(0).findViewById(R.id.avatar);
        HexDrawable d = new HexDrawable();
        d.setStrokeColor(Color.WHITE);
        d.setStrokeWidth(5);
        d.setmIconBitmap(((BitmapDrawable) getResources().getDrawable(R.mipmap.ic_test)).getBitmap());
        avatarView.setImageDrawable(d);

        ViewGroup v = (ViewGroup) navigationView.getHeaderView(0).findViewById(R.id.header_background);
        v.setBackground(getResources().getDrawable(R.mipmap.ic_test));
        BlurFactor factor = new BlurFactor();
        factor.radius = 8;
        //factor.color = Color.BLUE;
        factor.sampling = 2;
        factor.width = 300;
        factor.height = 200;
        Bitmap b = Blur.rs(this, ((BitmapDrawable) getResources().getDrawable(R.mipmap.ic_test)).getBitmap(), factor);
        Drawable bd = new BitmapDrawable(b);
        bd.setColorFilter(Color.BLUE, PorterDuff.Mode.SCREEN);
        v.setBackground(bd);
        /*Blurry.with(this)
                .radius(10)
                .sampling(8)
                .color(Color.argb(66, 255, 255, 0))
                .async()
                .capture(avatarView)
                .into(avatarView);*/

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.container, TrainerListFragment.newInstance())
                .commit();
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
        if (id == R.id.search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_search) {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.container, TrainerListFragment.newInstance())
                    .commit();
            setTitle("Trainers");
        } else if (id == R.id.nav_trains) {
            Intent intent = new Intent(this, TrainingObservingActivity.class);
            startActivity(intent);
        }

        invalidateOptionsMenu();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
