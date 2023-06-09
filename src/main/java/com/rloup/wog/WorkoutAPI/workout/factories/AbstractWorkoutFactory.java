package com.rloup.wog.WorkoutAPI.workout.factories;

import com.rloup.wog.WorkoutAPI.exercise.Exercise;
import com.rloup.wog.WorkoutAPI.workout.Workout;

import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;

public abstract class AbstractWorkoutFactory {

    public abstract Workout create();

    Workout buildWorkout(List<Exercise> exercises, int numOfExercises, boolean repeatExercise) {
        Workout workout = new Workout();
        Random rand = new Random();

        BiFunction<Boolean, Integer, Exercise> getOrRemoveExercise = (isRepeat, i) ->
                isRepeat ? exercises.get(i) : exercises.remove((int) i);

        while (!exercises.isEmpty() && workout.getExercises().size() < numOfExercises) {
            int i = rand.nextInt(exercises.size());
            workout.addExercisesToWorkout(getOrRemoveExercise.apply(repeatExercise, i));
        }
        return workout;
    }
}
