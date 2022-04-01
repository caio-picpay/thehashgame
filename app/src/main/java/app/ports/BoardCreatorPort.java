package app.ports;

import thehashgame.entities.Board;
import thehashgame.entities.Mark;

public interface BoardCreatorPort {
    Board createBoard(Mark firstToPlay);
}
