package thg.application.usecases.createboard;

import lombok.AllArgsConstructor;
import thg.application.ports.BoardCreatorPort;
import thg.application.usecases.UseCase;
import thg.domain.entities.Board;

@AllArgsConstructor
public class CreateBoardUseCase implements UseCase<CreateBoardInput, Board> {

    final BoardCreatorPort boardCreator;

    @Override
    public Board execute(CreateBoardInput input) {
        return boardCreator.createBoard(input.getFirstToPlay());
    }
}
