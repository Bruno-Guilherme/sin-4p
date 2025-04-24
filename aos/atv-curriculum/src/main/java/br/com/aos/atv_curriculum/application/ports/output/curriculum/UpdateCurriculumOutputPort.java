package br.com.aos.atv_curriculum.application.ports.output.curriculum;

import br.com.aos.atv_curriculum.application.core.domain.Curriculum;

public interface UpdateCurriculumOutputPort {
    void update(Curriculum curriculum);
}