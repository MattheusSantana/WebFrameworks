package br.com.fabricadeprogramador.DAO;

import br.com.fabricadeprogramador.entidades.Cidade;
import br.com.fabricadeprogramador.entidades.Cliente;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Matheus on 15/04/2016.
 */
@Repository
public class CidadeDAO extends GenericDAO<Cidade>{

    @PersistenceContext
    EntityManager em;

    public List<Cidade> buscarTodos() {
        Query query = em.createQuery("select c from Cidade c order by c.id");
        List<Cidade> lista = (List<Cidade>) query.getResultList();
        return lista;
    }

    public List<Cidade> buscarPorNome(String nome) {

        Query query = em.createQuery("select c from Cidade c where c.nome=:nome");
        query.setParameter("nome", nome);

        List<Cidade> lista = (List<Cidade>)query.getResultList();
        return lista;
    }
}
