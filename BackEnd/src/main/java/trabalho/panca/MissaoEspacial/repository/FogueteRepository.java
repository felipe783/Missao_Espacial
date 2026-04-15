package trabalho.panca.MissaoEspacial.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import trabalho.panca.MissaoEspacial.model.Foguete;

public interface FogueteRepository extends JpaRepository<Foguete, Long> {
}
