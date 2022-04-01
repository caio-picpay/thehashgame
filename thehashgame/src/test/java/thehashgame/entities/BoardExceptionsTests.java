package thehashgame.entities;

import thehashgame.exceptions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardExceptionsTests {

    @Test
    void whenMarkIsNull_shouldThrowInvalidMarkException() {
        Assertions.assertThrows(InvalidMarkException.class, () -> new Board(Mark.SQUARE).put(null, 0));
    }

    @Test
    void whenPositionIsLessThanZero_shouldThrowInvalidPositionException() {
        Assertions.assertThrows(InvalidPositionException.class, () -> new Board(Mark.SQUARE).put(Mark.SQUARE, -1));
    }

    @Test
    void whenPositionIsGreaterThan8_shouldThrowInvalidPositionException() {
        Assertions.assertThrows(InvalidPositionException.class, () -> new Board(Mark.SQUARE).put(Mark.SQUARE, 9));
    }

    @Test
    void whenCircleWinsAndSquarePlays_gameShouldBeOver() {
        final Board board = new Board(Mark.CIRCLE)
                .put(Mark.CIRCLE, 0)
                .put(Mark.SQUARE, 3)
                .put(Mark.CIRCLE, 1)
                .put(Mark.SQUARE, 4)
                .put(Mark.CIRCLE, 2);
        Assertions.assertTrue(board.isCircleWinner());
        Assertions.assertThrows(TheGameIsAlreadyOverException.class, () -> board.put(Mark.SQUARE, 6));
    }

    @Test
    void whenSquareWinsAndSquarePlays_gameShouldBeOver() {
        final Board board = new Board(Mark.SQUARE)
                .put(Mark.SQUARE, 0)
                .put(Mark.CIRCLE, 3)
                .put(Mark.SQUARE, 1)
                .put(Mark.CIRCLE, 4)
                .put(Mark.SQUARE, 2);
        Assertions.assertTrue(board.isSquareWinner());
        Assertions.assertThrows(TheGameIsAlreadyOverException.class, () -> board.put(Mark.CIRCLE, 6));
    }

    @Test
    void whenSquarePlaysAtTheSamePositionOfCircle_shouldThrowPositionAlreadyMarkedException() {
        final Board board = new Board(Mark.SQUARE).put(Mark.SQUARE, 0);
        Assertions.assertThrows(PositionAlreadyMarkedException.class, () -> board.put(Mark.CIRCLE, 0));
    }

    @Test
    void whenCirclePlaysAtTheSamePositionOfSquare_shouldThrowPositionAlreadyMarkedException() {
        final Board board = new Board(Mark.CIRCLE).put(Mark.CIRCLE, 1);
        Assertions.assertThrows(PositionAlreadyMarkedException.class, () -> board.put(Mark.SQUARE, 1));
    }

    @Test
    void whenCirclePlaysTwiceInARow_shouldThrowNotTurnOfCirclesException() {
        final Board board = new Board(Mark.CIRCLE).put(Mark.CIRCLE, 0);
        Assertions.assertThrows(NotTurnOfCirclesException.class, () -> board.put(Mark.CIRCLE, 1));
    }

    @Test
    void whenSquarePlaysTwiceInARow_shouldThrowNotTurnOfCirclesException() {
        final Board board = new Board(Mark.SQUARE).put(Mark.SQUARE, 0);
        Assertions.assertThrows(NotTurnOfSquaresException.class, () -> board.put(Mark.SQUARE, 1));
    }
}
