package com.rloup.wog.WorkoutAPI;

import com.rloup.wog.WorkoutAPI.exercise.Exercise;
import com.rloup.wog.WorkoutAPI.util.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;

public enum LocalExerciseManager {

    INSTANCE;

    private final JsonSerializer<Exercise[]> jsonSerializer;

    LocalExerciseManager() {
        URL reasourceUrl = getClass().getResource("/standard_ex/exercises.json");

        try {
            if (reasourceUrl == null) {
                throw new FileNotFoundException();
            }
            jsonSerializer = new JsonSerializer<>(new File(reasourceUrl.toURI()));
        } catch (URISyntaxException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Exercise[] getExercises() {
        return jsonSerializer.mapJsonToObject(Exercise[].class);
    }

    public void saveExercises(List<Exercise> exercises) {
        jsonSerializer.mapObjectToJson(listToArray(exercises));
    }

    //TODO delete method
    public void initialize() {
        List<Exercise> exs = ExerciseInit.init();
        jsonSerializer.mapObjectToJson(listToArray(exs));
    }

    private Exercise[] listToArray(List<Exercise> list) {
        Exercise[] exArr = new Exercise[list.size()];
        for (int i = 0; i < list.size(); i++) exArr[i] = list.get(i);
        return exArr;
    }

    private String getRelativePath() {
        return Paths.get("").toAbsolutePath().toString();
    }
}
