package domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "INSCRICOES")
@Data
@SequenceGenerator(name = "ISC_SEQ", sequenceName = "inscricoes_id_seq", initialValue = 1, allocationSize = 1)
public class Inscricao implements Serializable {

    public enum TipoEvento {CONGRESSO, SIMPOSIO};

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ISC_SEQ")
    private Integer id;
    @Column(name = "status_inscricao")
    private String status;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInscricao;
    private Double preco;
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;
    private String tipoParticipacao;

    @OneToOne
    private Participante participante;

    public Inscricao() {

    }

    public Inscricao(Date dataInscricao, Double preco, TipoEvento tipoEvento, String tipoParticipacao,
                     Participante participante) {
        this.dataInscricao = dataInscricao;
        this.preco = preco;
        this.tipoEvento = tipoEvento;
        this.tipoParticipacao = tipoParticipacao;
        this.participante = participante;
    }
}