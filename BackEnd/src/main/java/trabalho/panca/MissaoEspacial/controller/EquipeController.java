package trabalho.panca.MissaoEspacial.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trabalho.panca.MissaoEspacial.model.Astronauta;
import trabalho.panca.MissaoEspacial.service.EquipeService;
import trabalho.panca.MissaoEspacial.model.Equipe;
import java.util.List;

@RestController
@RequestMapping("/equipes")
public class EquipeController {

    private final EquipeService equipeService;
    public EquipeController(EquipeService equipeservice){
        this.equipeService = equipeservice;
    }

    //Lista EQUIPE
    @GetMapping
    public List<Equipe> getAll(){return equipeService.findAll();}

    //CRIAR uma Equipe
    @PostMapping
    public Equipe create(@RequestBody Equipe equipe){return equipeService.save(equipe);}
    //Aqui estamos lindando com HTTP então o create "cria" a requisição por isso create

    //DELETAR equipe
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        equipeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    //ADD membro
    @PostMapping("/{id}/astronautas")
    public ResponseEntity<Void> addMember(@PathVariable Long id, @RequestBody Astronauta astronauta){
        //@RequestBody Pega o JSON dos astronautas e converte pra o objeto astronauta
        equipeService.addMember(id, astronauta); //Vai pra função no service
        return ResponseEntity.status(201).build(); //Retornar sem nenhum Body e com o status de CREATED(201)
    }

}
