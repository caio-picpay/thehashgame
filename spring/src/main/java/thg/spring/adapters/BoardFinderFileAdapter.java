package thg.spring.adapters;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import thg.application.ports.BoardFinderPort;
import thg.domain.entities.Board;
import thg.spring.config.EnvConfig;
import thg.spring.exceptions.CantFindBoardException;
import thg.spring.mappers.JsonMapper;
import thg.spring.tools.FileTools;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class BoardFinderFileAdapter implements BoardFinderPort {

    final EnvConfig config;
    final FileTools fileTools;
    final JsonMapper jsonMapper;

    @Override
    public Optional<Board> findBoard(String boardId) {
        List<Board> boards = findAll();
        return findAll().stream().filter(it -> it.getId().equals(boardId)).findFirst();
    }

    private List<Board> findAll() {
        final String filePath = config.getBoardFilePath();
        try {
            fileTools.createIfDoesNotExist(filePath);
            final String fileContent = fileTools.read(filePath);
            if (fileContent == null || fileContent.isBlank()) return Collections.emptyList();
            return Arrays
                    .stream(fileContent.split("\n"))
                    .filter(it -> !it.isBlank())
                    .map(it -> jsonMapper.readValue(it, Board.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            throw new CantFindBoardException();
        }
    }
}
