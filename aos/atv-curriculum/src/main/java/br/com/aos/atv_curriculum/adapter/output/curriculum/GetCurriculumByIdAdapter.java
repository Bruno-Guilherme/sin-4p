package br.com.aos.atv_curriculum.adapter.output.curriculum;

import br.com.aos.atv_curriculum.application.core.domain.Curriculum;
import br.com.aos.atv_curriculum.application.ports.output.curriculum.GetCurriculumByIdOutputPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetCurriculumByIdAdapter implements GetCurriculumByIdOutputPort {
    private final RepositoryCurriculum repositoryCurriculum;
    private final MapperCurriculumEntity mapperCurriculumEntity;

    public GetCurriculumByIdAdapter(RepositoryCurriculum repositoryCurriculum, MapperCurriculumEntity mapperCurriculumEntity) {
        this.repositoryCurriculum = repositoryCurriculum;
        this.mapperCurriculumEntity = mapperCurriculumEntity;
    }


    @Override
    public Optional<Curriculum> getById(Long id) {
        return repositoryCurriculum.findById(id)
                .map(mapperCurriculumEntity::toDomain);
    }
}