package thg.application.ports;

import thg.domain.entities.Board;
import thg.domain.entities.Mark;

public interface BoardCreatorPort {
    Board createBoard(Mark firstToPlay);
}
