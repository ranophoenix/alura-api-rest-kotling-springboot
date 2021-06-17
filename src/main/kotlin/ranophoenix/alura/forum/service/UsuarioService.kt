package ranophoenix.alura.forum.service

import org.springframework.stereotype.Service
import ranophoenix.alura.forum.model.Usuario

@Service
class UsuarioService(private var usuarios: MutableList<Usuario> = mutableListOf<Usuario>()) {
    init {
        val usuario = Usuario(id = 1, nome = "Robert", email = "robert@teste.com")

        usuarios.add(usuario)
    }

    fun buscarPorId(id: Long): Usuario = usuarios.first { it.id == id }
}
