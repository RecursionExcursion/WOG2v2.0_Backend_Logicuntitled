package com.rloup.wog.WorkoutAPI.workout;

import com.rloup.wog.WorkoutAPI.exercise.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Workout {

    private final List<Exercise> exercises = new ArrayList<>();

    public void addExercisesToWorkout(Exercise... exercises) {
        addExercisesToWorkout(Arrays.asList(exercises));
    }

    public void addExercisesToWorkout(List<Exercise> exercises){
        this.exercises.addAll(exercises);
    }

    public List<Exercise> getExercises() {
        return exercises;
    }
}
