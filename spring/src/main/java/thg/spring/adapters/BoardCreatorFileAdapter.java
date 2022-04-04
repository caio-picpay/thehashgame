package thg.spring.adapters;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import thg.application.ports.BoardCreatorPort;
import thg.domain.entities.Board;
import thg.domain.entities.Mark;
import thg.spring.config.EnvConfig;
import thg.spring.exceptions.CantSaveBoardException;
import thg.spring.tools.FileTools;

@Component
@AllArgsConstructor
public class BoardCreatorFileAdapter implements BoardCreatorPort {

    final FileTools fileTools;
    final EnvConfig config;

    @Override
    public Board createBoard(Mark firstToPlay) {
        final Board newBoard = new Board(firstToPlay);
        this.writeBoardToFile(newBoard);
        return newBoard;
    }

    private void writeBoardToFile(final Board board) {
        final String filePath = config.getBoardFilePath();
        try {
            fileTools.createIfDoesNotExist(filePath);
            String fileContent = fileTools.read(filePath);
            String newRow = new ObjectMapper().writeValueAsString(board);
            String fileContentWithNewRow = newRow + "\n" + fileContent;
            fileTools.write(filePath, fileContentWithNewRow);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CantSaveBoardException();
        }
    }
}
