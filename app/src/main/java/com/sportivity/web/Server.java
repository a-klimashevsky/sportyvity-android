package com.sportivity.web;

import android.content.Context;

import com.sportivity.R;

import retrofit.RestAdapter;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public class Server {

    private static Api smApi;


    public static void init(Context context){
        RestAdapter retrofit = new RestAdapter.Builder()
                .setEndpoint(context.getString(R.string.server_url))
                .build();
        smApi = retrofit.create(Api.class);
    }

    public static synchronized Api getApi() {
        return smApi;
    }
}
