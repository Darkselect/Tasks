package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import model.enumeration.Gender;
import model.enumeration.MovementDirection;

import java.util.Objects;

import static model.constant.ConstantValuesObject.*;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class Fish extends Thread {
    private int fishId;
    private Gender gender;
    private int initialHp;
    private int lifeTime;
    private MovementDirection movementDirection;
    private int x;

    @Override
    public void run() {
        System.out.println(this + " is born!");

        while (initialHp++ < lifeTime) {
            System.out.println(this + " is moving!");

            X_TO_FISHES.get(this.x).remove(this);
            this.move();
            this.verifyDirectionAndCoordinates();
            X_TO_FISHES.get(this.x).add(this);

//            count number of partners; assume that each partner can create 1 fish
            long numOfPartners = X_TO_FISHES.get(this.x)
                    .stream()
                    .filter(otherFish -> {
                        final Gender expectedGenderOfThePartner = this.gender == Gender.MALE ? Gender.FEMALE : Gender.MALE;
                        return otherFish.gender == expectedGenderOfThePartner;
                    })
                    .count();

            if (numOfPartners == 0) {
                continue;
            }

            reproduce(numOfPartners);
        }

        X_TO_FISHES.get(this.x).remove(this);
        System.out.println(this + " is about to die!");
    }

    private void verifyDirectionAndCoordinates() {
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
//            prevent from OutOfMemoryError
            if (FISHES.size() >= MAX_FISHES_AMOUNT_ALLOWED) {
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
        return fishId == fish.fishId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fishId);
    }
}
