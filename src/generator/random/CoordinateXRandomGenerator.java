package generator.random;

import static model.constant.ConstantValuesObject.COORDINATE_X_MAX_VALUE;
import static model.constant.ConstantValuesObject.RANDOM;

public class CoordinateXRandomGenerator implements RandomGenerator<Integer> {
    @Override
    public Integer generate() {
        return RANDOM.ints(0, COORDINATE_X_MAX_VALUE)
                .findFirst()
                .getAsInt();
    }
}
