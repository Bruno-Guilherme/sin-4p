package br.com.aos.atv_curriculum.application.ports.input;

import java.util.Optional;

import br.com.aos.atv_curriculum.application.core.domain.Curriculum;

public interface GetCurriculumByIdInputPort {

    Optional<Curriculum> getById(Long id);
}
