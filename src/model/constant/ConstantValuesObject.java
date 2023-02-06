package model.constant;

import generator.random.*;
import initializer.AquariumInitializer;
import model.Fish;

import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ConstantValuesObject {
    public static final int COORDINATE_X_MAX_VALUE = 10;
    public static final int LIFETIME_START_VALUE = 19;
    public static final int LIFETIME_END_VALUE = 20;
    public static final int INITIAL_HP = 0;
    public static final int MAX_FISHES_AMOUNT_ALLOWED = 50;
    public static final long MILLI_TIME_ALLOWED_TO_PROCESS_THE_FISHES = 50;

    public static final Queue<Fish> FISHES = new ConcurrentLinkedDeque<>();
    public static final Map<Integer, Queue<Fish>> X_TO_FISHES = new ConcurrentHashMap<>();
    public static final AtomicInteger FISH_ID_GENERATOR = new AtomicInteger(0);

    public static final Random RANDOM = new Random();

    static {
        IntStream.range(0, COORDINATE_X_MAX_VALUE + 1)
                .forEach(x -> X_TO_FISHES.put(x, new ConcurrentLinkedDeque<>()));
    }

//    generators
    public static final IntegerFromRangeRandomGenerator INTEGER_FROM_RANGE_RANDOM_GENERATOR = new IntegerFromRangeRandomGenerator();
    public static final GenderRandomGenerator GENDER_RANDOM_GENERATOR = new GenderRandomGenerator();
    public static final LifetimeRandomGenerator LIFETIME_RANDOM_GENERATOR = new LifetimeRandomGenerator();
    public static final MovementDirectionRandomGenerator MOVEMENT_DIRECTION_RANDOM_GENERATOR = new MovementDirectionRandomGenerator();
    public static final CoordinateXRandomGenerator COORDINATE_X_RANDOM_GENERATOR = new CoordinateXRandomGenerator();
    public static final AquariumInitializer AQUARIUM_INITIALIZER = new AquariumInitializer();

    public static final AtomicInteger N = new AtomicInteger(INTEGER_FROM_RANGE_RANDOM_GENERATOR.generate(2, 3));
    public static final AtomicInteger M = new AtomicInteger(INTEGER_FROM_RANGE_RANDOM_GENERATOR.generate(2, 3));

    private ConstantValuesObject() {}
}
