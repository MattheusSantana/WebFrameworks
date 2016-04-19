package br.com.fabricadeprogramador.Controller;

import br.com.fabricadeprogramador.Exeptions.ServiceException;
import br.com.fabricadeprogramador.Service.ClienteService;
import br.com.fabricadeprogramador.entidades.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Matheus on 18/04/2016.
 */

@Controller
public class ClienteController {


    private Cliente cliente;

    @Autowired
    private ClienteService clienteService;


    public ClienteController() {
    cliente = new Cliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void salvar(){
        if (cliente.getId() == null){
            try {
                clienteService.salvar(cliente);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }
    }

}
