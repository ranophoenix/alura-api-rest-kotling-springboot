package ranophoenix.alura.forum.repository

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import ranophoenix.alura.forum.dto.TopicoPorCategoriaDto
import ranophoenix.alura.forum.model.Topico

interface TopicoRepository : JpaRepository<Topico, Long> {
    fun findByCursoNome(nomeCursos: String, paginacao: Pageable): Page<Topico>

    @Query("SELECT new ranophoenix.alura.forum.dto.TopicoPorCategoriaDto(curso.categoria, count(t)) FROM Topico t JOIN t.curso curso GROUP BY curso.categoria")
    fun relatorio(): List<TopicoPorCategoriaDto>
}