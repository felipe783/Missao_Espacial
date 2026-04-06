package trabalho.panca.MissaoEspacial.service;

import org.springframework.stereotype.Service;
import trabalho.panca.MissaoEspacial.model.Foguete;
import trabalho.panca.MissaoEspacial.repository.FogueteRepository;

import java.util.List;

@Service
public class FogueteService {
    public final FogueteRepository fogueteRepository;

    public FogueteService(FogueteRepository fogueteRepository){
        this.fogueteRepository = fogueteRepository;
    }

    //Listar Foguetes
    public List<Foguete> findAll(){return fogueteRepository.findAll();}

    //Salvar um Foguete
    public Foguete save(Foguete foguete){return fogueteRepository.save(foguete);}

    //Deletar
    public void delete(Long id){fogueteRepository.deleteById(id);}
}
