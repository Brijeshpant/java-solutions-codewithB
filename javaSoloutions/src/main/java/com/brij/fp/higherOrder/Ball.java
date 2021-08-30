package com.brij.fp.higherOrder;

import java.util.StringJoiner;

public class Ball {
    private BallType type;
    private Colour colour;

    public Ball(BallType type) {
        this.type = type;
        this.colour = Colour.WHITE;
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

    @Override
    public String toString() {
        return new StringJoiner(", ", Ball.class.getSimpleName() + "[", "]")
                .add("type=" + type)
                .add("colour=" + colour)
                .toString();
    }

}
