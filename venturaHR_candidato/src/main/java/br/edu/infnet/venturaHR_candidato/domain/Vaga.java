/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.venturaHR_candidato.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author cdpaiva
 */
@Entity
@Table(name = "vagas", catalog = "ads_m_2021", schema = "")
@NamedQueries({
    @NamedQuery(name = "Vaga.findAll", query = "SELECT v FROM Vaga v")})
public class Vaga implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "cargo", nullable = false, length = 45)
    private String cargo;
    @Basic(optional = false)
    @Column(name = "cidade", nullable = false, length = 45)
    private String cidade;
    @Basic(optional = false)
    @Column(name = "forma_contratacao", nullable = false, length = 45)
    private String formaContratacao;
    @JsonIgnore
    @JoinColumns({
        @JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = false)})
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVaga")
    private List<Criterio> criterioList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vaga")
    private List<Resposta> respostaList;

    public Vaga() {
    }

    public Vaga(Integer id) {
        this.id = id;
    }

    public Vaga(Integer id, String cargo, String cidade, String formaContratacao) {
        this.id = id;
        this.cargo = cargo;
        this.cidade = cidade;
        this.formaContratacao = formaContratacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getFormaContratacao() {
        return formaContratacao;
    }

    public void setFormaContratacao(String formaContratacao) {
        this.formaContratacao = formaContratacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Criterio> getCriterioList() {
        return criterioList;
    }

    public void setCriterioList(List<Criterio> criterioList) {
        this.criterioList = criterioList;
    }

    public List<Resposta> getRespostaList() {
        return respostaList;
    }

    public void setRespostaList(List<Resposta> respostaList) {
        this.respostaList = respostaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vaga)) {
            return false;
        }
        Vaga other = (Vaga) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.infnet.venturaHR_candidato.domain.Vaga[ id=" + id + " ]";
    }
    
}
