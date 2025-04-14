package br.com.aos.atv_curriculum.adapter.output.curriculum;


import br.com.aos.atv_curriculum.application.core.domain.Curriculum;
import br.com.aos.atv_curriculum.application.ports.output.curriculum.GetAllCurriculumsOutputPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllCurriculumsAdapter implements GetAllCurriculumsOutputPort {

    private final RepositoryCurriculum repositoryCurriculum;
    private final MapperCurriculumEntity mapperCurriculumEntity;

    public GetAllCurriculumsAdapter(RepositoryCurriculum repositoryCurriculum, MapperCurriculumEntity mapperCurriculumEntity) {
        this.repositoryCurriculum = repositoryCurriculum;
        this.mapperCurriculumEntity = mapperCurriculumEntity;
    }

    @Override
    public List<Curriculum> findAll() {
        var curriculumsEntity = repositoryCurriculum.findAll();

        return curriculumsEntity.stream()
                .map(mapperCurriculumEntity::toDomain)
                .toList();
    }
}
