package thg.domain.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTests {

    @Test
    void whenCircleMarksFirstHorizontal_circlesShouldWin() {
        final Board finalBoard = new Board(Mark.CIRCLE)
                .put(Mark.CIRCLE, 0)
                .put(Mark.SQUARE, 3)
                .put(Mark.CIRCLE, 1)
                .put(Mark.SQUARE, 4)
                .put(Mark.CIRCLE, 2);
        System.out.println(finalBoard.getMarks());
        Assertions.assertTrue(finalBoard.isCircleWinner());
    }

    @Test
    void whenCircleMarksSecondHorizontal_circlesShouldWin() {
        final Board finalBoard = new Board(Mark.CIRCLE)
                .put(Mark.CIRCLE, 3)
                .put(Mark.SQUARE, 0)
                .put(Mark.CIRCLE, 4)
                .put(Mark.SQUARE, 1)
                .put(Mark.CIRCLE, 5);
        System.out.println(finalBoard.getMarks());
        Assertions.assertTrue(finalBoard.isCircleWinner());
    }

    @Test
    void whenCircleMarksThirdHorizontal_circlesShouldWin() {
        final Board finalBoard = new Board(Mark.CIRCLE)
                .put(Mark.CIRCLE, 6)
                .put(Mark.SQUARE, 0)
                .put(Mark.CIRCLE, 7)
                .put(Mark.SQUARE, 1)
                .put(Mark.CIRCLE, 8);
        System.out.println(finalBoard.getMarks());
        Assertions.assertTrue(finalBoard.isCircleWinner());
    }

    @Test
    void whenCircleMarksFirstVertical_circlesShouldWin() {
        final Board finalBoard = new Board(Mark.CIRCLE)
                .put(Mark.CIRCLE, 0)
                .put(Mark.SQUARE, 1)
                .put(Mark.CIRCLE, 3)
                .put(Mark.SQUARE, 2)
                .put(Mark.CIRCLE, 6);
        System.out.println(finalBoard.getMarks());
        Assertions.assertTrue(finalBoard.isCircleWinner());
    }

    @Test
    void whenCircleMarksSecondVertical_circlesShouldWin() {
        final Board finalBoard = new Board(Mark.CIRCLE)
                .put(Mark.CIRCLE, 1)
                .put(Mark.SQUARE, 2)
                .put(Mark.CIRCLE, 4)
                .put(Mark.SQUARE, 5)
                .put(Mark.CIRCLE, 7);
        System.out.println(finalBoard.getMarks());
        Assertions.assertTrue(finalBoard.isCircleWinner());
    }

    @Test
    void whenCircleMarksThirdVertical_circlesShouldWin() {
        final Board finalBoard = new Board(Mark.CIRCLE)
                .put(Mark.CIRCLE, 2)
                .put(Mark.SQUARE, 1)
                .put(Mark.CIRCLE, 5)
                .put(Mark.SQUARE, 4)
                .put(Mark.CIRCLE, 8);
        System.out.println(finalBoard.getMarks());
        Assertions.assertTrue(finalBoard.isCircleWinner());
    }

    @Test
    void whenCircleMarksFirstDiagonal_circlesShouldWin() {
        final Board finalBoard = new Board(Mark.CIRCLE)
                .put(Mark.CIRCLE, 0)
                .put(Mark.SQUARE, 1)
                .put(Mark.CIRCLE, 4)
                .put(Mark.SQUARE, 2)
                .put(Mark.CIRCLE, 8);
        System.out.println(finalBoard.getMarks());
        Assertions.assertTrue(finalBoard.isCircleWinner());
    }

    @Test
    void whenCircleMarksSecondDiagonal_circlesShouldWin() {
        final Board finalBoard = new Board(Mark.CIRCLE)
                .put(Mark.CIRCLE, 2)
                .put(Mark.SQUARE, 0)
                .put(Mark.CIRCLE, 4)
                .put(Mark.SQUARE, 1)
                .put(Mark.CIRCLE, 6);
        System.out.println(finalBoard.getMarks());
        Assertions.assertTrue(finalBoard.isCircleWinner());
    }
}
