package thg.spring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import thg.application.usecases.checkboard.CheckBoardInput;
import thg.application.usecases.checkboard.CheckBoardOutput;
import thg.application.usecases.checkboard.CheckBoardUseCase;
import thg.application.usecases.createboard.CreateBoardInput;
import thg.application.usecases.createboard.CreateBoardUseCase;
import thg.domain.entities.Board;

@RestController
@RequestMapping("/board")
@AllArgsConstructor
public class BoardController {

    private final CreateBoardUseCase createBoardUseCase;
    private final CheckBoardUseCase checkBoardUseCase;

    @PostMapping
    public Board createBoard(@RequestBody CreateBoardInput input) {
        return createBoardUseCase.execute(input);
    }

    @GetMapping("/{boardId}")
    public CheckBoardOutput checkBoard(@PathVariable final String boardId) throws JsonProcessingException {
        return checkBoardUseCase.execute(new CheckBoardInput(boardId));
    }
}
