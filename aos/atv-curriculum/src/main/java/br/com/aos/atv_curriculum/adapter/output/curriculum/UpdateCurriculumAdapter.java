package br.com.aos.atv_curriculum.adapter.output.curriculum;

import org.springframework.stereotype.Component;

import br.com.aos.atv_curriculum.application.core.domain.Curriculum;
import br.com.aos.atv_curriculum.application.ports.output.curriculum.UpdateCurriculumOutputPort;

@Component
public class UpdateCurriculumAdapter implements UpdateCurriculumOutputPort {

    private final RepositoryCurriculum repository;
    private final MapperCurriculumEntity mapper;

    public UpdateCurriculumAdapter(RepositoryCurriculum repository, MapperCurriculumEntity mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void update(Curriculum curriculum) {
        repository.findById(curriculum.getId())
            .map(entity -> {
                entity.setDescription(curriculum.getDescription());
                entity.setEmail(curriculum.getEmail());
                entity.setFullname(curriculum.getFullname());
                entity.setPhoneNumber(curriculum.getPhoneNumber());

                return repository.save(entity);
            }).orElseThrow(() -> 
                new IllegalArgumentException("Curriculum not found with ID: " + curriculum.getId()));
    }
}