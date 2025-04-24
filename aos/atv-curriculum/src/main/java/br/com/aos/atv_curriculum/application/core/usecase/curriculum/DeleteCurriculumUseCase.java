package br.com.aos.atv_curriculum.application.core.usecase.curriculum;

import br.com.aos.atv_curriculum.application.ports.input.DeleteCurriculumInputPort;
import br.com.aos.atv_curriculum.application.ports.output.curriculum.DeleteCurriculumOutputPort;

public class DeleteCurriculumUseCase implements DeleteCurriculumInputPort {

    private final DeleteCurriculumOutputPort repository;

    public DeleteCurriculumUseCase(DeleteCurriculumOutputPort repository) {
        this.repository = repository;
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}