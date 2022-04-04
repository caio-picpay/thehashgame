package application.usecases.checkboard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import domain.entities.Board;

@AllArgsConstructor
@Builder
public class CheckBoardOutput {
    private final Board board;
    private final boolean circleWins;
    private final boolean squareWins;
    private final boolean gameOver;
}
