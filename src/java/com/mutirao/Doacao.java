/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mutirao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sistemas
 */
@Entity
@Table(name = "doacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doacao.findAll", query = "SELECT d FROM Doacao d"),
    @NamedQuery(name = "Doacao.findByCodigoDoacao", query = "SELECT d FROM Doacao d WHERE d.codigoDoacao = :codigoDoacao")})
public class Doacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_doacao")
    private Integer codigoDoacao;
    @JoinColumn(name = "doador_cpf", referencedColumnName = "cpf")
    @ManyToOne(optional = false)
    private Doador doadorCpf;
    @JoinColumn(name = "alimento_has_peso_cod_alimento", referencedColumnName = "cod_alimento")
    @ManyToOne(optional = false)
    private AlimentoPeso alimentoHasPesoCodAlimento;
    @Column(name = "QUANTIDADE")
    private Integer quantidade;
    
    
    public Doacao() {
    }

    public Doacao(Integer codigoDoacao) {
        this.codigoDoacao = codigoDoacao;
    }

    public Integer getCodigoDoacao() {
        return codigoDoacao;
    }

    public void setCodigoDoacao(Integer codigoDoacao) {
        this.codigoDoacao = codigoDoacao;
    }

    public Doador getDoadorCpf() {
        return doadorCpf;
    }

    public void setDoadorCpf(Doador doadorCpf) {
        this.doadorCpf = doadorCpf;
    }

    public AlimentoPeso getAlimentoHasPesoCodAlimento() {
        return alimentoHasPesoCodAlimento;
    }

    public void setAlimentoHasPesoCodAlimento(AlimentoPeso alimentoHasPesoCodAlimento) {
        this.alimentoHasPesoCodAlimento = alimentoHasPesoCodAlimento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoDoacao != null ? codigoDoacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doacao)) {
            return false;
        }
        Doacao other = (Doacao) object;
        if ((this.codigoDoacao == null && other.codigoDoacao != null) || (this.codigoDoacao != null && !this.codigoDoacao.equals(other.codigoDoacao))) {
            return false;
        }
        return true;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

       
    
    
    @Override
    public String toString() {
        return "com.mutirao.Doacao[ codigoDoacao=" + codigoDoacao + " ]";
    }
    
}
