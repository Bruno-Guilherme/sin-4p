package br.com.aos.atv_curriculum.adapter.output.curriculum;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.aos.atv_curriculum.application.core.domain.Curriculum;
import br.com.aos.atv_curriculum.application.ports.output.curriculum.GetByIdCurriculumOutputPort;

@Component
public class GetByIdCurriculumAdapter implements GetByIdCurriculumOutputPort {

    private final RepositoryCurriculum curriculumRepository;
    private final MapperCurriculumEntity mapper;

    public GetByIdCurriculumAdapter(RepositoryCurriculum curriculumRepository, MapperCurriculumEntity mapper) {
        this.curriculumRepository = curriculumRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Curriculum> getById(Long id) {
        var entity = curriculumRepository.findById(id);

        return entity.map(mapper::toDomain); 
    }

}
