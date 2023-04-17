package com.rloup.wog.workout.factories;

import com.rloup.wog.exercise.Exercise;
import com.rloup.wog.workout.Workout;

import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;

public interface AbstractWorkoutFactory {

    Workout create();

    static Workout buildWorkout(List<Exercise> exercises, int numOfExercises, boolean repeatExercise) {
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
