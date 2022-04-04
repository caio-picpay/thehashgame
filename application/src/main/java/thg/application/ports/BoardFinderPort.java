package thg.application.ports;

import thg.domain.entities.Board;

import java.util.Optional;

public interface BoardFinderPort {
    Optional<Board> findBoard(String boardId);
}
