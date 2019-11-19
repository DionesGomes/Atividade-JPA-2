package domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PARTICIPANTES")
@Data
@SequenceGenerator(name = "PRT_SEQ", sequenceName = "PARTICIPANTE_SEQ")
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

    @OneToOne(cascade = CascadeType.ALL)
    private Inscricao inscricao;

    @OneToMany(cascade={CascadeType.ALL})
    private List<Artigo> artigo = new ArrayList<>();

    public Participante(String nome, String email, String nomeCracha, String instituicao, String CPF, String tipoUsuario,
                        String profissao, Contato contato, Endereco endereco, Inscricao inscricao, List<Artigo> artigo) {
        this.nome = nome;
        this.email = email;
        this.nomeCracha = nomeCracha;
        this.instituicao = instituicao;
        this.CPF = CPF;
        this.tipoUsuario = tipoUsuario;
        this.profissao = profissao;
        this.contato = contato;
        this.endereco = endereco;
        this.inscricao = inscricao;
        this.artigo = artigo;
    }
}
