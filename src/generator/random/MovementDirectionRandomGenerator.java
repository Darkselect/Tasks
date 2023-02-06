package generator.random;

import model.enumeration.MovementDirection;

import static model.constant.ConstantValuesObject.RANDOM;

public class MovementDirectionRandomGenerator implements RandomGenerator<MovementDirection> {
    @Override
    public MovementDirection generate() {
        return switch (RANDOM.ints(1, 2).findFirst().getAsInt()) {
            case 1 -> MovementDirection.LEFT;
            case 2 -> MovementDirection.RIGHT;
            case 3 -> MovementDirection.UP;
            default -> MovementDirection.DOWN;
        };
    }
}
