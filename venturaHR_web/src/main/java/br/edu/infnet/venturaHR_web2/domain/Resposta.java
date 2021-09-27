
package br.edu.infnet.venturaHR_web2.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Resposta{
    
    private Integer id;
    private Date data;
    private Integer indice;
    private List<RespostaCriterio> respostasCriterios;
    private Usuario usuario;
    private Vaga vaga;

    public Resposta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getIndice() {
        return indice;
    }

    public void setIndice(Integer indice) {
        this.indice = indice;
    }

    public List<RespostaCriterio> getRespostasCriterios() {
        return respostasCriterios;
    }

    public void setRespostasCriterios(List<RespostaCriterio> respostasCriterios) {
        this.respostasCriterios = respostasCriterios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
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
        if (!(object instanceof Resposta)) {
            return false;
        }
        Resposta other = (Resposta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.infnet.venturaHR_candidato.domain.Respostas[ id=" + id + " ]";
    }
    
}
