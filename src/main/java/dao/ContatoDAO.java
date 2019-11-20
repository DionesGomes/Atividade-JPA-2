package dao;

import domain.Contato;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ContatoDAO {

    @PersistenceContext(unitName = "dac")
    EntityManager em;

    public void salvar(Contato contato) {
        em.persist(contato);
    }

}
