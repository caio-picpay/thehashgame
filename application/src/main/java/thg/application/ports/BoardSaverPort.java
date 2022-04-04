package thg.application.ports;

import thg.domain.entities.Board;

public interface BoardSaverPort {
    void saveBoard(final Board board);
}
