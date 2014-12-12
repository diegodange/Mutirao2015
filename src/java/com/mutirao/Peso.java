/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mutirao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
 * @author sistemas
 */
@Entity
@Table(name = "peso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Peso.findAll", query = "SELECT p FROM Peso p"),
    @NamedQuery(name = "Peso.findByIdpeso", query = "SELECT p FROM Peso p WHERE p.idpeso = :idpeso"),
    @NamedQuery(name = "Peso.findByQuantidadepeso", query = "SELECT p FROM Peso p WHERE p.quantidadepeso = :quantidadepeso"),
    @NamedQuery(name = "Peso.findByUnidadepeso", query = "SELECT p FROM Peso p WHERE p.unidadepeso = :unidadepeso")})
public class Peso implements Serializable {
    @ManyToMany(mappedBy = "pesoCollection")
    private Collection<Alimento> alimentoCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpeso")
    private Integer idpeso;
    @Column(name = "quantidadepeso")
    private Integer quantidadepeso;
    @Size(max = 255)
    @Column(name = "unidadepeso")
    private String unidadepeso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pesoIdpeso")
    private List<AlimentoPeso> alimentoPesoList;

    public Peso() {
    }

    public Peso(Integer idpeso) {
        this.idpeso = idpeso;
    }

    public Integer getIdpeso() {
        return idpeso;
    }

    public void setIdpeso(Integer idpeso) {
        this.idpeso = idpeso;
    }

    public Integer getQuantidadepeso() {
        return quantidadepeso;
    }

    public void setQuantidadepeso(Integer quantidadepeso) {
        this.quantidadepeso = quantidadepeso;
    }

    public String getUnidadepeso() {
        return unidadepeso;
    }

    public void setUnidadepeso(String unidadepeso) {
        this.unidadepeso = unidadepeso;
    }

    @XmlTransient
    public List<AlimentoPeso> getAlimentoPesoList() {
        return alimentoPesoList;
    }

    public void setAlimentoPesoList(List<AlimentoPeso> alimentoPesoList) {
        this.alimentoPesoList = alimentoPesoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpeso != null ? idpeso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Peso)) {
            return false;
        }
        Peso other = (Peso) object;
        if ((this.idpeso == null && other.idpeso != null) || (this.idpeso != null && !this.idpeso.equals(other.idpeso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.quantidadepeso + " " + this.unidadepeso;
    }

    @XmlTransient
    public Collection<Alimento> getAlimentoCollection() {
        return alimentoCollection;
    }

    public void setAlimentoCollection(Collection<Alimento> alimentoCollection) {
        this.alimentoCollection = alimentoCollection;
    }
    
}
