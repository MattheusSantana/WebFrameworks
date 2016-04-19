package br.com.fabricadeprogramador.DAO;

import br.com.fabricadeprogramador.Exeptions.DAOExeption;
import br.com.fabricadeprogramador.entidades.EntidadeBase;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Matheus on 15/04/2016.
 */
@Repository
@Transactional
public class GenericDAO < T extends EntidadeBase > {

    @PersistenceContext
    public EntityManager em;


    @Transactional
    public T salvar(T t ) throws DAOExeption {
        try {
            if (t.getId() == null) {
                 em.persist(t);
                System.out.println("Salvo!");
            }else{
                System.out.println("Alterado!");
                return em.merge(t);
            }
        }catch (Exception e ){
            throw new DAOExeption("Erro ao salvar!", e.getMessage());


        }
        return null;
    }


    @Transactional
    public void excluir(Class<T> clazz, long id) throws DAOExeption {
       try {
           T t = em.find(clazz, id);
           em.remove(t);
       }catch(Exception e){
          throw new DAOExeption("Impossível excluir", e.getMessage());

       }
    }

    @Transactional
    public T buscarPorId(Class<T> clazz, long id) throws DAOExeption {
        T t = null;
        try {
          return t = em.find(clazz, id );
        }catch (Exception e) {
            throw new DAOExeption("Não encontrado!", e.getMessage());

        }
    }


}
