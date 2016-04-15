package br.com.fabricadeprogramador;

import br.com.fabricadeprogramador.DAO.EstadoDAO;
import br.com.fabricadeprogramador.entidades.Cidade;
import br.com.fabricadeprogramador.entidades.Estado;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.util.List;

/**
 * Created by Matheus on 15/04/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/springbeans.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class testEstadoDAO {

    @Autowired
    EstadoDAO estadoDAO;

    @Test
    public void testBuscarTodos(){
        List<Estado> lista = estadoDAO.buscarTodos();

        for (Estado c : lista){
            System.out.println(lista);
        }
    }

    @Test
    public void testBuscarPorNome(){
        System.out.println(estadoDAO.buscarPorNome("Mato Grosso do Sul"));

    }

    @Test
    public void testBuscarPorId(){
        Estado estadoRetorno = estadoDAO.buscarPorId(Estado.class, 14);

        System.out.println(estadoRetorno);
    }
}
