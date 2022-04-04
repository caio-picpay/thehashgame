package thg.spring.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import thg.application.usecases.createboard.CreateBoardUseCase;
import thg.spring.adapters.BoardCreatorFileAdapter;

@Configuration
public class UseCasesContext {

    @Bean
    public CreateBoardUseCase createBoardUseCase(final BoardCreatorFileAdapter boardCreatorFileAdapter){
        return new CreateBoardUseCase(boardCreatorFileAdapter);
    }
}
