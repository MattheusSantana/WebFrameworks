package br.com.fabricadeprogramador.DAO;



import java.util.List;

/**
 * Created by Matheus on 05/04/2016.
 */
public interface DAO<T> {

    public T cadastrar(T obj);

    public T alterar(T obj);

    public T excluir(T obj);

    public T buscarPorNome(String string);

    public T buscarPorId(long id);

    public List<T> buscarTodos();

}