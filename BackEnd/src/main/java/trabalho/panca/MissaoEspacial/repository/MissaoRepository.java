package trabalho.panca.MissaoEspacial.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import trabalho.panca.MissaoEspacial.model.Missao;

//Contador de quantas coisas foram requisitadas
//É onde persiste os dados, é principalmente aqui onde são depositados os dados
public interface MissaoRepository extends JpaRepository<Missao, Long > { //é uma "interface" então obriga todas as função a ter o banco
    @Query("SELECT COALESCE(SUM(a.peso_astronauta), 0) " +
            "FROM Missao m " +
            "JOIN m.equipe e " +
            "JOIN e.astronautas a " +
            "WHERE m.idMissao = :idMissao")
    Double SomaPesoAstronautas(@Param("idMissao") Long idMissao);
    /*
    "SELECT COALESCE(SUM(a.peso_astronauta), 0) ---Soma os Pesos
            "FROM Missao m " ---Ta buscando pela missao especifica
            "JOIN m.equipe e " + ---Pega a equipe vincula a missao
            "JOIN e.astronautas a " + ---Pega todos os astronautas da equipe
            "WHERE m.idMissao = :idMissao" ---Filtra a missão especifica
     * */

}
