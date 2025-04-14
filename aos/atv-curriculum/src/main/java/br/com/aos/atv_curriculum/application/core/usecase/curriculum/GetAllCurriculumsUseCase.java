package br.com.aos.atv_curriculum.application.core.usecase.curriculum;

import br.com.aos.atv_curriculum.application.core.domain.Curriculum;
import br.com.aos.atv_curriculum.application.ports.input.GetAllCurriculumsInputPort;
import br.com.aos.atv_curriculum.application.ports.output.curriculum.GetAllCurriculumsOutputPort;

import java.util.List;

public class GetAllCurriculumsUseCase implements GetAllCurriculumsInputPort {
    GetAllCurriculumsOutputPort getAllCurriculumsOutputPort;

    public GetAllCurriculumsUseCase(GetAllCurriculumsOutputPort getAllCurriculumsOutputPort) {
        this.getAllCurriculumsOutputPort = getAllCurriculumsOutputPort;
    }

    @Override
    public List<Curriculum> getAll() {
        return getAllCurriculumsOutputPort.findAll();
    }
}
