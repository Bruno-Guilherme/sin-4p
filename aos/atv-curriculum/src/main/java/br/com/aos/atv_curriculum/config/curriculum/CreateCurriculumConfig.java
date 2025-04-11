package br.com.aos.atv_curriculum.config.curriculum;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.aos.atv_curriculum.adapter.output.curriculum.CreateCurriculumAdapter;
import br.com.aos.atv_curriculum.application.core.usecase.curriculum.CreateCurriculumUseCase;

@Configuration
public class CreateCurriculumConfig {
    
    @Bean
    public CreateCurriculumUseCase createCurriculumUseCase(
        CreateCurriculumAdapter repositoryCurriculum
    ) {
        return new CreateCurriculumUseCase(repositoryCurriculum);
    }
}
