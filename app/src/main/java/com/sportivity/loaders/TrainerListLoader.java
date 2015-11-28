package com.sportivity.loaders;

import android.content.Context;

import com.sportivity.web.Server;
import com.sportivity.web.entities.Trainer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public class TrainerListLoader extends FixedAsyncTaskLoader<List<Trainer>> {

    public TrainerListLoader(Context context) {
        super(context);
    }

    @Override
    public List<Trainer> loadInBackground() {
        Trainer faked = new Trainer("Jeck Carter", "http://www.followingthenerd.com/site/wp-content/uploads/avatar.jpg_274898881.jpg", "25-50$", 4.5f);
        Trainer faked2 = new Trainer("Tom Tom",
                "http://findicons.com/files/icons/1072/face_avatars/300/a05.png", "5-15$", 3.6f);
        List<Trainer> trainers = new LinkedList<>();
        trainers.add(faked);
        trainers.add(faked2);
        trainers.add(faked);
        trainers.add(faked2);
        trainers.add(faked);
        trainers.add(faked2);
        trainers.add(faked);
        trainers.add(faked2);
        trainers.add(faked);
        trainers.add(faked2);
        trainers.add(faked);
        trainers.add(faked2);
        trainers.add(faked);
        trainers.add(faked2);
        trainers.add(faked);
        trainers.add(faked2);
        trainers.add(faked);
        trainers.add(faked2);
        trainers.add(faked);
        trainers.add(faked2);
        trainers.add(faked);
        trainers.add(faked2);

        trainers.add(faked);
        trainers.add(faked2);
        trainers.add(faked);
        trainers.add(faked2);
        trainers.add(faked);
        trainers.add(faked2);

        return trainers;
        //return Server.getApi().getTrainers(0,0f);
    }
}
