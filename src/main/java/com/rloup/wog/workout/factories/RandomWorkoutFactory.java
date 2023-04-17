package com.rloup.wog.workout.factories;

import com.rloup.wog.MockExercises;
import com.rloup.wog.exercise.Exercise;
import com.rloup.wog.workout.Workout;

import java.util.List;

public class RandomWorkoutFactory implements AbstractWorkoutFactory {

    private final int numberOfExercises;
    private final boolean repeatExercise;

    List<Exercise> validExercises = MockExercises.MOCKEXERCISES;

    private RandomWorkoutFactory(WorkoutFactoryOrder order) {
        numberOfExercises = order.numberOfExercises();
        repeatExercise = order.repeat();
    }

    public static AbstractWorkoutFactory getFactory(WorkoutFactoryOrder order) {
        return new RandomWorkoutFactory(order);
    }

    @Override
    public Workout create() {
        return AbstractWorkoutFactory.buildWorkout(validExercises, numberOfExercises, repeatExercise);
    }
}
