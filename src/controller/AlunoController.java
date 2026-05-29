package controller;

import model.entity.Aluno;
import model.service.AlunoService;

import java.util.List;

public class AlunoController {

    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    public void salvar(Aluno aluno){
        try {
            alunoService.salvar(aluno);
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }

    public Aluno buscarPorId(int id){
        try {
            return alunoService.buscarPorId(id);
        } catch (RuntimeException e) {
            System.out.println(e);
            return null;
        }
    }

    public List<Aluno> listarTodos(){
        try {
            return alunoService.listarTodos();
        } catch (RuntimeException e) {
            System.out.println(e);
            return null;
        }
    }
}