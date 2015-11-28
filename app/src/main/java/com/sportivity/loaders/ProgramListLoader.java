package com.sportivity.loaders;

import android.content.Context;

import com.sportivity.web.Server;
import com.sportivity.web.entities.Program;

import java.util.List;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public class ProgramListLoader extends FixedAsyncTaskLoader<List<Program>> {

    private String mClientId;

    public ProgramListLoader(Context context, String clientId) {
        super(context);
        mClientId = clientId;
    }

    @Override
    public List<Program> loadInBackground() {
        return Server.getApi().getClientPrograms(mClientId);
    }
}
