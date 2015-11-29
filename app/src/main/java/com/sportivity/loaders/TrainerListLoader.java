package com.sportivity.loaders;

import android.content.Context;

import com.sportivity.web.Server;
import com.sportivity.web.entities.Trainer;

import java.util.LinkedList;
import java.util.List;

import io.realm.Realm;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public class TrainerListLoader extends FixedAsyncTaskLoader<List<Trainer>> {

    public TrainerListLoader(Context context) {
        super(context);
    }

    @Override
    public List<Trainer> loadInBackground() {
        String description = "Professor Ken Baldwin is a full-time Associate Professor and the Program Coordinator for the Four-Year Fitness and Wellness Leadership Undergraduate Degree at the State University of New York’s (SUNY) Department of Fitness and Wellness since 2007. Ken has been working in an academic setting since 2000, and his first opportunity to teach and coordinate his first academic program was at San Diego State University (SDSU). He created SDSU’s Personal Trainer Certificate Program, a 6-month program that prepared individuals to become successful personal trainers. Professor Baldwin is best known for developing and implementing Purdue University’s Undergraduate Degree in Personal Fitness Training, the Nation’s first four-year degree program for students planning to pursue a career in personal training in 2004. It’s not only that this was the first four degree, but he is known for creating the current modern day academic model for undergraduate fitness/exercise science degree structure that incorporates clinical rotations, practical course work, and business classes into degrees focusing on fitness, personal training, kinesiology, sports performance/strength and conditioning, and exercise science.";
        Trainer faked1 = new Trainer("Dan Eiden", "http://timjordanpt.com/wp-content/uploads/2013/06/tim-jordan-personal-trainer-edinburgh2.jpg", "70-100$", 4.5f);
        faked1.setDescription(description);
        Trainer faked2 = new Trainer("Emily Skye", "http://i.dailymail.co.uk/i/pix/2014/11/12/1415792550754_Image_galleryImage_AUSTRALIA_S_NUMBER_ONE_SO.JPG", "50-80$", 4.5f);
        faked2.setDescription(description);
        Trainer faked3 = new Trainer("Oleg Mozgov", "http://www.mobydick.by/images/trainers/oleg1.jpg", "70-130$", 5f);
        faked3.setDescription(description);
        Trainer faked4 = new Trainer("Chad West", "http://www.mozelewski-training.de/sites/default/files//A02A6590ff%20%281%29.JPG", "20-40$", 3.1f);
        faked4.setDescription(description);
        Trainer faked5 = new Trainer("Marc Coronel", "http://crossfitmonkeybars.com/sites/default/files/images/about/gabriel-grobben-crossfit-05_0.jpg", "80-120$", 4.7f);
        faked5.setDescription(description);
        Trainer faked6 = new Trainer("Angel Thill", "http://prodirectory.performbetter.com/Images/ProDir/Professionals/Pictures/1586/Image.JPG", "75-110$", 5);
        faked6.setDescription(description);
        Trainer faked7 = new Trainer("Kate Ellis", "http://www.caragilman.com/wp-content/uploads/2012/07/photo-2.jpg", "50$", 4.8f);
        faked7.setDescription(description);
        Trainer faked8 = new Trainer("Matt Roberts", "http://www.nuagefitnesscenter.com/assets/bigstock-Personal-trainer-helping-woman-55909970-c-r.jpg", "40-60$", 5f);
        faked8.setDescription(description);
        Trainer faked9 = new Trainer("Holly Weir", "http://www.benefitpersonaltraining.com.au/images/bgPic1.jpg", "60$", 5f);
        faked9.setDescription(description);
        Trainer faked10 = new Trainer("Christian Blisse", "http://i0.wp.com/www.shutupandtrain.com/wp-content/uploads/2012/06/Brock_Cunico_Fitness.jpg", "35-45$", 2f);



        faked1.setId(20);
        faked2.setId(21);
        faked3.setId(22);
        faked4.setId(23);
        faked5.setId(24);
        faked6.setId(25);
        faked7.setId(26);
        faked8.setId(27);
        faked9.setId(28);
        faked10.setId(29);
        final List<Trainer> trainers = new LinkedList<>();
        trainers.add(faked1);
        trainers.add(faked2);
        trainers.add(faked3);
        trainers.add(faked4);
        trainers.add(faked5);
        trainers.add(faked6);
        trainers.add(faked7);
        trainers.add(faked8);
        trainers.add(faked9);
        trainers.add(faked10);
        Realm realm = Realm.getInstance(getContext());
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.clear(Trainer.class);
                realm.copyToRealmOrUpdate(trainers);
            }
        });
        return trainers;
        //return Server.getApi().getTrainers(0,0f);
    }
}
