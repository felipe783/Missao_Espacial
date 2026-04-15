package trabalho.panca.MissaoEspacial.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import trabalho.panca.MissaoEspacial.model.Satelite;

public interface SateliteRepository extends JpaRepository<Satelite, Long> {
}
