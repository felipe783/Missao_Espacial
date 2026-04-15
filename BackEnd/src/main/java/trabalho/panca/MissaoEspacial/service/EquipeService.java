package trabalho.panca.MissaoEspacial.service;
import org.springframework.stereotype.Service;
import trabalho.panca.MissaoEspacial.model.Astronauta;
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

    //ADD Membros
    public void addMember(Long id, Astronauta astronauta){
        Equipe equipe = equipeRepository.findById(id).orElseThrow(()-> new RuntimeException("Equipe não encontrada")); //Busca no banco se não existis lança o "Equipe não encontrada"

        //Pegar o Limite
        int limite = equipe.getQntMembros();

        //Pegar Quantidade Atual
        int quantidade = equipe.getAstronautas().size(); //Pega o quantos astronauas tem na equipe pra verificar se não está no limite

        if (quantidade >= limite){
            throw new RuntimeException("Equipe cheia");
        }
        else{
            //Vincular astronauta a equipe
            astronauta.setEquipe(equipe);

            //Add o astronauta
            equipe.getAstronautas().add(astronauta);

            //Salvar no banco
            equipeRepository.save(equipe);
        }
    }
}
