package com.sportivity.loaders;

import android.content.Context;

import com.sportivity.web.Server;
import com.sportivity.web.entities.Message;

import java.util.List;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public class ChatLoader extends FixedAsyncTaskLoader<List<Message>> {
    private String mClientId;

    public ChatLoader(Context context, String clientId) {
        super(context);
        mClientId = clientId;
        ;
    }

    @Override
    public List<Message> loadInBackground() {
        return Server.getApi().getClientMessages(mClientId);
    }
}
