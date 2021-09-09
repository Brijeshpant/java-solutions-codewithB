package com.brij.fp.higherOrder;

import java.util.function.BiFunction;
import java.util.function.Function;

public class SumUtils {
//    public int sum(Operation op, int a, int b) {
//        return op.apply(a) + op.apply(b);
//    }

    public int sum(Function<Integer, Integer> op, int a, int b) {
        return op.apply(a) + op.apply(b);
    }

}
