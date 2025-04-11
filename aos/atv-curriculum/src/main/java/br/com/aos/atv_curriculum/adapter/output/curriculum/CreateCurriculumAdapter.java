package br.com.aos.atv_curriculum.adapter.output.curriculum;

import org.springframework.stereotype.Component;

import br.com.aos.atv_curriculum.application.core.domain.Curriculum;
import br.com.aos.atv_curriculum.application.ports.output.curriculum.CreateCurriculumOutputPort;

@Component
public class CreateCurriculumAdapter implements CreateCurriculumOutputPort{

    public final RepositoryCurriculum repositoryCurriculum;

    public final MapperCurriculumEntity mapperCurriculumEntity;
    
    public CreateCurriculumAdapter(RepositoryCurriculum repositoryCurriculum,
            MapperCurriculumEntity mapperCurriculumEntity) {
        this.repositoryCurriculum = repositoryCurriculum;
        this.mapperCurriculumEntity = mapperCurriculumEntity;
    }

    @Override
    public void create(Curriculum curriculum) {
        var entity = mapperCurriculumEntity.toEntity(curriculum);

        repositoryCurriculum.save(entity);
    }

}
