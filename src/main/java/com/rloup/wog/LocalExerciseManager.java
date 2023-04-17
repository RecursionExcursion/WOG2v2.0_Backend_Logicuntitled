package com.rloup.wog;

import com.rloup.wog.exercise.Exercise;
import com.rloup.wog.util.JsonSerializer;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LocalExerciseManager {

    private final File file = new File(getRelativePath() + "/src/main/resources/standard_ex/exercises.json");

    private final JsonSerializer<Exercise[]> jsonSerializer = new JsonSerializer<>(file);

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

    private Exercise[] listToArray(List<Exercise> list){
        Exercise[] exArr = new Exercise[list.size()];
        for (int i = 0; i < list.size(); i++) exArr[i] = list.get(i);
        return exArr;
    }

    private String getRelativePath(){
        Path currentRelativePath = Paths.get("");
        return currentRelativePath.toAbsolutePath().toString();
    }
}
