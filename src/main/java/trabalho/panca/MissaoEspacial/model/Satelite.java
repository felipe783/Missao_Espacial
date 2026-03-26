package trabalho.panca.MissaoEspacial.model;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "SATELITE_TABELA")
public class Satelite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SATELITE")
    private Long id_satelite;

    @Column(name = "NOME_SATELITE")
    private String nome_satelite;

    @Column(name = "STATUS_SATELITE")
    private String status_satelite;

    @Column(name = "MASSA_SATELITE")
    private double massa_satelite;

    @Column(name = "VELO_ORBITAL")
    private double velo_orbital;

    @Column(name = "SATELITE_CRIADOEM")
    private LocalDateTime criadoem;

    @Column(name = "DATA_LACAMENTO_SAT")
    private LocalDate datalancamento;


}
