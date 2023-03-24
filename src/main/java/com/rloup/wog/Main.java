package com.rloup.wog;

import com.rloup.wog.exercise.Equipment;
import com.rloup.wog.exercise.Exercise;
import com.rloup.wog.exercise.Region;
import com.rloup.wog.workout.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        WorkoutFactoryOrder order1 = new WorkoutFactoryOrder(3, List.of(Region.CHEST), null, true);
        WorkoutFactoryOrder order2 = new WorkoutFactoryOrder(5, null, List.of(Equipment.BODY_WEIGHT), false);

        Workout workout = ParameterizedWorkoutWorkoutFactory.getFactory(order1).create();
        Workout workout2 = ParameterizedWorkoutWorkoutFactory.getFactory(order2).create();
        Workout workout3 = RandomWorkoutWorkoutFactory.getFactory(order1).create();

        for (Exercise exercise : workout.getExercises()) {
            System.out.println(exercise.getName());
        }
        System.out.println();
        for (Exercise exercise : workout2.getExercises()) {
            System.out.println(exercise.getName());
        }
        System.out.println();
        for (Exercise exercise : workout3.getExercises()) {
            System.out.println(exercise.getName());
        }
    }
}
