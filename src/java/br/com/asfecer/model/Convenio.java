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
@Table(name = "convenio")
@NamedQueries({
    @NamedQuery(name = "Convenio.findAll", query = "SELECT c FROM Convenio c")})
public class Convenio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCONVENIO")
    private Integer idconvenio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "empresa_convenio")
    private String empresaConvenio;
    @Size(max = 300)
    @Column(name = "OBS")
    private String obs;
    @Column(name = "STATUS")
    private Boolean status;
    @Size(max = 20)
    @Column(name = "TELEFONE")
    private String telefone;
    @Size(max = 30)
    @Column(name = "tipo_convenio")
    private String tipoConvenio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "convenio")
    private Collection<Paciente> pacienteCollection;

    public Convenio() {
    }

    public Convenio(Integer idconvenio) {
        this.idconvenio = idconvenio;
    }

    public Convenio(Integer idconvenio, String empresaConvenio) {
        this.idconvenio = idconvenio;
        this.empresaConvenio = empresaConvenio;
    }

    public Integer getIdconvenio() {
        return idconvenio;
    }

    public void setIdconvenio(Integer idconvenio) {
        this.idconvenio = idconvenio;
    }

    public String getEmpresaConvenio() {
        return empresaConvenio;
    }

    public void setEmpresaConvenio(String empresaConvenio) {
        this.empresaConvenio = empresaConvenio;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipoConvenio() {
        return tipoConvenio;
    }

    public void setTipoConvenio(String tipoConvenio) {
        this.tipoConvenio = tipoConvenio;
    }

    public Collection<Paciente> getPacienteCollection() {
        return pacienteCollection;
    }

    public void setPacienteCollection(Collection<Paciente> pacienteCollection) {
        this.pacienteCollection = pacienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconvenio != null ? idconvenio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Convenio)) {
            return false;
        }
        Convenio other = (Convenio) object;
        if ((this.idconvenio == null && other.idconvenio != null) || (this.idconvenio != null && !this.idconvenio.equals(other.idconvenio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.asfecer.model.Convenio[ idconvenio=" + idconvenio + " ]";
    }
    
}
