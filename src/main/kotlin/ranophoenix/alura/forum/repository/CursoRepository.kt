package ranophoenix.alura.forum.repository

import org.springframework.data.jpa.repository.JpaRepository
import ranophoenix.alura.forum.model.Curso

interface CursoRepository : JpaRepository<Curso, Long> {
}