package br.edu.infnet.app;

import br.edu.infnet.domain.Criterio;
import br.edu.infnet.domain.Vaga;
import br.edu.infnet.infra.VagaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/vagas"})
public class VagaController {

    @Autowired
    private VagaRepository vagaRepository;

    @GetMapping(path = "/usuario/{idUsuario}")
    public ResponseEntity listarPorIdUsuario(@PathVariable int idUsuario) {

        ResponseEntity retorno = ResponseEntity.notFound().build();

        try {

            List<Vaga> vagas = vagaRepository.findByIdUsuario(idUsuario);
            if (!vagas.isEmpty()) {
                retorno = ResponseEntity.ok(vagas);
            }

        } catch (Exception e) {
        }

        return retorno;
    }

    @GetMapping(path = "/cargo/{pesquisa}")
    public ResponseEntity pesquisarVagasPorCargo(@PathVariable String pesquisa) {

        ResponseEntity retorno = ResponseEntity.notFound().build();

        try {

            List<Vaga> vagas = vagaRepository.findByCargoContainingIgnoreCase(pesquisa);
            if (!vagas.isEmpty()) {
                retorno = ResponseEntity.ok(vagas);
            }

        } catch (Exception e) {
        }

        return retorno;
    }
    
    @GetMapping(path = "/cidade/{pesquisa}")
    public ResponseEntity pesquisarVagasPorCidade(@PathVariable String pesquisa) {

        ResponseEntity retorno = ResponseEntity.notFound().build();

        try {

            List<Vaga> vagas = vagaRepository.findByCidadeContainingIgnoreCase(pesquisa);
            if (!vagas.isEmpty()) {
                retorno = ResponseEntity.ok(vagas);
            }

        } catch (Exception e) {
        }

        return retorno;
    }
    
    @PostMapping
    public ResponseEntity publicarVaga(@RequestBody Vaga vaga){
        
        List<Criterio> criterios = vaga.getCriterios();
        
        if(criterios!=null && !criterios.isEmpty()){
            for(Criterio criterio: criterios){
                criterio.setVaga(vaga);
            }
            Vaga vagasGravadas = vagaRepository.save(vaga);
            return new ResponseEntity(vagasGravadas, HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
