
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
public class ClienteDAO implements DAO<Cliente> {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Cliente cadastrar(Cliente cliente){
         return em.merge(cliente);

    }

    public Cliente alterar(Cliente cliente){

        //Se usuario existir no banco.
        if (buscarPorId(cliente.getId()) != null) {
            return em.merge(cliente);
        }
        //Se não existir no banco.

        if (buscarPorId(cliente.getId()) == null) {
            System.out.println("Impossível alterar! Usuário não encontrado no banco.");
        }

        return null;
    }


    @Override
    public Cliente excluir(Cliente cliente){
        if (buscarPorId(cliente.getId()) != null) {
            em.remove(buscarPorId(cliente.getId()));
        }
        return null;
    }

    @Override
    public Cliente buscarPorId(long id){



            Cliente clienteRetorno = em.find(Cliente.class, id);
            if (clienteRetorno != null) {
                return clienteRetorno;
            } else {
                return null;
            }
    }



    @Override
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
