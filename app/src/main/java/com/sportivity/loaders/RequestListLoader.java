package com.sportivity.loaders;

import android.content.Context;

import com.sportivity.web.Server;
import com.sportivity.web.entities.Request;

import java.util.List;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public class RequestListLoader extends FixedAsyncTaskLoader<List<Request>> {

    private String mClientId;

    public RequestListLoader(Context context, String clientId) {
        super(context);
        mClientId = clientId;
    }

    @Override
    public List<Request> loadInBackground() {
        return Server.getApi().getClientRequests(mClientId);
    }
}
