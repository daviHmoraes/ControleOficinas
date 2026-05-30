import controller.AlunoController;
import controller.InscricaoController;
import controller.OficinaController;
import model.repository.AlunoRepository;
import model.repository.InscricaoRepository;
import model.repository.OficinaRepository;
import model.service.AlunoService;
import model.service.InscricaoService;
import model.service.OficinaService;
import view.View;

public class Main {

    public static void main(String[] args) {

        // Repositories
        AlunoRepository alunoRepository = new AlunoRepository();
        OficinaRepository oficinaRepository = new OficinaRepository();
        InscricaoRepository inscricaoRepository = new InscricaoRepository();

        // Services
        AlunoService alunoService = new AlunoService(alunoRepository);
        OficinaService oficinaService = new OficinaService(oficinaRepository);
        InscricaoService inscricaoService = new InscricaoService(inscricaoRepository);

        // Controllers
        AlunoController alunoController = new AlunoController(alunoService);
        OficinaController oficinaController = new OficinaController(oficinaService);
        InscricaoController inscricaoController = new InscricaoController(inscricaoService);

        // View
        View view = new View(
                alunoController,
                inscricaoController,
                oficinaController
        );

        while (true) {
            view.menuInicial();
            System.out.println();
        }
    }
}