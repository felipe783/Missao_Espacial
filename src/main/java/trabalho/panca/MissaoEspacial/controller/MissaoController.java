package trabalho.panca.MissaoEspacial.controller;
import org.springframework.web.bind.annotation.*;
import trabalho.panca.MissaoEspacial.service.MissaoService;
import trabalho.panca.MissaoEspacial.model.Missao;

import java.util.List;

// Controla toda e qualquer Requisaçãom, da o caminho da requisição
//São todas as rotas onde são dadas pelo Controller
//É o porteiro da as rotas

@RestController //Sabe que toda a classe é um controler
@RequestMapping("/missao")
public class MissaoController {

    //Injeção de independencia
    private final MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    @GetMapping //Ta listando todas as missao
    public List<Missao> getAll() {return missaoService.getAll(); }

    //@PostMapping //Mandando pro server
    //public Missao create(@RequestBody Missao missao) {return missaoService.save(missao) ;}
}
