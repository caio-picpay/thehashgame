package application.ports;

import domain.entities.Board;

public interface BoardSaverPort {
    Board saveBoard(final Board board);
}
