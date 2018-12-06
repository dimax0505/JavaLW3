package com.maximov.java3.Lesson1;

import java.util.ArrayList;
import java.util.Arrays;

class Race {
    private ArrayList<Stage> stages;
    ArrayList<Stage> getStages() { return stages; }
    Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }


}
