package ranophoenix.alura.forum.service

import org.springframework.stereotype.Service
import ranophoenix.alura.forum.model.Curso
import ranophoenix.alura.forum.repository.CursoRepository

@Service
class CursoService(private val repository: CursoRepository) {

   fun buscarPorId(id: Long): Curso = repository.getById(id)
}