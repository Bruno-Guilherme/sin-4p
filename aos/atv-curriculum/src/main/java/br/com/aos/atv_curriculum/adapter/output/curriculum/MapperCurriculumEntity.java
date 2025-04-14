package br.com.aos.atv_curriculum.adapter.output.curriculum;

import org.springframework.stereotype.Component;

import br.com.aos.atv_curriculum.application.core.domain.Curriculum;

@Component
public class MapperCurriculumEntity {
    
    public EntityCurriculum toEntity(Curriculum curriculum) {
        var entity = new EntityCurriculum();
        
        entity.setFullname(curriculum.getFullname());
        entity.setEmail(curriculum.getEmail());
        entity.setPhoneNumber(curriculum.getPhoneNumber());
        entity.setDescription(curriculum.getDescription());

        return entity;
    }

    public Curriculum toDomain(EntityCurriculum entity) {
        var curriculum = new Curriculum();

        curriculum.setId(entity.getId());
        curriculum.setFullname(entity.getFullname());
        curriculum.setEmail(entity.getEmail());
        curriculum.setPhoneNumber(entity.getPhoneNumber());
        curriculum.setDescription(entity.getDescription());

        return curriculum;
    }
}
