package com.rloup.wog;

import com.rloup.wog.exercise.Exercise;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        LocalExerciseManager localExerciseManager = new LocalExerciseManager();
        Exercise[] exercises = localExerciseManager.getExercises();
        List<Exercise> exLIst = new ArrayList<>(List.of(exercises));
        localExerciseManager.saveExercises(exLIst);


    }
}
