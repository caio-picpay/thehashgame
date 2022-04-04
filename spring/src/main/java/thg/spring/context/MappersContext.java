package thg.spring.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import thg.spring.mappers.JsonMapper;

@Configuration
public class MappersContext {

    @Bean
    public JsonMapper jsonMapper() {
        return new JsonMapper();
    }
}
