package br.com.aos.atv_curriculum.adapter.input.curriculum;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.aos.atv_curriculum.application.core.domain.Curriculum;

import br.com.aos.atv_curriculum.application.ports.input.CreateCurriculumPort;
import br.com.aos.atv_curriculum.application.ports.input.GetAllCurriculumsInputPort;
import br.com.aos.atv_curriculum.application.ports.input.GetByIdCurriculumsInputPort;
import br.com.aos.atv_curriculum.application.ports.input.CurriculumUpdateInputPort;
import br.com.aos.atv_curriculum.application.ports.input.DeleteCurriculumInputPort;

import java.util.List;

@RestController
@RequestMapping("/api/v1/curriculum")
public class CurriculumController {
    private final CreateCurriculumPort createCurriculumPort;
    private final GetAllCurriculumsInputPort getAllCurriculumsInputPort;
    private final GetByIdCurriculumsInputPort getByIdCurriculumsInputPort;
    private final CurriculumUpdateInputPort updateCurriculumPort;
    private final DeleteCurriculumInputPort deleteCurriculumPort;

    private final MapperCurriculum mapperCurriculum;

    public CurriculumController(
            CreateCurriculumPort createCurriculumPort,
            GetAllCurriculumsInputPort getAllCurriculumsInputPort,
            GetByIdCurriculumsInputPort getByIdCurriculumsInputPort,
            CurriculumUpdateInputPort updateCurriculumPort,
            DeleteCurriculumInputPort deleteCurriculumPort,
            MapperCurriculum mapperCurriculum) {
        this.createCurriculumPort = createCurriculumPort;
        this.getAllCurriculumsInputPort = getAllCurriculumsInputPort;
        this.getByIdCurriculumsInputPort = getByIdCurriculumsInputPort;
        this.updateCurriculumPort = updateCurriculumPort;
        this.deleteCurriculumPort = deleteCurriculumPort;
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
    public ResponseEntity<Curriculum> getById(@PathVariable Long id) {
        var curriculum = getByIdCurriculumsInputPort.getById(id);

        if (curriculum.isPresent()) {
            return ResponseEntity.ok(curriculum.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody RequestCurriculumDTO request) {
        var curriculumDomain = mapperCurriculum.toDomain(request);
        curriculumDomain.setId(id);
        updateCurriculumPort.update(curriculumDomain);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteCurriculumPort.delete(id);
        return ResponseEntity.noContent().build();
    }
}
