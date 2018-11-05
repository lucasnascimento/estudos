package dao;

import entidades.TbProdutos;
import java.util.List;

public class ProdutosDao extends DaoUtil {
     public List<TbProdutos> recuperarTodosProdutos(){
       List<TbProdutos> produtos; 
       this.abreConexao();
       produtos = em.createQuery("select p from TbProdutos as p").getResultList();
       this.fechaConexao();
       return produtos;
    }
     public List<TbProdutos> recuperarTodosProdutosSuper(String cnpj){
       List<TbProdutos> produtos; 
       this.abreConexao();
       produtos = em.createQuery("select p from TbProdutos as p where cnpj = " + cnpj).getResultList();
       this.fechaConexao();
       return produtos;
    }     
    
     
  
}
