package fp.higherOrder;

import com.brij.fp.higherOrder.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static junit.framework.TestCase.assertEquals;

public class MathsOperationsTest {
    SumUtils opeUtils;

    @Before
    public void setUp() {
        opeUtils = new SumUtils();
    }

    @Test
    public void shouldAddNos() {
//        assertEquals(5, opeUtils.sum(new IdentityOperation(), 3, 2));
        assertEquals(35, opeUtils.sum(a -> a, 3, 2));
    }

    @Test
    public void shouldGetSumOfSquareOfTwoNumbers() {
//        assertEquals(13, opeUtils.sum(new SquareOperation(), 3, 2));
        assertEquals(35, opeUtils.sum(a -> a * a, 3, 2));
    }

    @Test
    public void shouldGetSumOfQubesOfTwoNumbers() {
//        assertEquals(35, opeUtils.sum(new QubeOperation(), 3, 2));
        assertEquals(35, opeUtils.sum(a -> a * a * a, 3, 2));
    }

    @Test
    public void shouldGetSumOfDoubleOfTwoNumbers() {
        assertEquals(10, opeUtils.sum(a -> 2 * a, 3, 2));


    }


    @Test

    public void VerifyOtherFunctionalTypes() {

        BiFunction<Integer, Integer, String> sum = (a, b) -> Integer.toString(a + b);
        Consumer<String> print = System.out::println;
        print.accept("Hello");
        Supplier<String> sup = () -> "Hello world";
        System.out.println(sum.apply(1,2));
        System.out.println(sup.get());
        Predicate<Integer> testEven = a-> a%2==0;
        System.out.println(testEven.test(3));
        System.out.println(testEven.test(4));
    }
}
