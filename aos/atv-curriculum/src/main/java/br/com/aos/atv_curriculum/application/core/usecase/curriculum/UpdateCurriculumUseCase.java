package br.com.aos.atv_curriculum.application.core.usecase.curriculum;

import br.com.aos.atv_curriculum.application.core.domain.Curriculum;
import br.com.aos.atv_curriculum.application.ports.input.UpdateCurriculumInputPort;
import br.com.aos.atv_curriculum.application.ports.output.curriculum.GetByIdCurriculumOutputPort;
import br.com.aos.atv_curriculum.application.ports.output.curriculum.UpdateCurriculumOutputPort;

public class UpdateCurriculumUseCase implements UpdateCurriculumInputPort {

    private final GetByIdCurriculumOutputPort getByIdCurriculumOutputPort;
    private final UpdateCurriculumOutputPort repository;

    public UpdateCurriculumUseCase(GetByIdCurriculumOutputPort getByIdCurriculumOutputPort, UpdateCurriculumOutputPort repository) {
        this.repository = repository;
        this.getByIdCurriculumOutputPort = getByIdCurriculumOutputPort;
    }

    @Override
    public void update(Curriculum curriculum) {
        getByIdCurriculumOutputPort.getById(curriculum.getId())
                .orElseThrow(() -> new IllegalArgumentException("Curriculum not found"));
        repository.update(curriculum);
    }
}