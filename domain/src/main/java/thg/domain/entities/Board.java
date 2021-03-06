package thg.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import thg.domain.exceptions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static thg.domain.config.Config.VALID_POSITIONS;
import static thg.domain.config.Config.WIN_POSITIONS;

/**
 * The Hash Game
 * Positions:
 * 0 | 1 | 2
 * ---------
 * 3 | 4 | 5
 * ---------
 * 6 | 7 | 8
 */
@Getter
public class Board {

    private final String id;
    private final Mark turn;
    private final Map<Integer, Mark> marks;

    // required by ObjectMapper
    public Board() {
        this.id = null;
        this.turn = null;
        this.marks = null;
    }

    public Board(final String id, final Map<Integer, Mark> marks, final Mark turn) {
        this.id = id;
        this.marks = marks;
        this.turn = turn;
    }

    public Board(Mark firstTurn) {
        this.id = UUID.randomUUID().toString();
        marks = new HashMap<>();
        turn = firstTurn;
    }

    public HashMap<Integer, Mark> getMarks() {
        return (HashMap<Integer, Mark>) marks
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private boolean isWinner(final Mark mark) {
        return WIN_POSITIONS.stream().anyMatch(positions -> positions.stream().allMatch(position -> marks.get(position) == mark));
    }

    @JsonIgnore
    public boolean isCircleWinner() {
        return isWinner(Mark.CIRCLE);
    }

    @JsonIgnore
    public boolean isSquareWinner() {
        return isWinner(Mark.SQUARE);
    }

    @JsonIgnore
    public boolean isGameOver() {
        if (isCircleWinner() || isSquareWinner()) return true;
        return VALID_POSITIONS.stream().allMatch(p -> marks.get(p) != null);
    }

    public Board put(final Mark mark, int position) {
        if (isNull(mark) || !List.of(Mark.SQUARE, Mark.CIRCLE).contains(mark)) throw new InvalidMarkException();
        if (!VALID_POSITIONS.contains(position)) throw new InvalidPositionException();
        if (isGameOver()) throw new TheGameIsAlreadyOverException();
        if (marks.get(position) != null) throw new PositionAlreadyMarkedException();
        if (mark != turn && mark == Mark.CIRCLE) throw new NotTurnOfCirclesException();
        if (mark != turn && mark == Mark.SQUARE) throw new NotTurnOfSquaresException();
        final HashMap<Integer, Mark> nextMarks = getMarks();
        nextMarks.put(position, mark);
        final Mark nextTurn = mark == Mark.CIRCLE ? Mark.SQUARE : Mark.CIRCLE;
        return new Board(id, nextMarks, nextTurn);
    }
}
