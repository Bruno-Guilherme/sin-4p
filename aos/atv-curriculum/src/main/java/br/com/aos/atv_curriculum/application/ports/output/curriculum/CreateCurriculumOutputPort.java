package br.com.aos.atv_curriculum.application.ports.output.curriculum;

import br.com.aos.atv_curriculum.application.core.domain.Curriculum;

public interface CreateCurriculumOutputPort {
    void create(Curriculum curriculum);
}
