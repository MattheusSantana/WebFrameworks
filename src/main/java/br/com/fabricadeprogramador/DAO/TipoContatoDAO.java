package br.com.fabricadeprogramador.DAO;

import br.com.fabricadeprogramador.entidades.Estado;
import br.com.fabricadeprogramador.entidades.TipoContato;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Matheus on 15/04/2016.
 */
@Repository
public class TipoContatoDAO extends GenericDAO<TipoContato> {

    public List<TipoContato> buscarTodos() {
        Query query = em.createQuery("select c from TipoContato c order by c.id");
        List<TipoContato> lista = (List<TipoContato>) query.getResultList();
        return lista;
    }

}
