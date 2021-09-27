package br.edu.infnet.venturaHR_candidato.repository;

import br.edu.infnet.venturaHR_candidato.domain.Resposta;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoRepository extends CrudRepository<Resposta, Integer> {
    
    @Query("from Resposta r where r.usuario.id = :idUsuario")
    List<Resposta> findByIdUsuario(Integer idUsuario);
}
