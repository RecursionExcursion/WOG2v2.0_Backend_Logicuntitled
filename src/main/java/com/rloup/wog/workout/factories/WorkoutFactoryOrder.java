package com.rloup.wog.workout.factories;

import com.rloup.wog.exercise.Equipment;
import com.rloup.wog.exercise.Region;

import java.util.List;

public record WorkoutFactoryOrder(int numberOfExercises,
                                  List<Region> regions,
                                  List<Equipment> equipment,
                                  boolean repeat) {
}
