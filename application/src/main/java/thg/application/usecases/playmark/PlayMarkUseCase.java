package thg.application.usecases.playmark;

import lombok.AllArgsConstructor;
import thg.application.ports.BoardFinderPort;
import thg.application.ports.BoardSaverPort;
import thg.application.usecases.UseCase;
import thg.domain.entities.Board;

@AllArgsConstructor
public class PlayMarkUseCase implements UseCase<PlayMarkUseInput, Board> {

    final BoardFinderPort boardFinder;
    final BoardSaverPort boardSaver;

    @Override
    public Board execute(PlayMarkUseInput input) {
        final Board board = boardFinder.findBoard(input.getBoardId()).orElseThrow();
        final Board boardChanged = board.put(input.getMark(), input.getPosition());
        boardSaver.saveBoard(boardChanged);
        return boardChanged;
    }
}
