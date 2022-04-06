package thg.spring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import thg.application.usecases.checkboard.CheckBoardInput;
import thg.application.usecases.checkboard.CheckBoardOutput;
import thg.application.usecases.checkboard.CheckBoardUseCase;
import thg.application.usecases.createboard.CreateBoardInput;
import thg.application.usecases.createboard.CreateBoardUseCase;
import thg.application.usecases.findboards.FindBoardsUseCase;
import thg.application.usecases.playmark.PlayMarkUseCase;
import thg.application.usecases.playmark.PlayMarkUseInput;
import thg.domain.entities.Board;

import java.util.List;

@RestController
@RequestMapping("/board")
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BoardController {

    private final CreateBoardUseCase createBoardUseCase;
    private final CheckBoardUseCase checkBoardUseCase;
    private final PlayMarkUseCase playMarkUseCase;
    private final FindBoardsUseCase findBoardsUseCase;

    @GetMapping
    public List<Board> findBoards(){
        return findBoardsUseCase.execute();
    }

    @PostMapping
    public Board createBoard(@RequestBody CreateBoardInput input) {
        return createBoardUseCase.execute(input);
    }

    @GetMapping("/{boardId}")
    public CheckBoardOutput checkBoard(@PathVariable final String boardId) throws JsonProcessingException {
        return checkBoardUseCase.execute(new CheckBoardInput(boardId));
    }

    @PostMapping("/mark")
    public Board playMark(@RequestBody final PlayMarkUseInput input) {
        return this.playMarkUseCase.execute(input);
    }
}
