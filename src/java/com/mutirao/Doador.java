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
@Table(name = "doador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doador.findAll", query = "SELECT d FROM Doador d"),
    @NamedQuery(name = "Doador.findByCpf", query = "SELECT d FROM Doador d WHERE d.cpf = :cpf"),
    @NamedQuery(name = "Doador.findByBairro", query = "SELECT d FROM Doador d WHERE d.bairro = :bairro"),
    @NamedQuery(name = "Doador.findByNome", query = "SELECT d FROM Doador d WHERE d.nome = :nome")})
public class Doador implements Serializable {
    @Column(name = "QUANTIDADE")
    private Integer quantidade;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cpf")
    private Integer cpf;
    @Size(max = 255)
    @Column(name = "bairro")
    private String bairro;
    @Size(max = 255)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doadorCpf")
    private List<Doacao> doacaoList;

    public Doador() {
    }

    public Doador(Integer cpf) {
        this.cpf = cpf;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<Doacao> getDoacaoList() {
        return doacaoList;
    }

    public void setDoacaoList(List<Doacao> doacaoList) {
        this.doacaoList = doacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpf != null ? cpf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doador)) {
            return false;
        }
        Doador other = (Doador) object;
        if ((this.cpf == null && other.cpf != null) || (this.cpf != null && !this.cpf.equals(other.cpf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
     return this.nome;
    }

   
    
}
