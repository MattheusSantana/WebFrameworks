package br.com.fabricadeprogramador.entidades;

import javax.persistence.*;

/**
 * Created by Matheus on 05/04/2016.
 */


@Entity
public class Cidade extends EntidadeBase {

    @Column(nullable =false, length =30)
    private String nome;

    @JoinColumn
    @ManyToOne(cascade = CascadeType.ALL)
    private Estado estado;

    public Cidade() {
    }


    public Cidade(Estado estado, String nome) {
        this.estado = estado;
        this.nome = nome;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cidade)) return false;

        Cidade cidade = (Cidade) o;

        if (getNome() != null ? !getNome().equals(cidade.getNome()) : cidade.getNome() != null) return false;
        return getEstado() != null ? getEstado().equals(cidade.getEstado()) : cidade.getEstado() == null;

    }

    @Override
    public int hashCode() {
        int result = getNome() != null ? getNome().hashCode() : 0;
        result = 31 * result + (getEstado() != null ? getEstado().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "nome='" + nome + '\'' +
                ", estado=" + estado +
                '}';
    }
}
