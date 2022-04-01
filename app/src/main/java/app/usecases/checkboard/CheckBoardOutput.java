package app.usecases.checkboard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import thehashgame.entities.Board;

@AllArgsConstructor
@Builder
public class CheckBoardOutput {
    private final Board board;
    private final boolean circleWins;
    private final boolean squareWins;
    private final boolean gameOver;
}
