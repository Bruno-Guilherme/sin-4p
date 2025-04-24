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
    public GetByIdCurriculumUseCase getCurriculumByIdUseCase(
        GetByIdCurriculumAdapter getCurriculumByIdAdapter) {
        return new GetByIdCurriculumUseCase(getCurriculumByIdAdapter);
    }

    @Bean
    public UpdateCurriculumUseCase updateCurriculumUseCase(
            GetByIdCurriculumAdapter getByIdCurriculumAdapter,
            UpdateCurriculumAdapter updateCurriculumAdapter) {
        return new UpdateCurriculumUseCase(getByIdCurriculumAdapter, updateCurriculumAdapter);
    }

    @Bean
    public DeleteCurriculumUseCase deleteCurriculumUseCase(
            DeleteCurriculumAdapter deleteCurriculumAdapter) {
        return new DeleteCurriculumUseCase(deleteCurriculumAdapter);
    }
}
