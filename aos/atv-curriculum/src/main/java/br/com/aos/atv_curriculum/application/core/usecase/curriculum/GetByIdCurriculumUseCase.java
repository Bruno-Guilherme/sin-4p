package br.com.aos.atv_curriculum.application.core.usecase.curriculum;

import java.util.Optional;

import br.com.aos.atv_curriculum.application.core.domain.Curriculum;
import br.com.aos.atv_curriculum.application.ports.input.GetByIdCurriculumsInputPort;
import br.com.aos.atv_curriculum.application.ports.output.curriculum.GetByIdCurriculumOutputPort;

public class GetByIdCurriculumUseCase implements GetByIdCurriculumsInputPort {
    private final GetByIdCurriculumOutputPort repository;

    public GetByIdCurriculumUseCase(GetByIdCurriculumOutputPort getByIdCurriculumsInputPort) {
        this.repository = getByIdCurriculumsInputPort;
    }

    @Override
    public Optional<Curriculum> getById(Long id) {
        return repository.getById(id);
    }
}
