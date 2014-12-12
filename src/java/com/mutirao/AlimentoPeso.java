/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mutirao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sistemas
 */
@Entity
@Table(name = "alimento_has_peso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlimentoPeso.findAll", query = "SELECT a FROM AlimentoPeso a"),
    @NamedQuery(name = "AlimentoPeso.findByCodAlimento", query = "SELECT a FROM AlimentoPeso a WHERE a.codAlimento = :codAlimento")})
public class AlimentoPeso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_alimento")
    private Integer codAlimento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alimentoHasPesoCodAlimento")
    private List<Doacao> doacaoList;
    @JoinColumn(name = "alimento_idalimento", referencedColumnName = "idalimento")
    @ManyToOne(optional = false)
    private Alimento alimentoIdalimento;
    @JoinColumn(name = "peso_idpeso", referencedColumnName = "idpeso")
    @ManyToOne(optional = false)
    private Peso pesoIdpeso;

    public AlimentoPeso() {
    }

    public AlimentoPeso(Integer codAlimento) {
        this.codAlimento = codAlimento;
    }

    public Integer getCodAlimento() {
        return codAlimento;
    }

    public void setCodAlimento(Integer codAlimento) {
        this.codAlimento = codAlimento;
    }

    @XmlTransient
    public List<Doacao> getDoacaoList() {
        return doacaoList;
    }

    public void setDoacaoList(List<Doacao> doacaoList) {
        this.doacaoList = doacaoList;
    }

    public Alimento getAlimentoIdalimento() {
        return alimentoIdalimento;
    }

    public void setAlimentoIdalimento(Alimento alimentoIdalimento) {
        this.alimentoIdalimento = alimentoIdalimento;
    }

    public Peso getPesoIdpeso() {
        return pesoIdpeso;
    }

    public void setPesoIdpeso(Peso pesoIdpeso) {
        this.pesoIdpeso = pesoIdpeso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAlimento != null ? codAlimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlimentoPeso)) {
            return false;
        }
        AlimentoPeso other = (AlimentoPeso) object;
        if ((this.codAlimento == null && other.codAlimento != null) || (this.codAlimento != null && !this.codAlimento.equals(other.codAlimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.alimentoIdalimento + "" +  this.pesoIdpeso;
    }
    
}
