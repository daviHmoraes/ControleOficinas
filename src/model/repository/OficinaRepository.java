package model.repository;

import model.entity.Oficina;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OficinaRepository {

    HashMap<Integer, Oficina> map = new HashMap<>();

    public void salvar(Oficina oficina){
        map.put(oficina.getId(), oficina);
    }

    public Oficina buscarPorId(int id){
        return map.get(id);
    }

    public List<Oficina> listarTodos(){
        return new ArrayList<>(map.values());
    }
}