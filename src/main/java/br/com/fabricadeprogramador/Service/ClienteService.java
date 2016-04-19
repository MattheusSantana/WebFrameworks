package br.com.fabricadeprogramador.Service;

import br.com.fabricadeprogramador.DAO.ClienteDAO;
import br.com.fabricadeprogramador.Exeptions.DAOExeption;
import br.com.fabricadeprogramador.Exeptions.ServiceException;
import br.com.fabricadeprogramador.entidades.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Matheus on 18/04/2016.
 */
@Service
public class ClienteService {

    @Autowired
    ClienteDAO clienteDAO;

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

}
