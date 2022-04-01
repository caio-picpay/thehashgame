package app.ports;

import thehashgame.entities.Board;

import java.util.Optional;

public interface BoardFinderPort {
    Optional<Board> findBoard(String boardId);
}
