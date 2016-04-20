package br.com.fabricadeprogramador.Service;

import br.com.fabricadeprogramador.DAO.ClienteDAO;
import br.com.fabricadeprogramador.DAO.EstadoDAO;
import br.com.fabricadeprogramador.Exeptions.DAOExeption;
import br.com.fabricadeprogramador.Exeptions.ServiceException;
import br.com.fabricadeprogramador.entidades.Cliente;
import br.com.fabricadeprogramador.entidades.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Matheus on 18/04/2016.
 */
@Service
public class ClienteService {

    @Autowired
    ClienteDAO clienteDAO;

    @Autowired
    EstadoDAO estadoDAO;

    public Cliente salvar (Cliente cliente) throws ServiceException {
            Cliente clienteRetorno;
        try {
           clienteRetorno = clienteDAO.buscarPorId(Cliente.class, cliente.getId());

            if (clienteRetorno.getId()== null){
                System.out.println("Salvo");
               return clienteDAO.salvar(cliente);
            }

            if (cliente.getId()!= null) {
                System.out.println("Alterado!");
                return clienteDAO.salvar(cliente);
            }
        } catch (DAOExeption e) {
            throw new ServiceException(e.getMessage());
        }
        return null;
    }

    public List<Estado> buscarTodos() {

        return estadoDAO.buscarTodos();

    }

    public Estado buscarPorIdEstado(long id) throws ServiceException {
        try {
            return estadoDAO.buscarPorId(Estado.class, id);
        } catch (DAOExeption e) {
            throw new ServiceException("Impossível realizar a busca!");

        }
    }
}
