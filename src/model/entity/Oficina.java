package model.entity;

public class Oficina {

    private final int id;
    private static int idContador = 1;
    private String titulo;
    private int cargaHoraria;
    private int vagasDisponiveis;

    public Oficina(String titulo, int cargaHoraria, int vagasDisponiveis) {
        setTitulo(titulo);
        setCargaHoraria(cargaHoraria);
        setVagasDisponiveis(vagasDisponiveis);
        id = idContador++;
    }

    public int getId() { return id; }

    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) {
        if(titulo.isBlank()) {
            throw new RuntimeException("ERRO: o título não pode ser vazio");
        } else {
            this.titulo = titulo;
        }
    }

    public int getCargaHoraria() { return cargaHoraria; }

    public void setCargaHoraria(int cargaHoraria) {
        if(cargaHoraria <= 0) {
            throw new RuntimeException("ERRO: a carga horária deve ser maior que 0.");
        } else {
            this.cargaHoraria = cargaHoraria;
        }
    }

    public int getVagasDisponiveis() { return vagasDisponiveis; }

    public void setVagasDisponiveis(int vagasDisponiveis) {
        if(vagasDisponiveis < 0) {
            throw new RuntimeException("ERRO: as vagas não podem ser menores que 0.");
        } else {
            this.vagasDisponiveis = vagasDisponiveis;
        }
    }

    public void exibirDados(){
        System.out.println("ID: " + id);
        System.out.println("Título: " + titulo);
        System.out.println("Carga horária: " + cargaHoraria);
        System.out.println("Vagas disponíveis: " + vagasDisponiveis);
    }
}