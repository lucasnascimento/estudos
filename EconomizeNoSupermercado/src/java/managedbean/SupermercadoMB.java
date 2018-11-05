//Olhar CursoMB
package managedbean;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import dao.SupermercadoDao;
import entidades.TbSupermercado;
import javax.faces.model.ListDataModel;



@ManagedBean(name = "supermercadoMB")
@SessionScoped
public class SupermercadoMB {
    private TbSupermercado supermercadoTb;
    private SupermercadoDao DaoSupermercado;
    private ListDataModel supermercados;

    public TbSupermercado getSupermercadoTb() {
        if (supermercadoTb == null){
            supermercadoTb = new TbSupermercado();
        }
        return supermercadoTb;
    }

    public void setSupermercadoTb(TbSupermercado supermercadoTb) {
        this.supermercadoTb = supermercadoTb;
    }

    public ListDataModel getSupermercados() {
        return supermercados;
    }

    public void setSupermercados(ListDataModel supermercados) {
        this.supermercados = supermercados;
    }
    
    public void recuperarSupermercados(){
        DaoSupermercado = new SupermercadoDao();
        this.supermercados = new ListDataModel(DaoSupermercado.recuperarTodosSupermercados());
    }
    
    public String Opc(){
         return "/Opcoes";
    }
    
    public String salvar(){
        DaoSupermercado = new SupermercadoDao();
        DaoSupermercado.salvar(supermercadoTb);        
        return "/ProdutoCadastrado";
    }
    
    public String montarSalvar(){
        supermercadoTb = null;
        return "/SupermercadoCadastrado";
    }
}