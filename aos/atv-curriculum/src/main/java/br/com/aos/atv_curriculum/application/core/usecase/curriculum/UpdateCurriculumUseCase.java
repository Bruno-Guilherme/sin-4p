package br.com.aos.atv_curriculum.application.core.usecase.curriculum;

import br.com.aos.atv_curriculum.application.core.domain.Curriculum;
import br.com.aos.atv_curriculum.application.ports.input.CurriculumUpdateInputPort;
import br.com.aos.atv_curriculum.application.ports.output.curriculum.GetByIdCurriculumOutputPort;
import br.com.aos.atv_curriculum.application.ports.output.curriculum.UpdateCurriculumOutputPort;

public class UpdateCurriculumUseCase implements CurriculumUpdateInputPort {

    private final GetByIdCurriculumOutputPort getByIdCurriculumOutputPort;
    private final UpdateCurriculumOutputPort repository;

    public UpdateCurriculumUseCase(GetByIdCurriculumOutputPort getByIdCurriculumOutputPort, UpdateCurriculumOutputPort repository) {
        this.repository = repository;
        this.getByIdCurriculumOutputPort = getByIdCurriculumOutputPort;
    }

    @Override
    public void update(Curriculum curriculum) {
        var entity = getByIdCurriculumOutputPort.getById(curriculum.getId())
                .orElseThrow(() -> new IllegalArgumentException("Curriculum not found"));
        repository.update(curriculum);
    }
}