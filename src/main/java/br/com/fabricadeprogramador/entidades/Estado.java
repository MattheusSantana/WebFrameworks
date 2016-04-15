package br.com.fabricadeprogramador.entidades;

import javax.persistence.*;

/**
 * Created by Matheus on 05/04/2016.
 */


@Entity
public class Estado extends EntidadeBase{


    @Column(nullable = false, length =20)
    private String nome;

    @Column(nullable = false, length = 2)
    private String uf;


    public Estado() {
    }

    public Estado(String nome, String uf) {
        this.nome = nome;
        this.uf = uf;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estado)) return false;

        Estado estado = (Estado) o;

        if (getNome() != null ? !getNome().equals(estado.getNome()) : estado.getNome() != null) return false;
        return getUf() != null ? getUf().equals(estado.getUf()) : estado.getUf() == null;

    }

    @Override
    public int hashCode() {
        int result = getNome() != null ? getNome().hashCode() : 0;
        result = 31 * result + (getUf() != null ? getUf().hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "- "+ uf;
    }
}
