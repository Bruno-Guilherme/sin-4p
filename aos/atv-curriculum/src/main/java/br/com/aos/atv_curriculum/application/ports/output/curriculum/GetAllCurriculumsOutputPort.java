package br.com.aos.atv_curriculum.application.ports.output.curriculum;

import br.com.aos.atv_curriculum.application.core.domain.Curriculum;

import java.util.List;

public interface GetAllCurriculumsOutputPort {

    /**
     * Find all curriculums.
     *
     * @return a list of curriculums
     */
    List<Curriculum> findAll();
}
