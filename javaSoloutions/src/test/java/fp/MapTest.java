package fp;

import com.brij.fp.higherOrder.Ball;
import com.brij.fp.higherOrder.BallType;
import com.brij.fp.higherOrder.Colour;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class MapTest {
    @Test
    public void shouldTransform() {


        //Ball ==> Striped, Solid => Collor

    }


    @Test
    public void shouldMapBallsWithColor() {

        List<Ball> tennisBalls = Arrays.asList(new Ball(BallType.TENNIS), new Ball(BallType.TENNIS));
        List<Ball> footBalls = Arrays.asList(new Ball(BallType.FOOT_BALL), new Ball(BallType.FOOT_BALL));
        List<List<Ball>> listOfListOfBalls = Arrays.asList(tennisBalls, footBalls);

//        List<Ball> filteredBalls = listOfListOfBalls.stream().flatMap(f -> f.stream().filter(b -> b.getType() == BallType.FOOT_BALL).map(this::changeColour)).collect(Collectors.toList());
//
//        List<Ball> greenFootballs = filteredBalls.stream().filter(b -> b.getType() == BallType.FOOT_BALL)
//                .map(this::changeColour)
//                .collect(Collectors.toList());
//
//        List<Ball>  streamOfBalls = filteredBalls.stream().map(this::changeColour).collect(Collectors.toList());
////        Stream<Ball> colouredBallsStream = streamOfBalls.;
////        List<Ball> colouredBalls = colouredBallsStream.collect(Collectors.toList());
//
//
//        List<Ball> colouredBall = new ArrayList<>();
//
//        for (Ball ball:filteredBalls) {
//            Ball colourdBall = changeColour(ball);
//            colouredBall.add(colourdBall);
//        }


//        List<Ball> coloredBalls = filteredBalls.stream().map(this::changeColour).collect(Collectors.toList());

//        balls.stream().map(b -> b.getType().equals(BallType.SOLID) ? b : changeColor(b)).forEach(System.out::println);
//        balls.stream().filter(b-> b.getType().equals(BallType.SOLID)).map(b -> changeColor(b, Colour.BLUE)).forEach(System.out::println);
//
//        List<List<Ball>> listOfListOfBalls = Arrays.asList(Arrays.asList(new Ball(BallType.STRIP), new Ball(BallType.STRIP)), Arrays.asList(new Ball(BallType.SOLID), new Ball(BallType.SOLID)));
//        listOfListOfBalls.stream().map(b -> b.stream().map(s -> changeColor(s, Colour.BLUE)).collect(Collectors.toList())).collect(Collectors.toList()).forEach(System.out::println);
//        listOfListOfBalls.stream().flatMap(b -> b.stream().map(s -> changeColor(s, Colour.BLUE))).collect(Collectors.toList()).forEach(System.out::println);

//        filteredBalls.forEach(System.out::println);

        List<Ball> collect = tennisBalls.stream().peek(s -> s.setColour(Colour.BLUE)).collect(Collectors.toList());
        collect.forEach(System.out::println);
        tennisBalls.forEach(System.out::println);

    }

    private Ball changeColour(Ball b) {
        Ball ball = new Ball(b.getType());
        ball.setColour(Colour.GREEN);
        return ball;
    }
}
