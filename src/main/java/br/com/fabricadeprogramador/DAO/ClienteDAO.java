
package br.com.fabricadeprogramador.DAO;


import br.com.fabricadeprogramador.entidades.Cliente;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


/**
 * Created by Matheus on 05/04/2016.
 */

@Repository
@Transactional
public class ClienteDAO extends GenericDAO<Cliente> {


    public List<Cliente> buscarTodos() {
        Query query = em.createQuery("select c from Cliente c order by c.id");
        List<Cliente> listaClientes = (List<Cliente>) query.getResultList();
        return listaClientes;
    }

    public Cliente buscarPorNome(String nome) {

            Query query = em.createQuery("select c from Cliente c where c.nome=:nome");
            query.setParameter("nome", nome);

            return (Cliente) query.getSingleResult();


    }
}
