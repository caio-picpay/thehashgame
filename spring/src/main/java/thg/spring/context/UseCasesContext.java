package thg.spring.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import thg.application.usecases.checkboard.CheckBoardUseCase;
import thg.application.usecases.createboard.CreateBoardUseCase;
import thg.application.usecases.playmark.PlayMarkUseCase;
import thg.spring.adapters.BoardCreatorFileAdapter;
import thg.spring.adapters.BoardFinderFileAdapter;
import thg.spring.adapters.BoardSaverFileAdapter;

@Configuration
public class UseCasesContext {

    @Bean
    public CreateBoardUseCase createBoardUseCase(final BoardCreatorFileAdapter boardCreatorFileAdapter) {
        return new CreateBoardUseCase(boardCreatorFileAdapter);
    }

    @Bean
    public CheckBoardUseCase checkBoardUseCase(final BoardFinderFileAdapter boardFinderFileAdapter) {
        return new CheckBoardUseCase(boardFinderFileAdapter);
    }

    @Bean
    public PlayMarkUseCase playMarkUseCase(
            final BoardFinderFileAdapter boardFinderFileAdapter,
            final BoardSaverFileAdapter boardSaverFileAdapter
    ) {
        return new PlayMarkUseCase(
                boardFinderFileAdapter,
                boardSaverFileAdapter
        );
    }
}
