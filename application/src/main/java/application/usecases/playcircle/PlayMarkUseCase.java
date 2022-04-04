package application.usecases.playcircle;

import app.ports.BoardFinderPort;
import app.ports.BoardSaverPort;
import app.usecases.UseCase;
import lombok.AllArgsConstructor;
import domain.entities.Board;

@AllArgsConstructor
public class PlayMarkUseCase implements UseCase<PlayCircleUseInput, Board> {

    final BoardFinderPort boardFinder;
    final BoardSaverPort boardSaver;

    @Override
    public Board execute(PlayCircleUseInput input) {
        final Board board = boardFinder.findBoard(input.getBoardId()).orElseThrow();
        final Board boardChanged = board.put(input.getMark(), input.getPosition());
        boardSaver.saveBoard(boardChanged);
        return boardChanged;
    }
}
