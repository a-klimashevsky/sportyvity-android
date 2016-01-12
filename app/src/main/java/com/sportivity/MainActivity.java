package com.sportivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.crashlytics.android.Crashlytics;
import com.sportivity.fragments.TrainerListFragment;
import com.sportivity.views.HexDrawable;

import io.fabric.sdk.android.Fabric;
import jp.wasabeef.blurry.internal.Blur;
import jp.wasabeef.blurry.internal.BlurFactor;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int MENU_ICON_STROKE_WIDTH = 5;

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

        ViewGroup nav = (ViewGroup) navigationView.getHeaderView(0);
        setBackground(nav, R.id.workout_image, "#ef717a");
        setBackground(nav, R.id.message_image, "#4bbd9c");
        setBackground(nav, R.id.trainers_image, "#3398db");
        setBackground(nav, R.id.share_image, "#f8a736");
        setBackground(nav, R.id.settings_image, "#c1392b");



        ImageView avatarView = (ImageView) nav.findViewById(R.id.avatar);
        HexDrawable d = new HexDrawable();
        d.setStrokeColor(Color.WHITE);
        d.setStrokeWidth(5);
        d.setmIconBitmap(((BitmapDrawable) getResources().getDrawable(R.mipmap.ic_test)).getBitmap());
        avatarView.setImageDrawable(d);

        ViewGroup v = (ViewGroup) navigationView.getHeaderView(0).findViewById(R.id.header_background);
        v.setBackground(getResources().getDrawable(R.mipmap.ic_test));
        BlurFactor factor = new BlurFactor();
        factor.radius = 8;
        factor.sampling = 2;
        factor.width = 300;
        factor.height = 200;
        Bitmap b = Blur.rs(this, ((BitmapDrawable) getResources().getDrawable(R.mipmap.ic_test)).getBitmap(), factor);
        Drawable bd = new BitmapDrawable(b);
        bd.setColorFilter(Color.BLUE, PorterDuff.Mode.SCREEN);
        v.setBackground(bd);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.container, TrainerListFragment.newInstance())
                .commit();
    }

    private void setBackground(View root, int id, String color) {
        Drawable workoutDrawable = getDrawableForColor(color);
        ImageView mWorkoutImageView = (ImageView) root.findViewById(id);
        mWorkoutImageView.setBackground(workoutDrawable);
    }

    private Drawable getDrawableForColor(String color) {
        HexDrawable drawable = new HexDrawable();
        drawable.setBackgroundColor(Color.parseColor(color));
        drawable.setStrokeColor(Color.parseColor(color));
        drawable.setStrokeWidth(MENU_ICON_STROKE_WIDTH);
        return drawable;
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

        /*if (id == R.id.nav_search) {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.container, TrainerListFragment.newInstance())
                    .commit();
            setTitle("Trainers");
        } else if (id == R.id.nav_trains) {
            Intent intent = new Intent(this, TrainingObservingActivity.class);
            startActivity(intent);
        }*/

        invalidateOptionsMenu();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
