package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoUtil {
    private static EntityManagerFactory emf;
    public static EntityManager em;
    
    public void abreConexao(){
        emf = Persistence.createEntityManagerFactory("EconomizeNoSupermercadoPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }
    
    public void fechaConexao(){
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    public void salvar(Object O){
        this.abreConexao();
        em.persist(O);
        this.fechaConexao();
    }
    
    public void alterar(Object O){
        this.abreConexao();
        em.merge(O);
        this.fechaConexao();
    }
    
    public void excluir(Object O){
        this.abreConexao();
        em.remove(em.merge(O));
        this.fechaConexao();
    }
}