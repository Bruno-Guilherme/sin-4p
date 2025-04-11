package br.com.aos.atv_curriculum.application.core.usecase.curriculum;

import br.com.aos.atv_curriculum.application.core.domain.Curriculum;
import br.com.aos.atv_curriculum.application.ports.input.CreateCurriculumPort;
import br.com.aos.atv_curriculum.application.ports.output.curriculum.CreateCurriculumOutputPort;

public class CreateCurriculumUseCase implements CreateCurriculumPort {

    private final CreateCurriculumOutputPort repository;

    public CreateCurriculumUseCase(CreateCurriculumOutputPort repository) {
        this.repository = repository;
    }
    
    @Override
    public void create(Curriculum curriculum) {
        repository.create(curriculum);
    }

}
