package br.com.fabricadeprogramador.Converter;

import br.com.fabricadeprogramador.Exeptions.ServiceException;
import br.com.fabricadeprogramador.Service.ClienteService;
import br.com.fabricadeprogramador.entidades.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 * Created by Matheus on 18/04/2016.
 */
@Component
public class EstadoConverter implements Converter{

    @Autowired
    ClienteService clienteService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {

       //Verificando se o valor a string vinda da tela não está nula ou vazia "".
        if (value==null || value.isEmpty())  return null;

        //Convertendo o ID que vem como String da tela para uma propriedade long id do objeto do tipo Estado.
        long id = Long.parseLong(value);
        Estado estado = null;
        try {
            estado = clienteService.buscarPorIdEstado(id);
            return estado;
        } catch (ServiceException e) {
            e.printStackTrace();
            System.out.println("Impossível realizar conversão de dados!");
        }
        return null;

    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object obj) {

        if(obj==null|| !(obj instanceof Estado)) return ""; // se o valor vindo da tela for nulo ele retorno vazio.

        //Convertendo o id do Objeto que vem do Controller para uma String para a tela
        Estado estado = (Estado)obj; //Fazendo um cast para estado pois o objeto vem como Object.
        return estado.getId().toString(); //Retornando o id para tela.
    }
}
