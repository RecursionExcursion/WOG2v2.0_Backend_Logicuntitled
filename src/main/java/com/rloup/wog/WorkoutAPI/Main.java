package com.rloup.wog.WorkoutAPI;

import com.rloup.wog.WorkoutAPI.workout.Workout;

public class Main {
    public static void main(String[] args) {

       WorkOutInterface workOutInterface = new WorkOutInterface();
        Workout workout = workOutInterface.getWorkout(5, null, null, true);
        Workout workout2 = workOutInterface.getRandomWorkout(5, null, null, true);
        System.out.println(workout);


    }
}
