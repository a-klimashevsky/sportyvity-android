package com.sportivity.loaders;

import android.content.Context;

import com.sportivity.web.Server;
import com.sportivity.web.entities.Exercise;

import java.util.List;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public class ExerciseListLoader extends FixedAsyncTaskLoader<List<Exercise>> {

    private String mClientId;

    private String mProgramId;

    private String mWorkoutId;

    public ExerciseListLoader(Context context, String clientId, String programId, String workoutId) {
        super(context);
        mClientId = clientId;
        mProgramId = programId;
        mWorkoutId = workoutId;
    }

    @Override
    public List<Exercise> loadInBackground() {
        return Server.getApi().getClientExercises(mClientId, mProgramId, mWorkoutId);
    }
}
