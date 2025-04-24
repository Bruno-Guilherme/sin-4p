package br.com.aos.atv_curriculum.application.ports.input;

import br.com.aos.atv_curriculum.application.core.domain.Curriculum;

public interface CurriculumUpdateInputPort {
    void update(Curriculum curriculum);
}