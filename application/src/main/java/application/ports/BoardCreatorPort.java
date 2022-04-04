package application.ports;

import domain.entities.Board;
import domain.entities.Mark;

public interface BoardCreatorPort {
    Board createBoard(Mark firstToPlay);
}
