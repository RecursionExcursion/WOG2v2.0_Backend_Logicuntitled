package com.rloup.wog.WorkoutAPI.workout.factories;

import com.rloup.wog.WorkoutAPI.LocalExerciseManager;
import com.rloup.wog.WorkoutAPI.exercise.Exercise;
import com.rloup.wog.WorkoutAPI.exercise.Region;
import com.rloup.wog.WorkoutAPI.exercise.Equipment;
import com.rloup.wog.WorkoutAPI.workout.Workout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ParameterizedWorkoutWorkoutFactory implements AbstractWorkoutFactory {

    private final int numberOfExercises;
    private final List<Region> regions;
    private final List<Equipment> equipment;
    private final boolean repeatExercise;

    private ParameterizedWorkoutWorkoutFactory(WorkoutFactoryOrder order) {
        regions = order.regions();
        equipment = order.equipment();
        numberOfExercises = order.numberOfExercises();
        repeatExercise = order.repeat();
    }

    public static AbstractWorkoutFactory getFactory(WorkoutFactoryOrder order) {
        return new ParameterizedWorkoutWorkoutFactory(order);
    }

    @Override
    public Workout create() {

        Predicate<Exercise> containsRegion = ex -> {
            if (regions == null) return true;
            for (Region r : ex.getMuscleRegions()) {
                if (regions.contains(r)) return true;
            }
            return false;
        };
        Predicate<Exercise> requiresEquipment = ex -> {
            if (equipment == null) return true;
            for (Equipment e : ex.getEquipmentNeeded()) {
                if (equipment.contains(e)) return true;
            }
            return false;
        };

        List<Exercise> validExercises = Arrays.stream(LocalExerciseManager.INSTANCE.getExercises())
                                              .filter(containsRegion)
                                              .filter(requiresEquipment)
                                              .collect(Collectors.toCollection(ArrayList::new));

        return buildWorkout(validExercises, numberOfExercises, repeatExercise);
    }
}
