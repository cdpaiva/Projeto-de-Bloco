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
@Table(name = "criterios", catalog = "ads_m_2021", schema = "")
@NamedQueries({
    @NamedQuery(name = "Criterio.findAll", query = "SELECT c FROM Criterio c")})
public class Criterio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "descricao", nullable = false, length = 45)
    private String descricao;
    @Basic(optional = false)
    @Column(name = "perfil", nullable = false)
    private int perfil;
    @Basic(optional = false)
    @Column(name = "peso", nullable = false)
    private int peso;
    @JsonIgnore
    @JoinColumn(name = "id_vaga", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Vaga idVaga;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "criterio")
    private List<RespostaCriterio> respostaCriterioList;

    public Criterio() {
    }

    public Criterio(Integer id) {
        this.id = id;
    }

    public Criterio(Integer id, String descricao, int perfil, int peso) {
        this.id = id;
        this.descricao = descricao;
        this.perfil = perfil;
        this.peso = peso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Vaga getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(Vaga idVaga) {
        this.idVaga = idVaga;
    }
    @JsonIgnore
    public List<RespostaCriterio> getRespostaCriterioList() {
        return respostaCriterioList;
    }

    public void setRespostaCriterioList(List<RespostaCriterio> respostaCriterioList) {
        this.respostaCriterioList = respostaCriterioList;
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
        if (!(object instanceof Criterio)) {
            return false;
        }
        Criterio other = (Criterio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.infnet.venturaHR_candidato.domain.Criterio[ id=" + id + " ]";
    }
    
}
