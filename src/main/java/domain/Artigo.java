package domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ARTIGOS")
@Data
@SequenceGenerator(name = "ART_SEQ", sequenceName = "artigo_id_seq")
public class Artigo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ART_SEQ")
    private Integer id;
    private String titulo;
    private String orientador;
    private String coautores;
    private String modalidade;
    private String data_submissao;
    private String urlDownload;

    public Artigo() {

    }

    public Artigo(String titulo, String orientador, String coautores, String modalidade, String dataSubmissao,
                  String urlDownload) {
        this.titulo = titulo;
        this.orientador = orientador;
        this.coautores = coautores;
        this.modalidade = modalidade;
        this.data_submissao = dataSubmissao;
        this.urlDownload = urlDownload;
    }

}
