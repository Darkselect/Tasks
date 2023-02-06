package generator.random;

import model.enumeration.Gender;

import static model.constant.ConstantValuesObject.RANDOM;

public class GenderRandomGenerator implements RandomGenerator<Gender> {
    @Override
    public Gender generate() {
        return RANDOM.nextBoolean() ? Gender.MALE : Gender.FEMALE;
    }
}
