package thg.application.usecases.createboard;

import lombok.AllArgsConstructor;
import lombok.Getter;
import thg.domain.entities.Mark;

@Getter
@AllArgsConstructor
public class CreateBoardInput {
    private final Mark firstToPlay;

    public CreateBoardInput() {
        this.firstToPlay = null;
    }
}
