package app.usecases.playcircle;

import lombok.Data;
import thehashgame.entities.Mark;

@Data
public class PlayCircleUseInput {
    private final String boardId;
    private final int position;
    private final Mark mark;
}
