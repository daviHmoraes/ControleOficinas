package model.entity;

public class Aluno {

    private final int id;
    private static int idContador = 1;
    private String nome;
    private String cpf;

    public Aluno(String nome, String cpf) {
        setNome(nome);
        setCpf(cpf);
        this.id = idContador++;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(!nome.isBlank()) {
            this.nome = nome;
        } else {
            throw new RuntimeException("ERRO: O nome nao pode ser vazio.");
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if(!cpf.isBlank()) {
            this.cpf = cpf;
        } else {
            throw new RuntimeException("ERRO: O cpf nao pode ser vazio.");
        }
    }

    public void exibirDados(){
        System.out.println("Id: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
    }

}