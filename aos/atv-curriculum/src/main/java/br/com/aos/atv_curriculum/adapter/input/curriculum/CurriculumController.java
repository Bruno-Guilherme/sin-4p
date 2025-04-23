package br.com.aos.atv_curriculum.adapter.input.curriculum;

import br.com.aos.atv_curriculum.application.core.domain.Curriculum;
import br.com.aos.atv_curriculum.application.ports.input.GetAllCurriculumsInputPort;
import br.com.aos.atv_curriculum.application.ports.input.GetCurriculumByIdInputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.aos.atv_curriculum.application.ports.input.CreateCurriculumPort;

import java.util.List;

@RestController
@RequestMapping("/api/v1/curriculum")
public class CurriculumController {
    private final CreateCurriculumPort createCurriculumPort;
    private final GetAllCurriculumsInputPort getAllCurriculumsInputPort;
    private final GetCurriculumByIdInputPort getCurriculumByIdInputPort;

    private final MapperCurriculum mapperCurriculum;


    public CurriculumController(CreateCurriculumPort createCurriculumPort, GetAllCurriculumsInputPort getAllCurriculumsInputPort, GetCurriculumByIdInputPort getCurriculumByIdInputPort, MapperCurriculum mapperCurriculum) {
        this.createCurriculumPort = createCurriculumPort;
        this.getAllCurriculumsInputPort = getAllCurriculumsInputPort;
        this.getCurriculumByIdInputPort = getCurriculumByIdInputPort;
        this.mapperCurriculum = mapperCurriculum;
    }



    @PostMapping
    public ResponseEntity<Void> create(@RequestBody RequestCurriculumDTO request) {
        var curriculumDomain = mapperCurriculum.toDomain(request);
        createCurriculumPort.create(curriculumDomain);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Curriculum>> getAll() {
        var curriculums = getAllCurriculumsInputPort.getAll();

        return ResponseEntity.ok(curriculums);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curriculum> getById(@PathVariable("id") Long id) {
        //Solicitar o usuário pelo ID
        var curriculum = getCurriculumByIdInputPort.getById(id);

        // Verificar se o usuário existe.
        if (curriculum.isPresent()) {
            return ResponseEntity.ok(curriculum.get());
        }

        return ResponseEntity.notFound().build();
    }
}
