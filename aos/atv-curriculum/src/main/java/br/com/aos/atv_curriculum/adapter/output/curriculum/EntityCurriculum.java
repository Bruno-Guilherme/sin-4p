package br.com.aos.atv_curriculum.adapter.output.curriculum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_curriculum")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntityCurriculum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullname;
    private String email;
    private String phoneNumber;
    private String description;
}
