package com.sportivity.util;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public class TrainerTypesUtil {
    private static final String[] smTypes = new String[]{
            "Power training",
            "Conditioning program",
            "Running",
            "Yoga"};

    public static final String[] getTypes(){
        return smTypes;
    }
}
