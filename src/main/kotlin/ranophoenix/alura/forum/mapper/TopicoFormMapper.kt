package ranophoenix.alura.forum.mapper

import org.springframework.stereotype.Component
import ranophoenix.alura.forum.dto.NovoTopicoForm
import ranophoenix.alura.forum.model.Topico
import ranophoenix.alura.forum.service.CursoService
import ranophoenix.alura.forum.service.UsuarioService

@Component
class TopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService,
) : Mapper<NovoTopicoForm, Topico> {
    override fun map(t: NovoTopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idAutor)
        )
    }

}
