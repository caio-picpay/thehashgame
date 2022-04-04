package thg.application.usecases.checkboard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import thg.domain.entities.Board;

@AllArgsConstructor
@Builder
@Getter
public class CheckBoardOutput {
    private final Board board;
    private final boolean circleWins;
    private final boolean squareWins;
    private final boolean gameOver;
}
