package trabalho.panca.MissaoEspacial.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import trabalho.panca.MissaoEspacial.model.Astronauta;

public interface AstronautaRepository extends JpaRepository<Astronauta, Long> {

}
