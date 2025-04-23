package br.com.aos.atv_curriculum.application.core.usecase.curriculum;

import java.util.Optional;

import br.com.aos.atv_curriculum.application.core.domain.Curriculum;
import br.com.aos.atv_curriculum.application.ports.input.GetCurriculumByIdInputPort;
import br.com.aos.atv_curriculum.application.ports.output.curriculum.GetCurriculumByIdOutputPort;

public class GetCurriculumByIdUseCase implements GetCurriculumByIdInputPort {

    private final GetCurriculumByIdOutputPort getCurriculumByIdOutputPort;

    public GetCurriculumByIdUseCase (GetCurriculumByIdOutputPort getCurriculumByIdOutputPort) {
        this.getCurriculumByIdOutputPort = getCurriculumByIdOutputPort;
    }

    @Override
    public Optional<Curriculum> getById(Long id) {
        return getCurriculumByIdOutputPort.getById(id);
    }
}
