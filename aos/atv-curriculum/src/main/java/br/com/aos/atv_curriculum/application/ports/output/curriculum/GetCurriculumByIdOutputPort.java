package br.com.aos.atv_curriculum.application.ports.output.curriculum;

import br.com.aos.atv_curriculum.application.core.domain.Curriculum;

import java.util.Optional;

public interface GetCurriculumByIdOutputPort {

    Optional<Curriculum> getById(Long id);
}
