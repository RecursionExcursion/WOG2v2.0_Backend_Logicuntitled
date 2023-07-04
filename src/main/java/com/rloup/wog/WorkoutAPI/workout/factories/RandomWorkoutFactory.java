package com.rloup.wog.WorkoutAPI.workout.factories;

import com.rloup.wog.WorkoutAPI.LocalExerciseManager;
import com.rloup.wog.WorkoutAPI.exercise.Exercise;
import com.rloup.wog.WorkoutAPI.workout.Workout;

import java.util.Arrays;
import java.util.List;

public class RandomWorkoutFactory extends AbstractWorkoutFactory {

    private final int numberOfExercises;
    private final boolean repeatExercise;

    private final List<Exercise> validExercises = Arrays.stream(LocalExerciseManager.INSTANCE.getExercises()).toList();

    private RandomWorkoutFactory(WorkoutFactoryOrder order) {
        numberOfExercises = order.numberOfExercises();
        repeatExercise = order.repeat();
    }

    public static AbstractWorkoutFactory getFactory(WorkoutFactoryOrder order) {
        return new RandomWorkoutFactory(order);
    }

    @Override
    public Workout create() {
        return buildWorkout(validExercises, numberOfExercises, repeatExercise);
    }
}
