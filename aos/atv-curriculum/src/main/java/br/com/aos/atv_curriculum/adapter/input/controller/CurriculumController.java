package br.com.aos.atv_curriculum.adapter.input.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/curriculum")
public class CurriculumController {
    private final CurriculumRepository curriculumRepository;
    private final CurriculumMapper curriculumMapper;

    public CurriculumController(CurriculumRepository curriculumRepository, CurriculumMapper curriculumMapper) {
        this.curriculumRepository = curriculumRepository;
        this.curriculumMapper = curriculumMapper;
    }

    @GetMapping
    public ResponseEntity<Void> create(@RequestBody RequestCurriculumDTO request) {
        var curriculumEntity = curriculumMapper.toEntity(request);
        curriculumRepository.save(curriculumEntity);
        return ResponseEntity.ok().build();
    }
}
