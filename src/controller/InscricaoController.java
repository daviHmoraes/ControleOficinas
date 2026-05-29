package controller;

import model.entity.Inscricao;
import model.service.InscricaoService;

import java.util.List;

public class InscricaoController {

    private InscricaoService inscricaoService;

    public InscricaoController(InscricaoService inscricaoService) {
        this.inscricaoService = inscricaoService;
    }

    public void salvar(Inscricao inscricao) {
        try {
            inscricaoService.salvar(inscricao);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public Inscricao buscarPorId(int id) {
        try {
           return inscricaoService.buscarPorId(id);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());;
           return null;
        }
    }

    public List<Inscricao> listar() {
        return inscricaoService.listar();
    }

    public void cancelar(int id) {
        try {
            inscricaoService.cancelar(id);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void atualizar(Inscricao inscricao) {
        try {
            inscricaoService.atualizar(inscricao);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void remover(int id) {
        try {
            inscricaoService.remover(id);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

}
