package thg.application.usecases.findboards;

import lombok.AllArgsConstructor;
import thg.application.ports.BoardFinderPort;
import thg.application.usecases.UseCaseWithoutInput;
import thg.domain.entities.Board;

import java.util.List;

@AllArgsConstructor
public class FindBoardsUseCase implements UseCaseWithoutInput<List<Board>> {

    final BoardFinderPort boardFinder;

    @Override
    public List<Board> execute() {
        return boardFinder.findAll();
    }
}
