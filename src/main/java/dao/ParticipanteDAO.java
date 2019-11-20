package dao;

import domain.Artigo;
import domain.Participante;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ParticipanteDAO {

    @PersistenceContext(unitName = "dac")
    EntityManager em;

    public void salvar(Participante participante) {
        em.persist(participante);
    }
}
