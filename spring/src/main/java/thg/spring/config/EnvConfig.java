package thg.spring.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class EnvConfig {

    final String boardFilePath;

    public EnvConfig(
            @Value("${app.board.file}")
            final String boardFilePath
    ) {
        this.boardFilePath = boardFilePath;
    }
}
