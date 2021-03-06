/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.asfecer.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Adriano Xavier
 */
@Entity
@Table(name = "itensreceituario")
@NamedQueries({
    @NamedQuery(name = "Itensreceituario.findAll", query = "SELECT i FROM Itensreceituario i")})
public class Itensreceituario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDITENSRECEITUARIO")
    private Integer iditensreceituario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DOSE")
    private String dose;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDEM")
    private int ordem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "POSOLOGIA")
    private String posologia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTIDADE")
    private int quantidade;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPOUSO")
    private boolean tipouso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoReceituario")
    private Collection<Receituario> receituarioCollection;
    @JoinColumn(name = "Medicamento", referencedColumnName = "IDMEDICAMENTO")
    @ManyToOne(optional = false)
    private Medicamento medicamento;

    public Itensreceituario() {
    }

    public Itensreceituario(Integer iditensreceituario) {
        this.iditensreceituario = iditensreceituario;
    }

    public Itensreceituario(Integer iditensreceituario, String dose, int ordem, String posologia, int quantidade, boolean tipouso) {
        this.iditensreceituario = iditensreceituario;
        this.dose = dose;
        this.ordem = ordem;
        this.posologia = posologia;
        this.quantidade = quantidade;
        this.tipouso = tipouso;
    }

    public Integer getIditensreceituario() {
        return iditensreceituario;
    }

    public void setIditensreceituario(Integer iditensreceituario) {
        this.iditensreceituario = iditensreceituario;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public String getPosologia() {
        return posologia;
    }

    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean getTipouso() {
        return tipouso;
    }

    public void setTipouso(boolean tipouso) {
        this.tipouso = tipouso;
    }

    public Collection<Receituario> getReceituarioCollection() {
        return receituarioCollection;
    }

    public void setReceituarioCollection(Collection<Receituario> receituarioCollection) {
        this.receituarioCollection = receituarioCollection;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iditensreceituario != null ? iditensreceituario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itensreceituario)) {
            return false;
        }
        Itensreceituario other = (Itensreceituario) object;
        if ((this.iditensreceituario == null && other.iditensreceituario != null) || (this.iditensreceituario != null && !this.iditensreceituario.equals(other.iditensreceituario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.asfecer.model.Itensreceituario[ iditensreceituario=" + iditensreceituario + " ]";
    }
    
}
