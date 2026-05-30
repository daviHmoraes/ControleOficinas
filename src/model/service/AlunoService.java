package model.service;

import model.entity.Aluno;
import model.repository.AlunoRepository;

import java.util.List;

public class AlunoService {

    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public void salvar(Aluno aluno){
        alunoRepository.salvar(aluno);
    }

    public Aluno buscarPorId(int id){
        Aluno aluno = alunoRepository.buscarPorId(id);
        if(aluno == null){
            throw new RuntimeException("ERRO: Aluno não encontrado.");
        } else {
            return aluno;
        }
    }

    public List<Aluno> listarTodos(){
        return alunoRepository.listarTodos();
    }

}