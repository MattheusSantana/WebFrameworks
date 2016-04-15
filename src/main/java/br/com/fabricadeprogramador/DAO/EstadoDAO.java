package br.com.fabricadeprogramador.DAO;

import br.com.fabricadeprogramador.entidades.Cidade;
import br.com.fabricadeprogramador.entidades.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Matheus on 15/04/2016.
 */
@Repository
public class EstadoDAO extends GenericDAO<Estado> {
    @PersistenceContext
    EntityManager em;


    public List<Estado> buscarTodos() {
        Query query = em.createQuery("select c from Estado c order by c.id");
        List<Estado> lista = (List<Estado>) query.getResultList();
        return lista;
    }

    public List<Estado> buscarPorNome(String nome) {

        Query query = em.createQuery("select c from Estado c where c.nome=:nome");
        query.setParameter("nome", nome);

        List<Estado> lista = (List<Estado>)query.getResultList();
        return lista;
    }



}
