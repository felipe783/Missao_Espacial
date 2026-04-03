package trabalho.panca.MissaoEspacial.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabalho.panca.MissaoEspacial.service.MissaoService;
import trabalho.panca.MissaoEspacial.model.Missao;
import java.util.List;

// Controla toda e qualquer Requisaçãom, da o caminho da requisição
//São todas as rotas onde são dadas pelo Controller
//É o porteiro da as rotas

@RestController //Sabe que toda a classe é um controler
@RequestMapping("/missoes")
public class MissaoController {

    //Injeção de independencia
    private final MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    @GetMapping //Ta listando todas as missao
    public List<Missao> ListarMissao(){return missaoService.findAll(); }

    @PostMapping //Iniciar missão
    public ResponseEntity<Missao> Create(@RequestBody Missao missao) {
        Missao nova = missaoService.save(missao);
        return ResponseEntity.status(201).body(nova); //
    }

    @PutMapping("/{id}/iniciar")
    public ResponseEntity<Missao> Start(@PathVariable Long id){
        Missao missao = missaoService.iniciarMissao(id);
        return ResponseEntity.ok(missao);
    }

    @DeleteMapping("/{id}") //Define uma rota HTTP pra ser deletado o ID.
    public ResponseEntity<Void> delete(@PathVariable Long id){ //Pega o valor do ID
        missaoService.delete(id); //Chama o Service e deleta o ID
        return ResponseEntity.noContent().build(); //Retorna status 204, onde significa que a opereação deu certo
    } //ResponseEntity<Void> permite controlar a resposta HTTP, "Void" não ira retornar nenhum Body

}
