
package br.com.fabricadeprogramador;

import br.com.fabricadeprogramador.DAO.ClienteDAO;
import br.com.fabricadeprogramador.entidades.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Matheus on 05/04/2016.
 */



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/springbeans.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback =false)
public class testClienteDAO {


    @Autowired
    private ClienteDAO clienteDAO;


    Estado estado = new Estado("Mato Grosso", "MT");


    Cidade cidade = new Cidade(estado, "Cuiabá");

    TipoContato tipoContato = new TipoContato("Email");
    TipoContato tipoContato2 = new TipoContato("Telefone");
    TipoContato tipoContato3 = new TipoContato("Celular");

    Contato contato = new Contato("joao@email.com", tipoContato);
    Contato contato2 = new Contato("3200-0000", tipoContato2);
    Contato contato3 = new Contato("9999-9999", tipoContato3);



    Cliente cliente = new Cliente();





    @Test
    @Transactional
    public void testSalvar(){

        cliente.setCidade(cidade);
        cliente.setNome("JoãoG ");
        cliente.getContato().add(contato);
        cliente.getContato().add(contato2);
        cliente.getContato().add(contato3);

        clienteDAO.salvar(cliente);
        Assert.assertNotNull(cliente);
        System.out.println(cliente);

    }


    @Transactional
    @Test
    public void testBuscarPorId(){


        Cliente clienteRetorno = (clienteDAO.buscarPorId(Cliente.class, 156));
        Assert.assertNotNull(clienteRetorno);
        System.out.println(clienteRetorno);


    }


    @Transactional
    @Test
    public void testExcluir(){

        clienteDAO.excluir(Cliente.class, 156);
        Assert.assertNull(clienteDAO.buscarPorId(Cliente.class, 156));

    }

    @Test
    public void testBuscarTodos(){
       List<Cliente> lista = clienteDAO.buscarTodos();

        for (Cliente c : lista){
            System.out.println(c);
        }
    }

}
