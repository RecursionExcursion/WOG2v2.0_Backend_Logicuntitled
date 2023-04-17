package com.rloup.wog.WorkoutAPI;

import com.rloup.wog.WorkoutAPI.exercise.Equipment;
import com.rloup.wog.WorkoutAPI.exercise.Exercise;
import com.rloup.wog.WorkoutAPI.exercise.Region;
import com.rloup.wog.WorkoutAPI.workout.Workout;
import com.rloup.wog.WorkoutAPI.workout.factories.ParameterizedWorkoutWorkoutFactory;
import com.rloup.wog.WorkoutAPI.workout.factories.RandomWorkoutFactory;
import com.rloup.wog.WorkoutAPI.workout.factories.WorkoutFactoryOrder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WorkOutInterface {

    public Workout getWorkout(int numberOfExercises,
                              List<Region> regions,
                              List<Equipment> equipment,
                              boolean repeat) {
        WorkoutFactoryOrder order = new WorkoutFactoryOrder(numberOfExercises, regions, equipment, repeat);
        return ParameterizedWorkoutWorkoutFactory.getFactory(order).create();
    }

    public Workout getRandomWorkout(int numberOfExercises,
                                    List<Region> regions,
                                    List<Equipment> equipment,
                                    boolean repeat) {
        WorkoutFactoryOrder order = new WorkoutFactoryOrder(numberOfExercises, regions, equipment, repeat);
        return RandomWorkoutFactory.getFactory(order).create();
    }

    public void addExercise(Exercise exercise) {
        List<Exercise> exercises = Arrays.stream(LocalExerciseManager.INSTANCE.getExercises())
                                         .collect(Collectors.toList());
        exercises.add(exercise);
        LocalExerciseManager.INSTANCE.saveExercises(exercises);
    }
}
