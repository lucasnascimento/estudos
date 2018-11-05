//Tem mais código
//Tem chave estrangeira
//Olhar alunoMB
package managedbean;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import dao.ProdutosDao;
import dao.SupermercadoDao;
import entidades.TbProdutos;
import entidades.TbSupermercado;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;


@ManagedBean(name = "produtoMB")
@SessionScoped
public class ProdutoMB {
    //Atributos
    private TbProdutos produtoTbProd;
    private ProdutosDao produtoDAO;
    private SupermercadoDao Daosuper;
    private ListDataModel produtosLDM;
    private ListDataModel superLDM;
    private TbSupermercado tbSupermercado;
    private String idSupermercado;
    private TbSupermercado produtoTbSuper;

    //Métodos gets e sets
    public ListDataModel getSuperLDM() {
        return superLDM;
    }

    public void setSuperLDM(ListDataModel superLDM) {
        this.superLDM = superLDM;
    }
    
    public TbProdutos getProdutoTbProd() {
        if (produtoTbProd == null) {
            produtoTbProd = new TbProdutos();
        }
        return produtoTbProd;
    }

    public void setProdutoTbProd(TbProdutos produtoTbProd) {
        this.produtoTbProd = produtoTbProd;
    }

    public ListDataModel getProdutosLDM() {
        return produtosLDM;
    }

    public void setProdutosLDM(ListDataModel produtosLDM) {
        this.produtosLDM = produtosLDM;
    }

    public String getIdSupermercado() {
        return idSupermercado;
    }

    public void setIdSupermercado(String idSupermercado) {
        this.idSupermercado = idSupermercado;
    }

    public TbSupermercado getProdutoTbSuper() {
        if (produtoTbSuper == null) {
            produtoTbSuper = new TbSupermercado();
        }
        return produtoTbSuper;
    }

    public void setProdutoTbSuper(TbSupermercado produtoTbSuper) {
        this.produtoTbSuper = produtoTbSuper;
    }
    
    //Metodos para combinar com as Views
    public void recuperarProdutos(){
        produtoDAO = new ProdutosDao();
        this.produtosLDM = new ListDataModel(produtoDAO.recuperarTodosProdutos());
    }
    
    
    public void recuperarSuper(){
        // Daosuper = new SupermercadoDao();
        // this.superLDM = new ListDataModel(Daosuper.recuperarTodosSupermercados());
        
        produtoDAO = new ProdutosDao();
        this.produtosLDM = new ListDataModel(produtoDAO.recuperarTodosProdutosSuper(idSupermercado));
    }
  
    public String separaProduto(){
        this.tbSupermercado = (TbSupermercado) getSuperLDM().getRowData();
        this.setIdSupermercado(this.tbSupermercado.getCnpj()); // obj do supermercado
        
        //produtoDAO = new ProdutosDao();
        //this.produtosLDM = new ListDataModel(produtoDAO.recuperarTodosProdutosSuper(idSupermercado));
        return "/BuscarProduto";
    }
    
    public String montarSalvar() {
        produtoTbProd = null;
        
        return "/ProdutoCadastrado";
    } 
    
    public String salvar() {
        produtoDAO = new ProdutosDao();
        produtoTbSuper = new TbSupermercado();
        produtoTbSuper.setCnpj(idSupermercado);
        this.produtoTbProd.setCnpj(produtoTbSuper);
        produtoDAO.salvar(produtoTbProd);
        produtoTbProd = new TbProdutos(); //Limpa os campos ao salvar
        return "/ProdutoCadastrado";
    }
     
    public String montarExcluir(){
        this.produtoTbProd = (TbProdutos) getProdutosLDM().getRowData();
        this.setIdSupermercado(this.produtoTbProd.getCnpj().getCnpj());
        return "/ExcluirProduto";
    }
     
    public String excluir() { 
        produtoDAO = new ProdutosDao();
        produtoTbSuper = new TbSupermercado();
        produtoTbSuper.setCnpj(idSupermercado);
        this.produtoTbProd.setCnpj(produtoTbSuper);
        produtoDAO.excluir(produtoTbProd);
        return "/MostrarProduto";
    }
     
    public String montarAlterar(){
        this.produtoTbProd = (TbProdutos) getProdutosLDM().getRowData();
        this.setIdSupermercado(this.produtoTbProd.getCnpj().getCnpj());
        return "/AlterarProduto";
    }  
     
    public String alterar() {
        produtoDAO = new ProdutosDao();
        produtoTbSuper = new TbSupermercado();
        produtoTbSuper.setCnpj(idSupermercado);
        this.produtoTbProd.setCnpj(produtoTbSuper);
        produtoDAO.alterar(produtoTbProd);
        return "/MostrarProduto";
    }
    
    public String Mostrar(){
        return "/MostrarProduto";
    }
    
    public String Opc(){
        return "/Opcoes";
    }
     
    public String Menu(){
        return "/Menu";
    }
    
    public String BuscarProduto(){
        return "/BuscarProduto";
    }
      
    public String EscolheSuper(){ 
        return "/EscolheSuper";
    }
       
    public SelectItem[] getSupermercados() {
        SupermercadoDao superDAO = new SupermercadoDao();
        List<TbSupermercado> superCadastrados = superDAO.recuperarTodosSupermercados();
        SelectItem[] supermercados = new SelectItem[superCadastrados.size()];
        Integer i = 0;
        for (TbSupermercado superm : superCadastrados) {
            supermercados[i++] = new SelectItem(superm.getCnpj(), superm.getNome());
        }
        return supermercados;
    }
       
}