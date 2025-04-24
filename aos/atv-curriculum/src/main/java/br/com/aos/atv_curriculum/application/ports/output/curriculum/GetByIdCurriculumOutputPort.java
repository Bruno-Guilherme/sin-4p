package br.com.aos.atv_curriculum.application.ports.output.curriculum;

import java.util.Optional;

import br.com.aos.atv_curriculum.application.core.domain.Curriculum;

public interface GetByIdCurriculumOutputPort {
    public Optional<Curriculum> getById(Long id);
}   
