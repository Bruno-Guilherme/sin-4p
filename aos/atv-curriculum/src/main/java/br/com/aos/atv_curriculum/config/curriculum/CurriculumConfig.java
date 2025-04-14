package br.com.aos.atv_curriculum.config.curriculum;

import br.com.aos.atv_curriculum.adapter.output.curriculum.GetAllCurriculumsAdapter;
import br.com.aos.atv_curriculum.application.core.usecase.curriculum.GetAllCurriculumsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.aos.atv_curriculum.adapter.output.curriculum.CreateCurriculumAdapter;
import br.com.aos.atv_curriculum.application.core.usecase.curriculum.CreateCurriculumUseCase;

@Configuration
public class CurriculumConfig {
    
    @Bean
    public CreateCurriculumUseCase createCurriculumUseCase(
        CreateCurriculumAdapter repositoryCurriculum
    ) {
        return new CreateCurriculumUseCase(repositoryCurriculum);
    }

    @Bean
    public GetAllCurriculumsUseCase getAllCurriculumsUseCase(
            GetAllCurriculumsAdapter getAllCurriculumsAdapter) {
        return new GetAllCurriculumsUseCase(getAllCurriculumsAdapter);
    }
}
