package br.com.fabricadeprogramador;

import br.com.fabricadeprogramador.DAO.TipoContatoDAO;
import br.com.fabricadeprogramador.Exeptions.DAOExeption;
import br.com.fabricadeprogramador.entidades.Cidade;
import br.com.fabricadeprogramador.entidades.TipoContato;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
public class testTipoContato {

    @Autowired
    TipoContatoDAO tipoContatoDAO;


    @Test
    public void testBuscarTodos(){
        List<TipoContato> lista = tipoContatoDAO.buscarTodos();

        for (TipoContato c : lista){
            System.out.println(lista);
        }
    }

    @Test
    public void testBuscarPorId(){
        TipoContato tipoContato = null;
        try {
            tipoContato = tipoContatoDAO.buscarPorId(TipoContato.class, 2);
        } catch (DAOExeption daoExeption) {
            daoExeption.printStackTrace();
        }
        System.out.println(tipoContato);
    }

}
