package br.edu.infnet.domain.vagas;

import java.util.List;

public class Vaga{
    
    private Integer id;
    private String cargo;
    private String cidade;
    private String formaContratacao;
    private Integer idUsuario;
    private List<Criterio> criterios;

    public Vaga() {
    }

    public Vaga(Integer id) {
        this.id = id;
    }

    public Vaga(Integer id, String cargo, String cidade, String formaContratacao, Integer idUsuario) {
        this.id = id;
        this.cargo = cargo;
        this.cidade = cidade;
        this.formaContratacao = formaContratacao;
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<Criterio> getCriterios() {
        return criterios;
    }

    public void setCriterios(List<Criterio> criterios) {
        this.criterios = criterios;
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
        return "br.edu.infnet.domain.Vaga[ id=" + id + " ]";
    }

    public Vaga(Integer id, String cargo, String cidade) {
        this.id = id;
        this.cargo = cargo;
        this.cidade = cidade;
    }

}
