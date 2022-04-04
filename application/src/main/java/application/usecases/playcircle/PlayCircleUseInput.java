package application.usecases.playcircle;

import lombok.Data;
import domain.entities.Mark;

@Data
public class PlayCircleUseInput {
    private final String boardId;
    private final int position;
    private final Mark mark;
}
