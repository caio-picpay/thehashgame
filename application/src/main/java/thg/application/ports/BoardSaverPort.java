package thg.application.ports;

import thg.domain.entities.Board;

public interface BoardSaverPort {
    Board saveBoard(final Board board);
}
