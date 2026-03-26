package trabalho.panca.MissaoEspacial.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import trabalho.panca.MissaoEspacial.model.Missao;

//Contador de quantas coisas foram requisitadas
//É onde persiste os dados, é principalmente aqui onde são depositados os dados
public interface MissaoRepository extends JpaRepository<Missao, Long > { //é uma "interface" então obriga todas as função a ter o banco

}
