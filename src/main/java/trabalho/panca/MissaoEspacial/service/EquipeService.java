package trabalho.panca.MissaoEspacial.service;
import org.springframework.stereotype.Service;
import trabalho.panca.MissaoEspacial.model.Equipe;
import trabalho.panca.MissaoEspacial.repository.EquipeRepository;

import java.util.List;

@Service
public class EquipeService {
    private final EquipeRepository equipeRepository;

    public EquipeService(EquipeRepository equipeRepository){
        this.equipeRepository = equipeRepository;
    }

    //Listar as Equipe
    public List<Equipe> findAll(){return equipeRepository.findAll();}

    //Salvar um equipe
    public Equipe save(Equipe equipe){return equipeRepository.save(equipe);} //Aqui nos estamos lidando com dados por isso "save"

    //Deletar
    public void delete(Long id){equipeRepository.deleteById(id); }
}
