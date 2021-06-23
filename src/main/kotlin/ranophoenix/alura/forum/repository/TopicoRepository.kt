package ranophoenix.alura.forum.repository

import org.springframework.data.jpa.repository.JpaRepository
import ranophoenix.alura.forum.model.Topico

interface TopicoRepository : JpaRepository<Topico, Long> {
    fun findByCursoNome(nomeCursos: String): List<Topico>
}