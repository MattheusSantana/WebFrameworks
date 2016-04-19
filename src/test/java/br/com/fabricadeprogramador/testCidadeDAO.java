package br.com.fabricadeprogramador;

import br.com.fabricadeprogramador.DAO.CidadeDAO;
import br.com.fabricadeprogramador.Exeptions.DAOExeption;
import br.com.fabricadeprogramador.entidades.Cidade;
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
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback =true)
public class testCidadeDAO {

    @Autowired
    private CidadeDAO cidadeDAO;


    @Test
    public void testBuscarTodos(){
        List<Cidade> lista = cidadeDAO.buscarTodos();

        for (Cidade c : lista){
            System.out.println(lista);
        }
    }

    @Test
    public void testBuscarPorNome(){
        System.out.println(cidadeDAO.buscarPorNome("Campo Grande"));

    }


    @Test
    public void testBuscarPorId(){
        Cidade cidadeRetorno = null;
        try {
            cidadeRetorno = cidadeDAO.buscarPorId(Cidade.class, 14);
        } catch (DAOExeption daoExeption) {
            daoExeption.printStackTrace();
        }

        System.out.println(cidadeRetorno);
    }



}
