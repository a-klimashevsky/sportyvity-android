package com.sportivity.web;

import retrofit.Retrofit;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public class Server {

    private static final String SERVER = "http://127.0.0.1";

    private static Api smApi;

    public static synchronized Api getApi() {
        if (smApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(SERVER)
                    .build();
            smApi = retrofit.create(Api.class);
        }
        return smApi;
    }
}
