/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.venturaHR_candidato.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author cdpaiva
 */
@Entity
@Table(name = "respostas_criterios", catalog = "ads_m_2021", schema = "")
@NamedQueries({
    @NamedQuery(name = "RespostaCriterio.findAll", query = "SELECT r FROM RespostaCriterio r")})
public class RespostaCriterio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "resposta_criterio")
    private int respostaCriterio;
    @JoinColumn(name = "id_criterio", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Criterio criterio;
    @JsonIgnore
    @JoinColumn(name = "id_resposta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Resposta resposta;

    public RespostaCriterio() {
    }

    public RespostaCriterio(Integer id) {
        this.id = id;
    }

    public RespostaCriterio(Integer id, int respostaCriterio) {
        this.id = id;
        this.respostaCriterio = respostaCriterio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRespostaCriterio() {
        return respostaCriterio;
    }

    public void setRespostaCriterio(int respostaCriterio) {
        this.respostaCriterio = respostaCriterio;
    }

    public Criterio getCriterio() {
        return criterio;
    }

    public void setCriterio(Criterio criterio) {
        this.criterio = criterio;
    }
    @JsonIgnore
    public Resposta getResposta() {
        return resposta;
    }

    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
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
        if (!(object instanceof RespostaCriterio)) {
            return false;
        }
        RespostaCriterio other = (RespostaCriterio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.infnet.venturaHR_candidato.domain.RespostaCriterio[ id=" + id + " ]";
    }
    
}
