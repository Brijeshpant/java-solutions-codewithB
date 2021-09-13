package fp.hof;

import com.brij.fp.BallType;
import com.brij.fp.Colour;
import com.brij.fp.hof.Ball;
import com.brij.fp.hof.Operations;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class HigherOrderOperationsTest {

    @Test
    public void shouldChangeTheColourOfBalls() {
        List<Ball> balls = asList(new Ball(BallType.TENNIS), new Ball(BallType.FOOT_BALL),
                new Ball(BallType.TENNIS), new Ball(BallType.FOOT_BALL));
        List<Ball> colouredBalls =  balls.stream().map(Operations::changeColour).collect(Collectors.toList());

        assertThat(colouredBalls)
                .allMatch(ball -> ball.getColour() == Colour.GREEN);

        assertThat(balls)
                .allMatch(ball -> ball.getColour() != Colour.GREEN);
    }

    @Test
    public void shouldGetAllTheColoursOfBalls() {
        Ball ball1 = new Ball(BallType.TENNIS);
        ball1.setColour(Colour.BLUE);
        Ball ball2 = new Ball(BallType.FOOT_BALL);
        ball2.setColour(Colour.BLUE);
        Ball ball3 = new Ball(BallType.TENNIS);
        ball3.setColour(Colour.WHITE);
        Ball ball4 = new Ball(BallType.FOOT_BALL);
        ball4.setColour(Colour.GREEN);
        List<Ball> balls = asList(ball1, ball2,
                ball3, ball4);


        List<Colour> colours = balls.stream().map(Ball::getColour).collect(Collectors.toList());

        assertThat(colours).contains(Colour.BLUE, Colour.BLUE, Colour.WHITE, Colour.GREEN);
    }
    @Test
    public void shouldGetUniqueColors() {
        Ball ball1 = new Ball(BallType.TENNIS);
        ball1.setColour(Colour.BLUE);
        Ball ball2 = new Ball(BallType.FOOT_BALL);
        ball2.setColour(Colour.BLUE);
        Ball ball3 = new Ball(BallType.TENNIS);
        ball3.setColour(Colour.WHITE);
        Ball ball4 = new Ball(BallType.FOOT_BALL);
        ball4.setColour(Colour.GREEN);
        List<Ball> balls = asList(ball1, ball2,
                ball3, ball4);

        Set<Colour> colours = balls.stream().map(Ball::getColour).collect(Collectors.toSet());
        assertThat(colours).hasSize(3);
        assertThat(colours).contains(Colour.BLUE, Colour.WHITE, Colour.GREEN);
    }

    @Test
    public void shouldChangeTheSizeOfBalls() {
        List<Ball> balls = asList(new Ball(BallType.TENNIS), new Ball(BallType.FOOT_BALL),
                new Ball(BallType.TENNIS), new Ball(BallType.FOOT_BALL));

        List<Ball> ballWithChangedSize = new ArrayList<>();
        assertThat(ballWithChangedSize)
                .allMatch(ball -> ball.getSize() == 20);
    }

    @Test
    public void shouldFilterTheBlueBalls() {
        Ball ball1 = new Ball(BallType.FOOT_BALL);
        ball1.setColour(Colour.BLUE);
        List<Ball> balls = asList(new Ball(BallType.TENNIS), ball1,
                new Ball(BallType.TENNIS), new Ball(BallType.FOOT_BALL));
        balls.forEach(System.out::println);
        List<Ball> blueBalls = balls.stream().filter(b-> b.getColour() == Colour.BLUE).collect(Collectors.toList());

        assertThat(blueBalls).containsExactly(ball1);
    }

    @Test
    public void shouldFilterFootballsAndChangeTheColor() {
        List<Ball> balls = asList(new Ball(BallType.TENNIS), new Ball(BallType.FOOT_BALL),
                new Ball(BallType.TENNIS), new Ball(BallType.FOOT_BALL));
        balls.forEach(System.out::println);


        List<Ball> filteredBalls = balls.stream().map(Operations::changeColour).filter(b-> b.getType() == BallType.FOOT_BALL).collect(Collectors.toList());
        assertThat(filteredBalls)
                .allMatch(ball -> ball.getType() == BallType.FOOT_BALL);
        assertThat(filteredBalls)
                .allMatch(ball -> ball.getColour() == Colour.GREEN);
    }

    @Test
    public void shouldApplyChangeOnElementInCollectionWithinCollection() {
        List<Ball> tennisBalls = Arrays.asList(new Ball(BallType.TENNIS), new Ball(BallType.TENNIS));
        List<Ball> footBalls = Arrays.asList(new Ball(BallType.FOOT_BALL), new Ball(BallType.FOOT_BALL));
        List<List<Ball>> listOfListOfBalls = Arrays.asList(tennisBalls, footBalls);
        Stream<List<Ball>> stream = listOfListOfBalls.stream();

       Stream<List<Ball>> streams = stream.map(balls -> balls.stream().map(Operations::changeColour).collect(Collectors.toList()));
       List<List<Ball>> ballsWithChangedColor = streams.collect(Collectors.toList());

        assertThat(ballsWithChangedColor.get(0))
                .allMatch(ball -> ball.getColour() == Colour.GREEN);
        assertThat(ballsWithChangedColor.get(0))
                .allMatch(ball -> ball.getType() == BallType.TENNIS);
        assertThat(ballsWithChangedColor.get(1))
                .allMatch(ball -> ball.getColour() == Colour.GREEN);
        assertThat(ballsWithChangedColor.get(1))
                .allMatch(ball -> ball.getType() == BallType.FOOT_BALL);
    }

    @Test
    public void shouldApplyChangeOnElementInCollectionWithinCollectionAndFlattenIt() {
        List<Ball> tennisBalls = Arrays.asList(new Ball(BallType.TENNIS), new Ball(BallType.TENNIS));
        List<Ball> footBalls = Arrays.asList(new Ball(BallType.FOOT_BALL), new Ball(BallType.FOOT_BALL));
        List<List<Ball>> listOfListOfBalls = Arrays.asList(tennisBalls, footBalls);
        List<Ball> flattenedBalls = listOfListOfBalls.stream().flatMap(balls -> balls.stream().map(Operations::changeColour)).collect(Collectors.toList());

        assertThat(flattenedBalls)
                .allMatch(ball -> ball.getColour() == Colour.GREEN);
    }


}
