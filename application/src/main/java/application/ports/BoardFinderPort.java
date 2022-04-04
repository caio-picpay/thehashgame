package application.ports;

import domain.entities.Board;

import java.util.Optional;

public interface BoardFinderPort {
    Optional<Board> findBoard(String boardId);
}
