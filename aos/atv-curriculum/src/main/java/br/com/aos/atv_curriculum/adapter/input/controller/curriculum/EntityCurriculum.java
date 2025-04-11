package br.com.aos.atv_curriculum.adapter.input.controller;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class CurriculumEntity {
    private String fullname;
    private String email;
    private String phoneNumber;
    private String description;

    public CurriculumEntity() {
    }
}
