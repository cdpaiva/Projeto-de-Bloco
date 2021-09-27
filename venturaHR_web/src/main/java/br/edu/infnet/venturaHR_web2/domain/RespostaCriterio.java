package br.edu.infnet.venturaHR_web2.domain;

public class RespostaCriterio {

    private Integer id;
    private int respostaCriterio;
    private Criterio criterio;
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
        return "br.edu.infnet.venturaHR_candidato.domain.RespostasCriterios[ id=" + id + " ]";
    }

}
