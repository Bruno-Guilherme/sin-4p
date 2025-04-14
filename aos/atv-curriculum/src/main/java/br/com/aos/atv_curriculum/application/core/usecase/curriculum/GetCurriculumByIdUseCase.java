package br.com.aos.atv_curriculum.application.core.usecase.curriculum;

import br.com.aos.atv_curriculum.application.core.domain.Curriculum;
import br.com.aos.atv_curriculum.application.ports.input.GetCurriculumByIdInputPort;
import br.com.aos.atv_curriculum.application.ports.output.curriculum.GetCurriculumByIdOutputPort;
import br.com.aos.atv_curriculum.config.curriculum.exceptions.CurriculumNotFoundException;

public class GetCurriculumByIdUseCase implements GetCurriculumByIdInputPort {

    private final GetCurriculumByIdOutputPort getCurriculumByIdOutputPort;

    public GetCurriculumByIdUseCase (GetCurriculumByIdOutputPort getCurriculumByIdOutputPort) {
        this.getCurriculumByIdOutputPort = getCurriculumByIdOutputPort;
    }

    @Override
    public Curriculum getById(Long id) {
        return getCurriculumByIdOutputPort.getById(id)
                .orElseThrow(
                        () -> new CurriculumNotFoundException(
                                "Curriculum not found with id: " + id));
    }
}
