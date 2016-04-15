package br.com.fabricadeprogramador.DAO;

import br.com.fabricadeprogramador.entidades.Cliente;
import br.com.fabricadeprogramador.entidades.EntidadeBase;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Matheus on 15/04/2016.
 */
@Repository
@Transactional
public class GenericDAO < T extends EntidadeBase > {

    @PersistenceContext
    public EntityManager em;


    @Transactional
    public T salvar(T t ){
        try {
            if (t.getId() == null) {
                 em.persist(t);
                System.out.println("Salvo!");
            }else{
                System.out.println("Alterado!");
                return em.merge(t);
            }
        }catch (Exception e ){
            System.out.println("Erro ao salvar!");
        }
        return null;
    }


    @Transactional
    public void excluir(Class<T> clazz, long id){
        T t = em.find(clazz, id);
        em.remove(t);

    }

    @Transactional
    public T buscarPorId(Class<T> clazz, long id){
        T t = null;
        try {
          return t = em.find(clazz, id );
        }catch (Exception e) {
            System.out.println("Não encontrado!");
        }
        return null;
    }


}
