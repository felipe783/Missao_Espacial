package trabalho.panca.MissaoEspacial.service;

import org.springframework.stereotype.Service;
import trabalho.panca.MissaoEspacial.model.*;
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
    public List<Missao> findAll(){return missaoRepository.findAll(); }

    //CRIAR
    public Missao save(Missao missao){
        validarMissao(missao, missao.getIdMissao()); //Vai lançar uma exception então não retorna "true or false" apenas interrompe toda a execução
        return missaoRepository.save(missao);
    }

    //Validar Missão
    public void validarMissao(Missao missao,Long id){ //O objeto missão ja contem satelite e foguete

            if(missao.getSatelite() == null || missao.getFoguete() == null || missao.getNomeMissao() == null){
                throw new RuntimeException("Dados incomplestos");
            }
            double carga_util = missao.getFoguete().getCarga_util();
            double peso_Sat = missao.getSatelite().getMassa_satelite();
            double Peso_Equipe = missaoRepository.SomaPesoAstronautas(id);

            if(peso_Sat + Peso_Equipe >= carga_util){
                throw new RuntimeException("Peso do satelite maior do que a carga util do Foguete");
            }

            if(!missao.getSatelite().getStatus_satelite().equals("EM SOLO") || !missao.getFoguete().getStatus_foguete().equals("EM SOLO")){ //Se não for esses status
                throw new RuntimeException("Satelite ou Foguete não estão validos pra entrarem em uma nova missão");
            }
            //Status Missao
            missao.setStatus("Pronta pra Lançamento");

            //Status Foguete
            missao.getFoguete().setStatus_foguete("Já vincula a uma Missão");

            //Status Satelite
            missao.getSatelite().setStatus_satelite("Já vincula a uma Missão");
    }

    //Lançar a Missão ou "INICIAR"
    public Missao iniciarMissao(Long id){
        Missao missao = missaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Missão não encontrada"));

        return missaoRepository.save(missao); //Ele valida na função "save"
    }

    //DELETAR
    public void delete(Long id){missaoRepository.deleteById(id); }
}
