package ranophoenix.alura.forum.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ranophoenix.alura.forum.dto.AtualizacaoTopicoForm
import ranophoenix.alura.forum.dto.NovoTopicoForm
import ranophoenix.alura.forum.dto.TopicoView
import ranophoenix.alura.forum.exception.NotFoundException
import ranophoenix.alura.forum.mapper.TopicoFormMapper
import ranophoenix.alura.forum.mapper.TopicoViewMapper
import ranophoenix.alura.forum.repository.TopicoRepository

@Service
class TopicoService(
    private val repository: TopicoRepository,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String = "Tópico não encontrado."
) {

    fun listar(nomeCurso: String?): List<TopicoView> {
        val topicos = if (nomeCurso == null) {
            repository.findAll()
        } else {
            repository.findByCursoNome(nomeCurso)
        }
        return topicos.asSequence().map {
            topicoViewMapper.map(it)
        }.toList()
    }

    fun buscarPorId(id: Long): TopicoView {
        val t = repository.findByIdOrNull(id) ?: throw NotFoundException(notFoundMessage)
        return topicoViewMapper.map(t)
    }

    fun cadastrar(dto: NovoTopicoForm): TopicoView {
        val t = topicoFormMapper.map(dto)
        repository.save(t)
        return topicoViewMapper.map(t)
    }

    fun atualizar(dto: AtualizacaoTopicoForm): TopicoView {
        val topico = repository.findByIdOrNull(dto.id) ?: throw NotFoundException(notFoundMessage)
        topico.titulo = dto.titulo
        topico.mensagem = dto.mensagem
        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }

}