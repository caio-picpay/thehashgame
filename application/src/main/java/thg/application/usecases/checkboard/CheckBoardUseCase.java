package thg.application.usecases.checkboard;

import lombok.AllArgsConstructor;
import thg.application.ports.BoardFinderPort;
import thg.application.usecases.UseCase;
import thg.domain.entities.Board;

@AllArgsConstructor
public class CheckBoardUseCase implements UseCase<CheckBoardInput, CheckBoardOutput> {

    private final BoardFinderPort boardFinder;

    @Override
    public CheckBoardOutput execute(CheckBoardInput input) {
        final Board board = boardFinder.findBoard(input.getBoardId()).orElseThrow();
        return CheckBoardOutput.builder()
                .board(board)
                .circleWins(board.isCircleWinner())
                .squareWins(board.isSquareWinner())
                .gameOver(board.gameIsOver())
                .build();
    }
}
