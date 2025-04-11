package br.com.aos.atv_curriculum.adapter.input.controller;

public class CurriculumMapper {
    public CurriculumEntity toEntity(RequestCurriculumDTO dto) {
        var entity = new CurriculumEntity();
        entity.setFullname(dto.fullname());
        entity.setEmail(dto.email());
        entity.setPhoneNumber(dto.phoneNumber());
        entity.setDescription(dto.description());
        return entity;
    }

    public Curriculum toDomain(RequestCurriculumDTO dto) {
        var domain = new Curriculum();

        domain.setFullname(dto.fullname());
        domain.setEmail(dto.email());
        domain.setPhoneNumber(dto.phoneNumber());
        domain.setDescription(dto.description());
    }
}
