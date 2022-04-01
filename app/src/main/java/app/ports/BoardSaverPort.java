package app.ports;

import thehashgame.entities.Board;

public interface BoardSaverPort {
    Board saveBoard(final Board board);
}
