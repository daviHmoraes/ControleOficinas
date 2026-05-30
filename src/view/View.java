package view;

import controller.AlunoController;
import controller.InscricaoController;
import controller.OficinaController;
import model.entity.Aluno;
import model.entity.Inscricao;
import model.entity.Oficina;
import model.entity.Status;

import java.util.List;
import java.util.Scanner;

public class View {

    private final AlunoController alunoController;
    private final OficinaController oficinaController;
    private final InscricaoController inscricaoController;

    public View(AlunoController alunoController, InscricaoController inscricaoController, OficinaController oficinaController) {
        this.alunoController = alunoController;
        this.oficinaController = oficinaController;
        this.inscricaoController = inscricaoController;
    }

    private final Scanner input = new Scanner(System.in);

    public void menuInicial() {
        System.out.println("|-=-=-=-=-| Menu Inicial |-=-=-=-=-|");
        System.out.println("| 1. Cadastrar Aluno               |");
        System.out.println("| 2. Listar Aluno                  |");
        System.out.println("| 3. Cadastrar Oficina             |");
        System.out.println("| 4. Listar Oficinas               |");
        System.out.println("| 5. Cadastrar Inscrição           |");
        System.out.println("| 6. Listar Inscrições             |");
        System.out.println("| 7. Cancelar Inscrição            |");
        System.out.println("| 8. Remover Inscrição             |");
        System.out.println("|-=-=-=-=-|              |-=-=-=-=-|");
        int opcao = lInt("Escolha uma opção: ");

        switch (opcao) {
            case 1 -> {
            cadastrarAluno();
            }

            case 2 -> {
            listarAlunos();
            }

            case 3 -> {
            cadastrarOficina();
            }

            case 4 -> {
            listarOficinas();
            }

            case 5 -> {
            cadastrarInscricao();
            }

            case 6 -> {
            listarInscricoes();
            }

            case 7 -> {
            cancelarInscricao();
            }

            case 8 -> {
            removerInscricao();
            }

        }

    }

    private void cadastrarAluno() {
        String nome = lString("Insira o nome do aluno: ");
        String cpf = lString("Insira o cpf do aluno: ");
        alunoController.salvar(new Aluno(nome, cpf));
    }

    private void listarAlunos() {
        List<Aluno> list = alunoController.listarTodos();
        if (list.isEmpty()) System.out.println("Não há alunos.");
        list.forEach(a -> a.exibirDados());
    }

    private void cadastrarOficina() {
        String titulo = lString("Insira o título: ");
        int cargaHoraria = lInt("Insira a carga horária: ");
        int vagasDisponiveis = lInt("Insira a quantidade de vagas: ");
        oficinaController.salvar(new Oficina(titulo, cargaHoraria, vagasDisponiveis));
    }

    private void listarOficinas() {
        List<Oficina> list = oficinaController.listarTodos();
        if (list.isEmpty()) System.out.println("Não há oficinas.");
        list.forEach(o -> o.exibirDados());
    }

    private void cancelarInscricao() {
        int idInscricao = lInt("Insira o ID da inscrição que irá cancelar: ");
        inscricaoController.cancelar(idInscricao);
    }

    private void cadastrarInscricao() {
        int idAluno = lInt("Insira o id do Aluno: ");
        int idOficina = lInt("Insira o id da Oficina: ");

        Aluno aluno = alunoController.buscarPorId(idAluno);
        Oficina oficina = oficinaController.buscarPorId(idOficina);

        inscricaoController.salvar(new Inscricao(aluno, oficina, Status.ATIVA));
    }

    private void listarInscricoes() {
        List<Inscricao> list = inscricaoController.listar();
        if (list.isEmpty()) System.out.println("Não há inscrições.");
        list.forEach(i -> i.exibirDados());
    }

    private void removerInscricao() {
        int idInscricao = lInt("Insira o id da inscrição que irá remover: ");
        inscricaoController.remover(idInscricao);
    }

    public int lInt(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("ERRO: Digite um número inteiro válido.");
            }
        }
    }

    public String lString(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = input.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("ERRO: O campo não pode ficar vazio.");
        }
    }
}
