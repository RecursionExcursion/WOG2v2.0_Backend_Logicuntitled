package com.rloup.wog.workout;

import com.rloup.wog.MockExercises;
import com.rloup.wog.exercise.Equipment;
import com.rloup.wog.exercise.Exercise;
import com.rloup.wog.exercise.Region;

import java.util.ArrayList;
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

        List<Exercise> validExercises = MockExercises.MOCKEXERCISES.stream()
                                                                   .filter(containsRegion)
                                                                   .filter(requiresEquipment)
                                                                   .collect(Collectors.toCollection(ArrayList::new));

        return AbstractWorkoutFactory.buildWorkout(validExercises,numberOfExercises,repeatExercise);
    }
}
