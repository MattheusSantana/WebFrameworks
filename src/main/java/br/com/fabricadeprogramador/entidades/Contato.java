package br.com.fabricadeprogramador.entidades;

import javax.persistence.*;


/**
 * Created by Matheus on 05/04/2016.
 */

@Entity
public class Contato extends EntidadeBase{



    @Column(nullable = false, length = 30)
    private String contato;

    @JoinColumn
    @OneToOne(cascade = CascadeType.ALL)
    private TipoContato tipoContato;

    @JoinColumn
    @ManyToOne
    private Cliente cliente;

    public Contato() {
    }

    public Contato(String contato, TipoContato tipoContato) {
        this.contato = contato;
        this.tipoContato = tipoContato;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contato)) return false;
        if (!super.equals(o)) return false;

        Contato contato1 = (Contato) o;

        if (getContato() != null ? !getContato().equals(contato1.getContato()) : contato1.getContato() != null)
            return false;
        if (getTipoContato() != null ? !getTipoContato().equals(contato1.getTipoContato()) : contato1.getTipoContato() != null)
            return false;
        return getCliente() != null ? getCliente().equals(contato1.getCliente()) : contato1.getCliente() == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getContato() != null ? getContato().hashCode() : 0);
        result = 31 * result + (getTipoContato() != null ? getTipoContato().hashCode() : 0);
        result = 31 * result + (getCliente() != null ? getCliente().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return contato + tipoContato;
    }
}
