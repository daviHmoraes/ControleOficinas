package model.service;

import model.entity.Oficina;
import model.repository.OficinaRepository;

import java.util.List;

public class OficinaService {

    private OficinaRepository oficinaRepository;

    public OficinaService(OficinaRepository oficinaRepository) {
        this.oficinaRepository = oficinaRepository;
    }

    public void salvar(Oficina oficina){
        oficinaRepository.salvar(oficina);
    }

    public Oficina buscarPorId(int id){
        Oficina oficina = oficinaRepository.buscarPorId(id);
        if(oficina == null) {
            throw new RuntimeException("ERRO: oficina não encontrada.");
        } else {
            return oficina;
        }
    }

    public List<Oficina> listarTodos(){
        return oficinaRepository.listarTodos();
    }
}