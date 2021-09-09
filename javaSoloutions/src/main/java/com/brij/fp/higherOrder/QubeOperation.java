package com.brij.fp.higherOrder;

public class QubeOperation implements Operation {
    @Override
    public int apply(int a) {
        return a*a*a;
    }
}
