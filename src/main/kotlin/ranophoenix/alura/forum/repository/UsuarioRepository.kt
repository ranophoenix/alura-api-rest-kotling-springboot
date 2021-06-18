package ranophoenix.alura.forum.repository

import org.springframework.data.jpa.repository.JpaRepository
import ranophoenix.alura.forum.model.Usuario

interface UsuarioRepository : JpaRepository<Usuario, Long> {
}