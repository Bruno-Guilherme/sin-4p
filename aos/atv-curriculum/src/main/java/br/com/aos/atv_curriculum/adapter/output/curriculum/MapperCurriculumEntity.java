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
}
