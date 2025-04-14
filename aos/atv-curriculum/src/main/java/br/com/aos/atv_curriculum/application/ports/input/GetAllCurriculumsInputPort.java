package br.com.aos.atv_curriculum.application.ports.input;

import br.com.aos.atv_curriculum.application.core.domain.Curriculum;

import java.util.List;

public interface GetAllCurriculumsInputPort {

    List<Curriculum> getAll();
}
