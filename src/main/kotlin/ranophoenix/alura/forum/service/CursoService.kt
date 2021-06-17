package ranophoenix.alura.forum.service

import org.springframework.stereotype.Service
import ranophoenix.alura.forum.model.Curso

@Service
class CursoService(private var cursos:MutableList<Curso> = mutableListOf<Curso>()) {
   init {
       val curso = Curso(id = 1, nome = "Kotlin", categoria = "Programação")

       cursos.add(curso)
   }

   fun buscarPorId(id: Long): Curso = cursos.first { it.id == id }
}