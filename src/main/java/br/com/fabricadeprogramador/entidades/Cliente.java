package br.com.fabricadeprogramador.entidades;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matheus on 14/04/2016.
 */

@Entity
public class Cliente extends EntidadeBase{
    @Column(nullable = false, length = 35)
    private String nome;

    @JoinColumn
    @ManyToOne(cascade = CascadeType.ALL)
    private Cidade cidade;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable
    private List<Contato> contato = new ArrayList<>();


    public Cliente() {
    }

    public Cliente(String nome, Cidade cidade, List<Contato> contato) {
        this.nome = nome;
        this.cidade = cidade;
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Contato> getContato() {
        return contato;
    }

    public void setContato(List<Contato> contato) {
        this.contato = contato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        if (!super.equals(o)) return false;

        Cliente cliente = (Cliente) o;

        if (getNome() != null ? !getNome().equals(cliente.getNome()) : cliente.getNome() != null) return false;
        if (getCidade() != null ? !getCidade().equals(cliente.getCidade()) : cliente.getCidade() != null) return false;
        return getContato() != null ? getContato().equals(cliente.getContato()) : cliente.getContato() == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getNome() != null ? getNome().hashCode() : 0);
        result = 31 * result + (getCidade() != null ? getCidade().hashCode() : 0);
        result = 31 * result + (getContato() != null ? getContato().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cidade=" + cidade +
                ", contato=" + contato +
                '}';
    }
}
