package thehashgame.spring.context;

import app.usecases.createboard.CreateBoardUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import thehashgame.spring.adapters.BoardCreatorFileAdapter;

@Configuration
public class UseCasesContext {

    @Bean
    public CreateBoardUseCase createBoardUseCase(final BoardCreatorFileAdapter boardCreatorFileAdapter){
        return new CreateBoardUseCase(boardCreatorFileAdapter);
    }
}
