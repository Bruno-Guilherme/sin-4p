package br.com.aos.atv_curriculum.adapter.input.controller.;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/curriculum")
public class CurriculumController {
    private final CreateCurriculumPort createCurriculumPort;
    
    private final MapperCurriculum mapperCurriculum;

    public CurriculumController(CreateCurriculumPort createCurriculumPort, MapperCurriculum mapperCurriculum) {
        this.createCurriculumPort = createCurriculumPort;
        this.mapperCurriculum = mapperCurriculum;
    }

    @GetMapping
    public ResponseEntity<Void> create(@RequestBody RequestCurriculumDTO request) {
        var curriculumDomain = curriculumMapper.toDomain(request);
        createCurriculumPort.save(curriculumDomain);
        return ResponseEntity.ok().build();
    }
}
