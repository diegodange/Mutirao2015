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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "alimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alimento.findAll", query = "SELECT a FROM Alimento a"),
    @NamedQuery(name = "Alimento.findByIdalimento", query = "SELECT a FROM Alimento a WHERE a.idalimento = :idalimento"),
    @NamedQuery(name = "Alimento.findByNomealimento", query = "SELECT a FROM Alimento a WHERE a.nomealimento = :nomealimento")})
public class Alimento implements Serializable {
    @JoinTable(name = "alimentopeso", joinColumns = {
        @JoinColumn(name = "alimento_idalimento", referencedColumnName = "idalimento")}, inverseJoinColumns = {
        @JoinColumn(name = "peso_idpeso", referencedColumnName = "idpeso")})
    @ManyToMany
    private Collection<Peso> pesoCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idalimento")
    private Integer idalimento;
    @Size(max = 255)
    @Column(name = "nomealimento")
    private String nomealimento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alimentoIdalimento")
    private List<AlimentoPeso> alimentoPesoList;

    public Alimento() {
    }

    public Alimento(Integer idalimento) {
        this.idalimento = idalimento;
    }

    public Integer getIdalimento() {
        return idalimento;
    }

    public void setIdalimento(Integer idalimento) {
        this.idalimento = idalimento;
    }

    public String getNomealimento() {
        return nomealimento;
    }

    public void setNomealimento(String nomealimento) {
        this.nomealimento = nomealimento;
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
        hash += (idalimento != null ? idalimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alimento)) {
            return false;
        }
        Alimento other = (Alimento) object;
        if ((this.idalimento == null && other.idalimento != null) || (this.idalimento != null && !this.idalimento.equals(other.idalimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nomealimento;
    }

    @XmlTransient
    public Collection<Peso> getPesoCollection() {
        return pesoCollection;
    }

    public void setPesoCollection(Collection<Peso> pesoCollection) {
        this.pesoCollection = pesoCollection;
    }
    
}
