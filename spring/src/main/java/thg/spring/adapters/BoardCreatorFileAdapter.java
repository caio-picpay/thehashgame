package thg.spring.adapters;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import thg.application.ports.BoardCreatorPort;
import thg.domain.entities.Board;
import thg.domain.entities.Mark;
import thg.spring.exceptions.CantSaveBoardException;
import thg.spring.tools.FileTools;

@Component
@AllArgsConstructor
public class BoardCreatorFileAdapter implements BoardCreatorPort {

    final FileTools fileTools;

    final String BOARDS_JSON = ".db/boards.json";

    @Override
    public Board createBoard(Mark firstToPlay) {
        final Board newBoard = new Board(firstToPlay);
        this.writeBoardToFile(newBoard);
        return newBoard;
    }

    private void writeBoardToFile(final Board board) {
        try {
            fileTools.createIfDoesNotExist(BOARDS_JSON);
            String fileContent = fileTools.read(BOARDS_JSON);
            String newRow = new ObjectMapper().writeValueAsString(board);
            String fileContentWithNewRow = newRow + "\n" + fileContent;
            fileTools.write(BOARDS_JSON, fileContentWithNewRow);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CantSaveBoardException();
        }
    }
}
