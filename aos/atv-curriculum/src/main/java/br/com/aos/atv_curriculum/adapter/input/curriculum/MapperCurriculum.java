package br.com.aos.atv_curriculum.adapter.input.curriculum;

import br.com.aos.atv_curriculum.application.core.domain.Curriculum;

public class MapperCurriculum {
    public Curriculum toDomain(RequestCurriculumDTO dto) {
        var domain = new Curriculum();

        domain.setFullname(dto.fullname());
        domain.setEmail(dto.email());
        domain.setPhoneNumber(dto.phoneNumber());
        domain.setDescription(dto.description());

        return domain;
    }
}
