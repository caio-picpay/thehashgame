package thg.application.usecases.playmark;

import lombok.Data;
import thg.domain.entities.Mark;

@Data
public class PlayMarkUseInput {
    private final String boardId;
    private final int position;
    private final Mark mark;

    public PlayMarkUseInput(){
        this.boardId = null;
        this.position = 0;
        this.mark = null;
    }
}
