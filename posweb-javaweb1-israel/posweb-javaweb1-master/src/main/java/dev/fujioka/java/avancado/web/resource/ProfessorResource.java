package dev.fujioka.java.avancado.web.resource;

import dev.fujioka.java.avancado.web.dto.ProfessorDTO;
import dev.fujioka.java.avancado.web.model.Professor;
import dev.fujioka.java.avancado.web.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorResource {
    @Autowired
    private ProfessorService professorService;

    @PostMapping
    public ResponseEntity<ProfessorDTO> salvar(@RequestBody Professor professor) {
        return ResponseEntity.ok(professorService.salvar(professor));
    }

    @GetMapping
    public ResponseEntity<List<Professor>> getProfessores() {
        return ResponseEntity.ok(professorService.listarProfessores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> consultaPorId(@PathVariable int id) {
        return ResponseEntity.ok(professorService.consultarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Professor> deletePorId(@PathVariable int id) {
        professorService.excluir(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Professor> alterar(@RequestBody Professor professor) {
        return ResponseEntity.ok(professorService.alterar(professor));
    }

    @GetMapping("/like/{nome}")
    public ResponseEntity<List<Professor>> listarPorLike(@PathVariable String nome) {
        return ResponseEntity.ok(professorService.buscarProfessorLike(nome));
    }

    @GetMapping("/like/{disciplina}")
    public ResponseEntity<List<Professor>> listarDisciplina(@PathVariable String disciplina) {
        return ResponseEntity.ok(professorService.buscarDisciplinaLike(disciplina));
    }
}
