package model.service;

import model.entity.Inscricao;
import model.entity.Oficina;
import model.entity.Status;
import model.repository.InscricaoRepository;

import java.util.List;

public class InscricaoService {

    private final InscricaoRepository inscricaoRepository;

    public InscricaoService(InscricaoRepository inscricaoRepository) {
        this.inscricaoRepository = inscricaoRepository;
    }

    public void salvar(Inscricao inscricao) {

        Oficina oficina = inscricao.getOficina();

        if (oficina.getVagasDisponiveis() <= 0) {
            throw new RuntimeException("ERRO: Não há vagas nessa oficina.");
        }

        for (Inscricao i : inscricaoRepository.listar()) {
            if (i.getAluno().getId() == inscricao.getAluno().getId()
                && i.getOficina().getId() == inscricao.getOficina().getId()) {
                throw new RuntimeException("ERRO: Aluno já cadastrado nessa oficina.");
            }
        }

        oficina.setVagasDisponiveis(oficina.getVagasDisponiveis() - 1);

        inscricaoRepository.salvar(inscricao);
    }

    public Inscricao buscarPorId(int id) {
        Inscricao inscricao = inscricaoRepository.buscarPorId(id);

        if (inscricao == null) {
            throw new RuntimeException("ERRO: Inscrição não encontrada.");
        }

        return inscricao;

    }

    public List<Inscricao> listar() {
        return inscricaoRepository.listar();
    }

    public void cancelar(int id) {
        Inscricao inscricao = buscarPorId(id);

        if (inscricao.getStatus() == Status.CANCELADA) {
            throw new RuntimeException("ERRO: Inscrição já está cancelada.");
        }

        Oficina oficina = inscricao.getOficina();

        inscricao.setStatus(Status.CANCELADA);
        oficina.setVagasDisponiveis(oficina.getVagasDisponiveis()+1);

    }

    public void atualizar(Inscricao inscricao) {
        buscarPorId(inscricao.getId());

        inscricaoRepository.atualizar(inscricao);

    }

    public void remover(int id) {
        Inscricao inscricao = buscarPorId(id);

        if (inscricao.getStatus() != Status.CANCELADA) {
            cancelar(id);
        }

        inscricaoRepository.remover(id);
    }

}
