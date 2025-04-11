package br.com.aos.atv_curriculum.adapter.input.curriculum;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aos.atv_curriculum.application.ports.input.CreateCurriculumPort;

@RestController
@RequestMapping("/api/v1/curriculum")
public class CurriculumController {
    private final CreateCurriculumPort createCurriculumPort;
    
    private final MapperCurriculum mapperCurriculum;

    public CurriculumController(CreateCurriculumPort createCurriculumPort, MapperCurriculum mapperCurriculum) {
        this.createCurriculumPort = createCurriculumPort;
        this.mapperCurriculum = mapperCurriculum;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody RequestCurriculumDTO request) {
        var curriculumDomain = mapperCurriculum.toDomain(request);
        createCurriculumPort.create(curriculumDomain);
        return ResponseEntity.ok().build();
    }
}
