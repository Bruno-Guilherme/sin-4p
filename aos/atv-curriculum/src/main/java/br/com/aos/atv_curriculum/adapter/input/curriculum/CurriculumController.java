package br.com.aos.atv_curriculum.adapter.input.curriculum;

import br.com.aos.atv_curriculum.application.core.domain.Curriculum;
import br.com.aos.atv_curriculum.application.ports.input.GetAllCurriculumsInputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.aos.atv_curriculum.application.ports.input.CreateCurriculumPort;

import java.util.List;

@RestController
@RequestMapping("/api/v1/curriculum")
public class CurriculumController {
    private final CreateCurriculumPort createCurriculumPort;
    private final GetAllCurriculumsInputPort getAllCurriculumsInputPort;

    private final MapperCurriculum mapperCurriculum;

    public CurriculumController(
            CreateCurriculumPort createCurriculumPort,
            GetAllCurriculumsInputPort getAllCurriculumsInputPort,
            MapperCurriculum mapperCurriculum) {
        this.createCurriculumPort = createCurriculumPort;
        this.getAllCurriculumsInputPort = getAllCurriculumsInputPort;
        this.mapperCurriculum = mapperCurriculum;
    }


    @PostMapping
    public ResponseEntity<Void> create(@RequestBody RequestCurriculumDTO request) {
        var curriculumDomain = mapperCurriculum.toDomain(request);
        createCurriculumPort.create(curriculumDomain);
        return ResponseEntity.ok().build();
    }

    /*
    * Pegar Todos os Curriculus
    *
    * 1. Solicita ao Service a lista de currículos
    *
    * */

    @GetMapping
    public ResponseEntity<List<Curriculum>> getAll() {
        var curriculums = getAllCurriculumsInputPort.getAll();

        return ResponseEntity.ok(curriculums);
    }
}
