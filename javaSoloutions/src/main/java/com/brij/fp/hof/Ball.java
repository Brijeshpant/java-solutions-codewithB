package com.brij.fp.hof;

import com.brij.fp.BallType;
import com.brij.fp.Colour;

import java.util.Random;
import java.util.StringJoiner;
import java.util.concurrent.ThreadLocalRandom;

public class Ball {
    private BallType type;
    private int size;
    private double weight;
    private com.brij.fp.Colour colour;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Ball(BallType type) {
        this.type = type;
        this.colour = Colour.WHITE;
        this.size = 10;
        this.weight = ThreadLocalRandom.current().nextDouble(10.0, 100.0);
    }

    public BallType getType() {
        return type;
    }

    public void setType(BallType type) {
        this.type = type;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Ball.class.getSimpleName() + "[", "]")
                .add("type=" + type)
                .add("size=" + size)
                .add("colour=" + colour)
                .toString();
    }
}
