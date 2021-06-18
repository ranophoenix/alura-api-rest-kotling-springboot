package ranophoenix.alura.forum.service

import org.springframework.stereotype.Service
import ranophoenix.alura.forum.model.Usuario
import ranophoenix.alura.forum.repository.UsuarioRepository

@Service
class UsuarioService(private val repository: UsuarioRepository) {

    fun buscarPorId(id: Long): Usuario = repository.getById(id)
}
