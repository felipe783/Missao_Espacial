package trabalho.panca.MissaoEspacial.service;

import org.springframework.stereotype.Service;
import trabalho.panca.MissaoEspacial.model.Missao;
import trabalho.panca.MissaoEspacial.repository.MissaoRepository;
import java.util.List;

//Ações onde ce pode fazer com o model, são basicamento as funções do codigo

@Service
public class MissaoService {

    private final MissaoRepository missaoRepository;

    public MissaoService(MissaoRepository missaoRepository){
        this.missaoRepository = missaoRepository;
    }
    //LISTAR
    public List<Missao> getAll(){return missaoRepository.findAll(); }

    //CRIAR
    //public Missao save(Missao missao){return missaoRepository.save(missao); } //Save precisa de uma Entity pra salvar

    //DELETAR
    //public void delete(Long id){missaoRepository.deleteById(id); }
}
