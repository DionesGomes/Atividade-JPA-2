package dao;

import domain.Artigo;
import domain.Endereco;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EnderecoDAO {

    @PersistenceContext(unitName = "dac")
    EntityManager em;

    public void salvar(Endereco endereco) {
        em.persist(endereco);
    }
}
