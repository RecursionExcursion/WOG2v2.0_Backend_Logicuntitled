package com.rloup.wog.workout;

import com.rloup.wog.MockExercises;
import com.rloup.wog.exercise.Exercise;

import java.util.List;

public class RandomWorkoutWorkoutFactory implements AbstractWorkoutFactory {

    private final int numberOfExercises;
    private final boolean repeatExercise;

    List<Exercise> validExercises = MockExercises.MOCKEXERCISES;


    private RandomWorkoutWorkoutFactory(WorkoutFactoryOrder order) {
        numberOfExercises = order.numberOfExercises();
        repeatExercise = order.repeat();
    }

    public static AbstractWorkoutFactory getFactory(WorkoutFactoryOrder order) {
        return new RandomWorkoutWorkoutFactory(order);
    }

    @Override
    public Workout create() {
        return AbstractWorkoutFactory.buildWorkout(validExercises, numberOfExercises, repeatExercise);
    }
}
