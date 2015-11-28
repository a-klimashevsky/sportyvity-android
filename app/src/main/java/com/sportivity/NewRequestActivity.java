package com.sportivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.IntentCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.sportivity.util.TrainerTypesUtil;
import com.sportivity.web.entities.Trainer;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;

public class NewRequestActivity extends AppCompatActivity {

    public static final String EXTRA_TRAINER_ID = "id";

    @Bind(R.id.name)
    TextView mNameView;

    @Bind(R.id.avatar)
    ImageView mAvatarView;

    @Bind(R.id.price_rate)
    TextView mPriceRateView;

    @Bind(R.id.ratingBar)
    RatingBar mRatingBarView;

    @Bind(R.id.trainer_container)
    View mView;

    @Bind(R.id.aims)
    Spinner mAimsSpinner;

    @OnClick(R.id.send_request)
    void sendRequest(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    Trainer mTrainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_request);
        ButterKnife.bind(this);
        int id = getIntent().getExtras().getInt(EXTRA_TRAINER_ID);
        Realm realm = Realm.getInstance(this);
        mTrainer = realm.where(Trainer.class).equalTo("id", id).findFirst();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        List<String> t = new LinkedList<>();
        t.add("Choose your aim:");
        t.addAll(Arrays.asList(TrainerTypesUtil.getTypes()));
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_item, t);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        mAimsSpinner.setAdapter(adapter);

        mNameView.setText(mTrainer.getName());
        mPriceRateView.setText(mTrainer.getPriceRate());
        mRatingBarView.setRating(mTrainer.getRating());
        Picasso
                .with(mNameView.getContext())
                .load(mTrainer.getAvatar())
                .resize(240,240)
                .centerCrop()
                .into(mAvatarView, new Callback() {
                    @Override
                    public void onSuccess() {
                        BitmapDrawable d= (BitmapDrawable) mAvatarView.getDrawable();
                        Palette.Builder builder = new Palette.Builder(d.getBitmap());
                        Palette p = builder.generate();
                        mView.setBackgroundColor(p.getLightMutedColor(Color.GRAY));
                        mView.requestLayout();
                    }

                    @Override
                    public void onError() {

                    }
                });
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
