package domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ARTIGOS")
@Data
public class Artigo implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String titulo;
    private String orientador;
    private String coautores;
    private String modalidade;
    @Column(name = "data_submissao")
    private String dataSubmissao;
    private String urlDownload;

    public Artigo() {

    }

    public Artigo(String titulo, String orientador, String coautores, String modalidade, String dataSubmissao,
                  String urlDownload) {
        this.titulo = titulo;
        this.orientador = orientador;
        this.coautores = coautores;
        this.modalidade = modalidade;
        this.dataSubmissao = dataSubmissao;
        this.urlDownload = urlDownload;
    }

    public Artigo(String titulo, String orientador, String coautores) {
        this.titulo = titulo;
        this.orientador = orientador;
        this.coautores = coautores;
    }
}
