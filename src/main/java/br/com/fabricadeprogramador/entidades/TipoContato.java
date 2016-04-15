package br.com.fabricadeprogramador.entidades;

import javax.persistence.*;

/**
 * Created by Matheus on 05/04/2016.
 */

@Entity
public class TipoContato extends EntidadeBase{

    @Column(nullable = false, length = 25)
    private String tipo;

    public TipoContato() {
    }

    public TipoContato(String tipo) {
        this.tipo = tipo;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoContato)) return false;

        TipoContato that = (TipoContato) o;

        return getTipo() != null ? getTipo().equals(that.getTipo()) : that.getTipo() == null;

    }

    @Override
    public int hashCode() {
        return getTipo() != null ? getTipo().hashCode() : 0;
    }

    @Override
    public String toString() {
        return tipo;
    }
}
