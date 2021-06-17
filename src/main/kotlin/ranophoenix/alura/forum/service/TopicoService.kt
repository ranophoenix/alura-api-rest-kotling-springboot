package ranophoenix.alura.forum.service

import org.springframework.stereotype.Service
import ranophoenix.alura.forum.dto.AtualizacaoTopicoForm
import ranophoenix.alura.forum.dto.NovoTopicoForm
import ranophoenix.alura.forum.dto.TopicoView
import ranophoenix.alura.forum.exception.NotFoundException
import ranophoenix.alura.forum.mapper.TopicoFormMapper
import ranophoenix.alura.forum.mapper.TopicoViewMapper
import ranophoenix.alura.forum.model.Topico

@Service
class TopicoService(
    private var topicos: MutableList<Topico> = mutableListOf<Topico>(),
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String = "Tópico não encontrado."
) {

    fun listar(): List<TopicoView> {
        return topicos.asSequence().map {
            topicoViewMapper.map(it)
        }.toList()
    }

    fun buscarPorId(id: Long): TopicoView {
        return listar().firstOrNull { it.id == id } ?: throw NotFoundException(notFoundMessage)
    }

    fun cadastrar(dto: NovoTopicoForm): TopicoView {
        val t = topicoFormMapper.map(dto).copy(id = topicos.size.toLong() + 1)
        topicos.add(t)
        return topicoViewMapper.map(t)
    }

    fun atualizar(dto: AtualizacaoTopicoForm): TopicoView {
        val idx = topicos.indexOfFirst { it.id == dto.id }
        if (idx == -1) {
            throw NotFoundException(notFoundMessage)
        }
        val t = topicos[idx].copy(titulo = dto.titulo, mensagem = dto.mensagem)
        topicos[idx] = t

        return topicoViewMapper.map(t)
    }

    fun deletar(id: Long) {
        if (! topicos.removeIf { it.id == id }) {
            throw NotFoundException(notFoundMessage)
        }
    }
}