package dev.fujioka.java.avancado.web.repository;

import dev.fujioka.java.avancado.web.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
    @Query("select c from Curso c order by c.nome ASC")
    public List<Curso> listarOrdenadoPorNome();

    public List<Curso> findAllByOrderByNomeAsc();

    @Query("select c from Curso c where c.nome like %:nome%")
    public List<Curso> buscarCursoPorNomeLike(@Param("nome") String curso);

    @Query("select c from Curso c where c.areaCurso like %:areaCurso%")
    public List<Curso> buscarCursoPorAreaCursoLike(@Param("areaCurso") String areaCurso);

    public Curso findByAreaCursoAndNome(String areaCurso, String nome);
}
