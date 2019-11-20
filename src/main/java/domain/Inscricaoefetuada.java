package domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@SequenceGenerator(name = "ISF_SEQ", sequenceName = "inscricaoefetuada_id_seq", initialValue = 1, allocationSize = 1)
public class Inscricaoefetuada implements Serializable {

    public enum FormaPagamento {CARTAO, DINHEIRO};

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ISF_SEQ")
    private Integer id;
    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;
    private Integer quantidade;
    private String transacao;
    private String status;
    private Double valor;


    public Inscricaoefetuada() {

    }

    public Inscricaoefetuada(FormaPagamento formaPagamento, Integer quantidade, String transacao, String status, Double valor) {
        this.formaPagamento = formaPagamento;
        this.quantidade = quantidade;
        this.transacao = transacao;
        this.status = status;
        this.valor = valor;
    }
}
