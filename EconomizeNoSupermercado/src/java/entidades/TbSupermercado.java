/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vini
 */
@Entity
@Table(name = "tb_supermercado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbSupermercado.findAll", query = "SELECT t FROM TbSupermercado t")
    , @NamedQuery(name = "TbSupermercado.findByCnpj", query = "SELECT t FROM TbSupermercado t WHERE t.cnpj = :cnpj")
    , @NamedQuery(name = "TbSupermercado.findByNome", query = "SELECT t FROM TbSupermercado t WHERE t.nome = :nome")
    , @NamedQuery(name = "TbSupermercado.findByBairro", query = "SELECT t FROM TbSupermercado t WHERE t.bairro = :bairro")})
public class TbSupermercado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cnpj")
    private String cnpj;
    @Size(max = 30)
    @Column(name = "nome")
    private String nome;
    @Size(max = 30)
    @Column(name = "bairro")
    private String bairro;
    @OneToMany(mappedBy = "cnpj")
    private Collection<TbProdutos> tbProdutosCollection;

    public TbSupermercado() {
    }

    public TbSupermercado(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @XmlTransient
    public Collection<TbProdutos> getTbProdutosCollection() {
        return tbProdutosCollection;
    }

    public void setTbProdutosCollection(Collection<TbProdutos> tbProdutosCollection) {
        this.tbProdutosCollection = tbProdutosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cnpj != null ? cnpj.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbSupermercado)) {
            return false;
        }
        TbSupermercado other = (TbSupermercado) object;
        if ((this.cnpj == null && other.cnpj != null) || (this.cnpj != null && !this.cnpj.equals(other.cnpj))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TbSupermercado[ cnpj=" + cnpj + " ]";
    }
    
}
