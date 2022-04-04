package domain.spring.controller;

import app.usecases.createboard.CreateBoardInput;
import app.usecases.createboard.CreateBoardUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import domain.entities.Board;

@RestController
@RequestMapping("/board")
@AllArgsConstructor
public class BoardController {

    private final CreateBoardUseCase createBoardUseCase;

    @PostMapping
    public Board createBoard(@RequestBody CreateBoardInput input) {
        return createBoardUseCase.execute(input);
    }
}
