package thg.spring.adapters;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import thg.application.ports.BoardFinderPort;
import thg.application.ports.BoardSaverPort;
import thg.domain.entities.Board;
import thg.spring.config.EnvConfig;
import thg.spring.exceptions.CantSaveBoardException;
import thg.spring.mappers.JsonMapper;
import thg.spring.tools.FileTools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class BoardSaverFileAdapter implements BoardSaverPort {

    final FileTools fileTools;
    final EnvConfig config;
    final BoardFinderPort boardFinderPort;
    final JsonMapper jsonMapper;

    @Override
    public void saveBoard(final Board board) {
        final List<Board> updatedBoards = buildUpdatedBoards(board);
        final String dbFileContent = updatedBoards
                .stream()
                .map(jsonMapper::writeValueAsString)
                .collect(Collectors.joining("\n"));
        try {
            fileTools.write(config.getBoardFilePath(), dbFileContent);
        } catch (IOException e) {
            e.printStackTrace();
            throw new CantSaveBoardException();
        }
    }

    private List<Board> buildUpdatedBoards(final Board board) {
        final List<Board> boards = boardFinderPort.findAll();
        final boolean exists = boards.stream().anyMatch(it -> it.getId().equals(board.getId()));
        if (exists) {
            return boards
                    .stream()
                    .map(it -> it.getId().equals(board.getId()) ? board : it)
                    .collect(Collectors.toList());
        } else {
            var updatedBoards = new ArrayList<>(boards);
            updatedBoards.add(board);
            return updatedBoards;
        }
    }
}
