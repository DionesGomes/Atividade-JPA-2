package dao;

import domain.Artigo;
import domain.Inscricao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class InscricaoDAO {

    @PersistenceContext(unitName = "dac")
    EntityManager em;

    public void salvar(Inscricao inscricao) {
        em.persist(inscricao);
    }
}
