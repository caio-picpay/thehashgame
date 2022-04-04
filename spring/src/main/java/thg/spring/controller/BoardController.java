package thg.spring.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thg.application.usecases.createboard.CreateBoardInput;
import thg.application.usecases.createboard.CreateBoardUseCase;
import thg.domain.entities.Board;

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
