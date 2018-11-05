package dao;

import entidades.TbSupermercado;
import java.util.List;


public class SupermercadoDao extends DaoUtil {
    
    public List<TbSupermercado> recuperarTodosSupermercados(){
       List<TbSupermercado> supermercados; 
       this.abreConexao();
       supermercados = em.createQuery("select s from TbSupermercado as s").getResultList();
       this.fechaConexao();
       return supermercados;
    }
}
