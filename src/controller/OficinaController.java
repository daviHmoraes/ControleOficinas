package controller;

import model.entity.Oficina;
import model.service.OficinaService;

import java.util.List;

public class OficinaController {

    private OficinaService oficinaService;

    public OficinaController(OficinaService oficinaService) {
        this.oficinaService = oficinaService;
    }

    public void salvar(Oficina oficina){
        try {
            oficinaService.salvar(oficina);
        } catch(RuntimeException e) {
            System.out.println(e);
        }
    }

    public Oficina buscarPorId(int id){
        try {
            return oficinaService.buscarPorId(id);
        } catch(RuntimeException e) {
            System.out.println(e);
            return null;
        }
    }

    public List<Oficina> listarTodos(){
        try{
            return oficinaService.listarTodos();
        } catch(RuntimeException e) {
            System.out.println(e);
            return null;
        }
    }

}