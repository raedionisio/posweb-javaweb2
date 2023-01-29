package dev.fujioka.java.avancado.web.repository;

import dev.fujioka.java.avancado.web.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
    @Query("select p from Professor p order by p.nome ASC")
    public List<Professor> listarOrdenadoPorNome();

    public List<Professor> findAllByOrderByNomeAsc();

    @Query("select p from Professor p where p.nome like %:nome%")
    public List<Professor> buscarProfessorPorNomeLike(@Param("nome") String nome);

    @Query("select p from Professor p where p.disciplina like %:disciplina%")
    public List<Professor> buscarProfessorPorDisciplinaLike(@Param("disciplina") String disciplina);

    public Professor findByDisciplinaAndNome(String disciplina, String nome);
}
