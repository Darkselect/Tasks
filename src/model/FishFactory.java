package model;

import static model.constant.ConstantValuesObject.*;

public class FishFactory {
    public static Fish create() {
        return new Fish(
                FISH_ID_GENERATOR.getAndIncrement(),
                GENDER_RANDOM_GENERATOR.generate(),
                INITIAL_HP,
                LIFETIME_RANDOM_GENERATOR.generate(),
                MOVEMENT_DIRECTION_RANDOM_GENERATOR.generate(),
                COORDINATE_X_RANDOM_GENERATOR.generate()
        );
    }

    private FishFactory() {}
}
