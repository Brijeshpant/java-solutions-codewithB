package fp.calc;

import com.brij.fp.higherOrder.IdentityOp;
import com.brij.fp.calc.Operation;
import com.brij.fp.calc.QubeOp;
import com.brij.fp.calc.SquareOp;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class OperationTest {
    @Test
    public void shouldApplyOperations() {
        Operation operation = new Operation();
        IdentityOp identityOp = new IdentityOp();
        assertEquals(3, operation.sum(identityOp, 1, 2));
        assertEquals(9, operation.square(3));

        //sum of square of two nos  3,2 ==? 13

        int squareOfThree = operation.square(3);
        int squareOfTwo = operation.square(2);


        assertEquals(13, operation.sum(new SquareOp(), 3, 4));
        assertEquals(13, operation.sum(new QubeOp(), 3, 4));

    }


    /**
     *  scala
     *  def sum((fun:(a:int)=>int, int x, int y) {
     *      fun(x) +fun(y)
     *  }
     *
     *  sum( (a)=> a*a, 3,4)
     *  sum( (a)=> a*a*a, 3,4)
     *  //python
     *  def sum(func, a, b):
     * ...   return func(a) +func(b)
     *
     *
     * sum(lambda a: a*2, 3,4)
     */

}
