package br.com.aos.atv_curriculum.config.curriculum;

import br.com.aos.atv_curriculum.adapter.output.curriculum.*;
import br.com.aos.atv_curriculum.application.core.usecase.curriculum.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CurriculumConfig {

    @Bean
    public CreateCurriculumUseCase createCurriculumUseCase(
            CreateCurriculumAdapter createCurriculumAdapter) {
        return new CreateCurriculumUseCase(createCurriculumAdapter);
    }

    @Bean
    public GetAllCurriculumsUseCase getAllCurriculumsUseCase(
            GetAllCurriculumsAdapter getAllCurriculumsAdapter) {
        return new GetAllCurriculumsUseCase(getAllCurriculumsAdapter);
    }

    @Bean
    public GetByIdCurriculumUseCase getByIdCurriculumUseCase(
        GetByIdCurriculumAdapter getByIdCurriculumAdapter
    ) {
        return new GetByIdCurriculumUseCase(getByIdCurriculumAdapter);
    }

    @Bean
    public UpdateCurriculumUseCase updateCurriculumUseCase(GetByIdCurriculumAdapter getByIdCurriculumAdapter, UpdateCurriculumAdapter updateCurriculumAdapter) {
        return new UpdateCurriculumUseCase(getByIdCurriculumAdapter, updateCurriculumAdapter);
    }

    @Bean
    public DeleteCurriculumUseCase deleteCurriculumByIdUseCase(
        DeleteCurriculumAdapter deleteCurriculumdAdapter
    ) {
        return new DeleteCurriculumUseCase(deleteCurriculumdAdapter);
    }
}
