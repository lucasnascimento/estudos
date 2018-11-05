/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vini
 */
@Entity
@Table(name = "tb_produtos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbProdutos.findAll", query = "SELECT t FROM TbProdutos t")
    , @NamedQuery(name = "TbProdutos.findByCodigo", query = "SELECT t FROM TbProdutos t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "TbProdutos.findByNome", query = "SELECT t FROM TbProdutos t WHERE t.nome = :nome")
    , @NamedQuery(name = "TbProdutos.findByMarca", query = "SELECT t FROM TbProdutos t WHERE t.marca = :marca")
    , @NamedQuery(name = "TbProdutos.findByTipo", query = "SELECT t FROM TbProdutos t WHERE t.tipo = :tipo")
    , @NamedQuery(name = "TbProdutos.findByPeso", query = "SELECT t FROM TbProdutos t WHERE t.peso = :peso")
    , @NamedQuery(name = "TbProdutos.findByPreco", query = "SELECT t FROM TbProdutos t WHERE t.preco = :preco")})
public class TbProdutos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Size(max = 15)
    @Column(name = "nome")
    private String nome;
    @Size(max = 15)
    @Column(name = "marca")
    private String marca;
    @Size(max = 15)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 10)
    @Column(name = "peso")
    private String peso;
    @Size(max = 10)
    @Column(name = "preco")
    private String preco;
    @JoinColumn(name = "cnpj", referencedColumnName = "cnpj")
    @ManyToOne
    private TbSupermercado cnpj;

    public TbProdutos() {
    }

    public TbProdutos(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public TbSupermercado getCnpj() {
        return cnpj;
    }

    public void setCnpj(TbSupermercado cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbProdutos)) {
            return false;
        }
        TbProdutos other = (TbProdutos) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TbProdutos[ codigo=" + codigo + " ]";
    }
    
}
