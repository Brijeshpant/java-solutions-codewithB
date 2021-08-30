package fp;

import com.brij.fp.higherOrder.User;
import org.junit.Test;

import java.util.function.Function;

public class DuplicateFunctionTest {
    @Test
    public void shouldTestTheDuplicate() {

        // sum of two no
        // Square of a number
        //qube if a number
        //sum of square of two no
        //square of sum of two no


        //define the structure outsource the computation

        User user = new User();

        user.getEmail();  //null
        user.setEmail("BP");
        user.getEmail(); // BP
        user.setEmail("test");
        user.getEmail(); //test



//        square(sum(1, 2));
//        sum(square(1), square(2));
//        sum(qube(1), qube(2));
//
//
//        System.out.println(sum(1, 2));
//        System.out.println(sum(4, 4));
//        System.out.println(square(sum(4, 4)));
//        System.out.println(square(sum(4, 4)));
//        System.out.println(doOp((Integer a) -> a * 2, 4));
//        System.out.println(doOp((Integer a) -> a * a, 4));
//        System.out.println(doOp((Integer a) -> a * a * a, 3));

    }

    int doOp(Function<Integer, Integer> func, int i) {
        return func.apply(i);
    }

    int square(int a) {
        return a * a;
    }

    int qube(int a) {
        return a * a * a;
    }

    int sum(int a, int b) {
        return a + b;
    }


}
