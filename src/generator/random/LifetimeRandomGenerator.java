package generator.random;

import static model.constant.ConstantValuesObject.*;

public class LifetimeRandomGenerator implements RandomGenerator<Integer> {
    @Override
    public Integer generate() {
        return RANDOM.ints(LIFETIME_START_VALUE, LIFETIME_END_VALUE)
                .findFirst()
                .getAsInt();
    }
}
