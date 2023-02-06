package generator.random;

@FunctionalInterface
public interface RandomGenerator<T> {
    T generate();
}
