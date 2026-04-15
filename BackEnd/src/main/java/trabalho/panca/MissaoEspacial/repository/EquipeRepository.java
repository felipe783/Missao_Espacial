package trabalho.panca.MissaoEspacial.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import trabalho.panca.MissaoEspacial.model.Equipe;

public interface EquipeRepository extends JpaRepository <Equipe, Long> {
}
