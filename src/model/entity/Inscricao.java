package model.entity;

public class Inscricao {

    private final int id;
    private static int idContador = 1;
    private Aluno aluno;
    private Oficina oficina;
    private Status status;

    public Inscricao(Aluno aluno, Oficina oficina, Status status) {
        setAluno(aluno);
        setOficina(oficina);
        setStatus(status);
        id = idContador++;
    }

    // |---------| Getters e Setters |---------|

    public int getId() {
        return id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        if (aluno == null) {
            throw new RuntimeException("ERRO: Aluno não pode ser vazio.");
        }
        this.aluno = aluno;
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        if (oficina == null) {
            throw new RuntimeException("ERRO: Oficina não pode ser vazia.");
        }
        this.oficina = oficina;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        if (status == null) {
            throw new RuntimeException("ERRO: Status não pode ser vazio.");
        }
        this.status = status;
    }

    public void exibirDados() {
        System.out.println("Aluno: " + aluno.getNome());
        System.out.println("Oficina: " + oficina.getTitulo());
        System.out.println("Status: " + status);
    }

}
