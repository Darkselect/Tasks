package model;

import lombok.AllArgsConstructor;
import lombok.ToString;
import model.enumeration.Gender;
import model.enumeration.MovementDirection;

import java.util.Objects;

import static model.constant.ConstantValuesObject.*;

@AllArgsConstructor
@ToString
public class Fish extends Thread {
    public int id;
    public Gender gender;
    public int initialHp;
    public int lifeTime;
    public MovementDirection movementDirection;
    public int x;

    @Override
    public void run() {
//        System.out.println("FISH_" + id + " is born!");
        System.out.println(this + " is born!");

        while (initialHp++ < lifeTime) {
//            System.out.println("FISH_" + id + " with hp: " + initialHp);
            System.out.println(this + " is moving!");

            X_TO_FISHES.get(this.x).remove(this);
            move();
            verifyDirection();
            X_TO_FISHES.get(this.x).add(this);

//            optimization:
//            e.g. if fish had 100 hp, it would try to reproduce itself 100 times. Instead, it would try it 20 times.
//            if (initialHp % 5 != 0) {
//                continue;
//            }

//            count number of partners; assume that each partner can create 1 fish
            long numOfPartners = X_TO_FISHES.get(this.x)
                    .stream()
                    .filter(fish -> fish.gender == (this.gender == Gender.MALE ? Gender.FEMALE : Gender.MALE))
                    .count();

            if (numOfPartners == 0) {
                continue;
            }

            reproduce(numOfPartners);
        }

        X_TO_FISHES.get(this.x).remove(this);
//        System.out.println("FISH_" + id + " is about to die!");
        System.out.println(this + " is about to die!");
    }

    private void verifyDirection() {
        if (this.x < 0 && this.movementDirection == MovementDirection.LEFT) {
            this.movementDirection = MovementDirection.RIGHT;
            x = 0;
        }
        else if (this.x > COORDINATE_X_MAX_VALUE && this.movementDirection == MovementDirection.RIGHT) {
            this.movementDirection = MovementDirection.LEFT;
            x = COORDINATE_X_MAX_VALUE;
        }
    }

    private void move() {
        switch (this.movementDirection) { // y-axis is not considered in this version
            case LEFT -> this.x--;
            case RIGHT -> this.x++;
        }
    }

    private void reproduce(long numOfPartners) {
        for (long i = 0; i < numOfPartners; i++) {
            if (FISHES.size() >= MAX_FISHES_AMOUNT) {
                return;
            }

            final Fish newFish = FishFactory.create();

            FISHES.add(newFish);
            X_TO_FISHES.get(newFish.x).add(newFish);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fish fish = (Fish) o;
        return id == fish.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
