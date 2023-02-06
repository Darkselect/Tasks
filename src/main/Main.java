package main;

import model.Fish;

import static java.util.Objects.isNull;
import static model.constant.ConstantValuesObject.AQUARIUM_INITIALIZER;
import static model.constant.ConstantValuesObject.FISHES;

public class Main {
    public static void main(String[] args) {
        AQUARIUM_INITIALIZER.initialize();

        long programStart = System.currentTimeMillis();

        while (true) {
            if (System.currentTimeMillis() - programStart >= 50) {
                return ;
            }

            Fish fish = FISHES.poll();

            if (isNull(fish)) {
                continue;
            }

            fish.setName("Fish " + fish.id + " thread");
            fish.start();
        }
    }
}