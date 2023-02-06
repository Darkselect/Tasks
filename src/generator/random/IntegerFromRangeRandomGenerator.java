package generator.random;

import static model.constant.ConstantValuesObject.RANDOM;

public class IntegerFromRangeRandomGenerator {
    public Integer generate(int start, int end) {
        return RANDOM.ints(start, end)
                .findFirst()
                .getAsInt();
    }
}
