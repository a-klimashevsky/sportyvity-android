package com.sportivity.adapters;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.sportivity.R;
import com.sportivity.web.entities.Trainer;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public class TrainerListAdapter extends RecyclerView.Adapter<TrainerListAdapter.TrainerViewHolder> {
    private List<Trainer> mTrainers;

    public TrainerListAdapter(List<Trainer> trainers) {
        mTrainers = trainers;
    }

    @Override
    public TrainerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TrainerViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_trainer, parent, false));
    }

    @Override
    public void onBindViewHolder(TrainerViewHolder holder, int position) {
        holder.bind(mTrainers.get(position));
    }

    @Override
    public int getItemCount() {
        return mTrainers == null ? 0 : mTrainers.size();
    }

    public static class TrainerViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.name)
        TextView mNameView;

        @Bind(R.id.avatar)
        ImageView mAvatarView;

        @Bind(R.id.price_rate)
        TextView mPriceRateView;

        @Bind(R.id.ratingBar)
        RatingBar mRatingBarView;

        View mView;

        public TrainerViewHolder(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, view);
        }

        public void bind(Trainer trainer) {
            mNameView.setText(trainer.getName());
            mPriceRateView.setText(trainer.getPriceRate());
            mRatingBarView.setRating(trainer.getRating());
            Picasso
                    .with(mNameView.getContext())
                    .load(trainer.getAvatar())
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
    }
}
