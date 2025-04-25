package br.com.aos.atv_curriculum.adapter.output.curriculum;

import org.springframework.stereotype.Component;

import br.com.aos.atv_curriculum.application.ports.output.curriculum.DeleteCurriculumOutputPort;

@Component
public class DeleteCurriculumAdapter implements DeleteCurriculumOutputPort {

    private final RepositoryCurriculum repository;

    public DeleteCurriculumAdapter(RepositoryCurriculum repository) {
        this.repository = repository;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}