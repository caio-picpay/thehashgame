package application.usecases.createboard;

import app.ports.BoardCreatorPort;
import app.usecases.UseCase;
import lombok.AllArgsConstructor;
import domain.entities.Board;

@AllArgsConstructor
public class CreateBoardUseCase implements UseCase<CreateBoardInput, Board> {

    final BoardCreatorPort boardCreator;

    @Override
    public Board execute(CreateBoardInput input) {
        return boardCreator.createBoard(input.getFirstToPlay());
    }
}
