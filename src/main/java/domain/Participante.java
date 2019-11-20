package domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PARTICIPANTES")
@Data
@SequenceGenerator(name = "PRT_SEQ", sequenceName = "PARTICIPANTE_SEQ", initialValue = 1, allocationSize = 1)
public class Participante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRT_SEQ")
    private Integer id;
    private String nome;
    private String email;
    @Column(name = "nome_cracha")
    private String nomeCracha;
    private String instituicao;
    private String CPF;
    private String tipoUsuario;
    private String profissao;

    @Embedded
    private Contato contato;
    @Embedded
    private Endereco endereco;

    public Participante() {

    }

    public Participante(String nome, String email, String nomeCracha, String instituicao, String CPF, String tipoUsuario,
                        String profissao, Contato contato, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.nomeCracha = nomeCracha;
        this.instituicao = instituicao;
        this.CPF = CPF;
        this.tipoUsuario = tipoUsuario;
        this.profissao = profissao;
        this.contato = contato;
        this.endereco = endereco;
    }
}
