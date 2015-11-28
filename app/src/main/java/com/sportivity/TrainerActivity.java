package com.sportivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.sportivity.web.entities.Trainer;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import io.realm.Realm;

public class TrainerActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_TRAINER_ID = "id";

    private CollapsingToolbarLayout collapsingToolbarLayout;

    private RatingBar mRatingBar;

    private TextView mPriceRateView;

    private TextView mDescriptionView;

    private Trainer mTrainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainer);
        int id = getIntent().getExtras().getInt(EXTRA_TRAINER_ID);
        Realm realm = Realm.getInstance(this);
        mTrainer = realm.where(Trainer.class).equalTo("id", id).findFirst();
         //ViewCompat.setTransitionName(findViewById(R.id.app_bar_layout), EXTRA_IMAGE);
        supportPostponeEnterTransition();

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String itemTitle = mTrainer.getName();
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(itemTitle);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        mRatingBar = (RatingBar) findViewById(R.id.ratingBar);
        mPriceRateView = (TextView) findViewById(R.id.price_rate);
        mDescriptionView = (TextView) findViewById(R.id.description);
        final ImageView image = (ImageView) findViewById(R.id.image);
        mRatingBar.setRating(mTrainer.getRating());
        mPriceRateView.setText(mTrainer.getPriceRate());
        mDescriptionView.setText(mTrainer.getDescription());
        Picasso.with(this).load(mTrainer.getAvatar()).into(image, new Callback() {
            @Override public void onSuccess() {
                Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
                Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                    public void onGenerated(Palette palette) {
                        applyPalette(palette);
                    }
                });
            }

            @Override public void onError() {

            }
        });
        findViewById(R.id.fab).setOnClickListener(this);
    }

    private void applyPalette(Palette palette) {
        int primaryDark = getResources().getColor(R.color.colorPrimaryDark);
        int primary = getResources().getColor(R.color.colorPrimary);
        collapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(primary));
        collapsingToolbarLayout.setStatusBarScrimColor(palette.getDarkMutedColor(primaryDark));
        updateBackground((FloatingActionButton) findViewById(R.id.fab), palette);
        supportStartPostponedEnterTransition();
    }

    private void updateBackground(FloatingActionButton fab, Palette palette) {
        int lightVibrantColor = palette.getLightVibrantColor(getResources().getColor(android.R.color.white));
        int vibrantColor = palette.getVibrantColor(getResources().getColor(R.color.colorAccent));

        fab.setRippleColor(lightVibrantColor);
        fab.setBackgroundTintList(ColorStateList.valueOf(vibrantColor));
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, NewRequestActivity.class);
        intent.putExtra(NewRequestActivity.EXTRA_TRAINER_ID, mTrainer.getId());
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
        }
        return true;
    }
}
