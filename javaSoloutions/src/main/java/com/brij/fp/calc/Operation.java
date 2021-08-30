package com.brij.fp.calc;

public class Operation {
    public int sum(MathcOp op,int a, int b) {
        return op.apply(a) + op.apply(b);
    }

    public int square(int a) {
        return a * a;
    }


}
