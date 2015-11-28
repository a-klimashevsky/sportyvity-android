package com.sportivity.loaders;

import android.content.Context;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public abstract class FixedAsyncTaskLoader<D> extends android.support.v4.content.AsyncTaskLoader<D> {

    public FixedAsyncTaskLoader(Context context) {
        super(context);
        onContentChanged();
    }

    @Override
    protected void onStopLoading() {
        cancelLoad();
    }

    @Override
    protected void onStartLoading() {
        if (takeContentChanged())
            forceLoad();
    }
}
