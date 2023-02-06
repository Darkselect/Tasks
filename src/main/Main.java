package main;

import model.Fish;

import static java.util.Objects.isNull;
import static model.constant.ConstantValuesObject.*;

public class Main {
    public static void main(String[] args) {
        AQUARIUM_INITIALIZER.initialize();

        long programStartTimeStamp = System.currentTimeMillis();

        while (true) {
            if (System.currentTimeMillis() - programStartTimeStamp >= MILLI_TIME_ALLOWED_TO_PROCESS_THE_FISHES) {
                return ;
            }

            Fish fish = FISHES.poll();

            if (isNull(fish)) {
                continue;
            }

            fish.setName("Fish " + fish.getFishId() + " thread");
            fish.start();
        }
    }
}