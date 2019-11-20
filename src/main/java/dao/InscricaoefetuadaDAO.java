package dao;

import domain.Inscricaoefetuada;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class InscricaoefetuadaDAO {

    @PersistenceContext(unitName = "dac")
    EntityManager em;

    public void salvar(Inscricaoefetuada inscricaoefetuada) {
        em.persist(inscricaoefetuada);
    }
}
