package com.sportivity.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import com.sportivity.loaders.ChatLoader;
import com.sportivity.web.entities.Message;

import java.util.List;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public class ChatFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<Message>> {

    private static final String ARG_CLIENT_ID = "clientId";

    private String mClientId;

    public static ChatFragment newInstance(String clientId){
        ChatFragment fragment = new ChatFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CLIENT_ID, clientId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Bundle args = getArguments();
        mClientId = args.getString(ARG_CLIENT_ID);
    }

    @Override
    public void onStart() {
        super.onStart();
        loadData(mClientId);
    }

    private void loadData(String clientId) {
        Bundle args = new Bundle();
        args.putString(ARG_CLIENT_ID, clientId);
        getLoaderManager().restartLoader(0, args, this);
    }

    @Override
    public Loader<List<Message>> onCreateLoader(int id, Bundle args) {
        return new ChatLoader(getContext(), args.getString(ARG_CLIENT_ID));
    }

    @Override
    public void onLoadFinished(Loader<List<Message>> loader, List<Message> data) {

    }

    @Override
    public void onLoaderReset(Loader<List<Message>> loader) {

    }
}
