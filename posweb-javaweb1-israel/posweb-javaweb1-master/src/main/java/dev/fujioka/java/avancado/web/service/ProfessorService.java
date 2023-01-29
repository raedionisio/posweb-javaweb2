package dev.fujioka.java.avancado.web.service;

import dev.fujioka.java.avancado.web.dto.ProfessorDTO;
import dev.fujioka.java.avancado.web.model.Curso;
import dev.fujioka.java.avancado.web.model.Professor;
import dev.fujioka.java.avancado.web.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private JmsTemplate jmsTemplate;

    public ProfessorDTO salvar(Professor professor) {
        professorRepository.save(professor);
        jmsTemplate.convertAndSend("professor_queue", professor);
        return ProfessorDTO.builder()
                .nome(professor.getNome())
                .disciplina(professor.getDisciplina())
                .build();
    }

    public List<Professor> listarProfessores() {
        return professorRepository.findAll();
    }

    public Professor consultarPorId(int id) {
        return professorRepository.findById(id).orElseThrow();
    }

    public void excluir(int id) {
        professorRepository.deleteById(id);
    }

    public Professor alterar(Professor professor) {
        if (Objects.isNull(professor.getId())) {
            throw new RuntimeException("id não preenchido");
        }
        return professorRepository.save(professor);
    }

    public List<Professor> buscarProfessorLike(String nome) {
        return professorRepository.buscarProfessorPorNomeLike(nome);
    }

    public List<Professor> buscarDisciplinaLike(String disciplina) {
        return professorRepository.buscarProfessorPorDisciplinaLike(disciplina);
    }
}
