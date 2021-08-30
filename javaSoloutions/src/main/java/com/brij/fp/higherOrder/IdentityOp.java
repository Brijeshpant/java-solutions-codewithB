package com.brij.fp.higherOrder;

import com.brij.fp.calc.MathcOp;

public class IdentityOp implements MathcOp {
    @Override
    public int apply(int a) {
        return a;
    }
}
