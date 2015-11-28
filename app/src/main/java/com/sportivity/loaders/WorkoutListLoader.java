package com.sportivity.loaders;

import android.content.Context;

import com.sportivity.web.Server;
import com.sportivity.web.entities.Workout;

import java.util.List;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public class WorkoutListLoader extends FixedAsyncTaskLoader<List<Workout>> {

    private String mClientId;

    private String mProgramId;

    public WorkoutListLoader(Context context, String clientId, String programId) {
        super(context);
        mClientId = clientId;
        mProgramId = programId;
    }

    @Override
    public List<Workout> loadInBackground() {
        return Server.getApi().getClientWorkouts(mClientId, mProgramId);
    }
}
