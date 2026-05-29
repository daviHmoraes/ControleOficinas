package model.repository;

import model.entity.Inscricao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InscricaoRepository {

    private HashMap<Integer, Inscricao> mapa = new HashMap<>();

    public void salvar(Inscricao inscricao) {
        mapa.put(inscricao.getId(), inscricao);
    }

    public Inscricao buscarPorId(int id) {
        return mapa.get(id);
    }

    public List<Inscricao> listar() {
        return new ArrayList<>(mapa.values());
    }

    public Inscricao atualizar(Inscricao inscricao) {
        return mapa.put(inscricao.getId(), inscricao);
    }

    public Inscricao remover(int id) {
        return mapa.remove(id);
    }

}
