package domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@SequenceGenerator(name = "ISF_SEQ", sequenceName = "inscricaoefetuada_id_seq")
public class Inscricaoefetuada implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ISF_SEQ")
    private Integer id;
    private String formaPagamento;
    private Integer quantidade;
    private String transacao;
    private String status;
    private Double valor;


    public Inscricaoefetuada() {

    }

    // Relacionamento aqui com incrição.

}
