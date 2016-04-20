package br.com.fabricadeprogramador.Controller;

import br.com.fabricadeprogramador.Exeptions.ServiceException;
import br.com.fabricadeprogramador.Service.ClienteService;
import br.com.fabricadeprogramador.entidades.Cliente;
import br.com.fabricadeprogramador.entidades.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Matheus on 18/04/2016.
 */

@Controller
public class ClienteController {



    @Autowired
    private ClienteService clienteService;

    private List<Estado> estados;

    private Cliente cliente;


    public ClienteController() {
        cliente = new Cliente();
    }


    public List<Estado> getEstados() {
        return clienteService.buscarTodos();
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
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
