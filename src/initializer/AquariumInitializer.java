package initializer;

import model.Fish;
import model.FishFactory;
import model.constant.ConstantValuesObject;
import model.enumeration.Gender;

import java.util.stream.IntStream;

import static model.constant.ConstantValuesObject.FISHES;
import static model.constant.ConstantValuesObject.X_TO_FISHES;

public class AquariumInitializer {

    public void initialize() {
        IntStream.range(0, ConstantValuesObject.N.get())
                .forEach(i -> {
                    Fish fish = FishFactory.create();
                    fish.setGender(Gender.MALE);

                    FISHES.add(fish);
                    X_TO_FISHES.get(fish.getX()).add(fish);
                });

        IntStream.range(0, ConstantValuesObject.M.get())
                .forEach(i -> {
                    Fish fish = FishFactory.create();
                    fish.setGender(Gender.FEMALE);

                    FISHES.add(fish);
                    X_TO_FISHES.get(fish.getX()).add(fish);
                });
    }
}
