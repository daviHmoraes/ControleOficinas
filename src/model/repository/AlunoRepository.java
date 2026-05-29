package model.repository;

import model.entity.Aluno;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AlunoRepository {

    HashMap<Integer, Aluno> map = new HashMap<>();

    public void salvar(Aluno aluno){
        map.put(aluno.getId(), aluno);
    }

    public Aluno buscarPorId(int id){
        return map.get(id);
    }

    public List<Aluno> listarTodos(){
        return new ArrayList<>(map.values());
    }

}