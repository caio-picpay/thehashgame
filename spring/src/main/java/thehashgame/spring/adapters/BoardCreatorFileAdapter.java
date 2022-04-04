package domain.spring.adapters;

import app.ports.BoardCreatorPort;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import domain.entities.Board;
import domain.entities.Mark;
import domain.spring.exceptions.CantSaveBoardException;

import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class BoardCreatorFileAdapter implements BoardCreatorPort {

    final String BOARDS_JSON = "boards.json";

    @Override
    public Board createBoard(Mark firstToPlay) {
        final Board newBoard = new Board(firstToPlay);
        this.writeBoardToFile(newBoard);
        return newBoard;
    }

    private void writeBoardToFile(final Board board) {
        try {
            String boardsJson = Files.readString(Paths.get(BOARDS_JSON));
            String boardJson = new ObjectMapper().writeValueAsString(board);
            String newBoardsJson = boardJson + "\n" + boardsJson;
            Files.write(Paths.get(BOARDS_JSON), newBoardsJson.getBytes());
        } catch (Exception e) {
            throw new CantSaveBoardException();
        }
    }
}
