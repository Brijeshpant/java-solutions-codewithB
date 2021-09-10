package com.brij.fp.hof;

import com.brij.fp.Colour;

public class Operations {
    public static Ball changeColour(Ball b) {
        Ball ball = new Ball(b.getType());
        ball.setColour(Colour.GREEN);
        return ball;
    }
    public static Ball changeSize(Ball b) {
        Ball ball = new Ball(b.getType());
        ball.setSize(b.getSize()*2);
        return ball;
    }
}
