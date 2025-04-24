package br.com.aos.atv_curriculum.adapter.output.curriculum;

import br.com.aos.atv_curriculum.application.core.domain.Curriculum;
import br.com.aos.atv_curriculum.application.ports.output.curriculum.UpdateCurriculumOutputPort;

public class UpdateCurriculumAdapter implements UpdateCurriculumOutputPort {

    private final RepositoryCurriculum repository;
    private final MapperCurriculumEntity mapper;

    public UpdateCurriculumAdapter(RepositoryCurriculum repository, MapperCurriculumEntity mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void update(Curriculum curriculum) {
        if (repository.findById(curriculum.getId()).isPresent()) {
            var curriculumEntity = mapper.toEntity(curriculum);
            repository.save(curriculumEntity);
        } else {
            throw new IllegalArgumentException("Curriculum not found with ID: " + curriculum.getId());
        }
    }
}