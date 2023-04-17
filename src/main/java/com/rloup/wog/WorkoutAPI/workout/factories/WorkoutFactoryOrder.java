package com.rloup.wog.WorkoutAPI.workout.factories;

import com.rloup.wog.WorkoutAPI.exercise.Equipment;
import com.rloup.wog.WorkoutAPI.exercise.Region;

import java.util.List;

public record WorkoutFactoryOrder(int numberOfExercises,
                                  List<Region> regions,
                                  List<Equipment> equipment,
                                  boolean repeat) {
}
