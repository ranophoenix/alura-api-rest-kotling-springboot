package ranophoenix.alura.forum.mapper

import org.springframework.stereotype.Component
import ranophoenix.alura.forum.dto.TopicoView
import ranophoenix.alura.forum.model.Topico

@Component
class TopicoViewMapper : Mapper<Topico, TopicoView> {
    override fun map(t: Topico): TopicoView {
        return TopicoView(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            dataCriacao = t.dataCriacao,
            status = t.status
        )
    }

}