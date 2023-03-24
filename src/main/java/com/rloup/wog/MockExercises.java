package com.rloup.wog;

import com.rloup.wog.exercise.Equipment;
import com.rloup.wog.exercise.Exercise;
import com.rloup.wog.exercise.Region;

import java.util.ArrayList;
import java.util.List;

public class MockExercises {
    public static final List<Exercise> MOCKEXERCISES = new ArrayList<>(List.of(
            new Exercise("Push Up",
                         "",
                         new Equipment[]{Equipment.BODY_WEIGHT},
                         new Region[]{Region.CHEST, Region.Core}),
            new Exercise("Squat",
                         "",
                         new Equipment[]{Equipment.BODY_WEIGHT},
                         new Region[]{Region.LEGS}),
            new Exercise("Pull Ups",
                         "",
                         new Equipment[]{Equipment.BODY_WEIGHT},
                         new Region[]{Region.BACK})
    ));
}
