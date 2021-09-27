package br.edu.infnet.venturaHR_candidato.controller;

import br.edu.infnet.venturaHR_candidato.domain.Resposta;
import br.edu.infnet.venturaHR_candidato.domain.RespostaCriterio;
import br.edu.infnet.venturaHR_candidato.repository.CandidatoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CandidatoController {

    @Autowired
    CandidatoRepository candidatoRepository;

    @PostMapping(value = "/resposta")
    public ResponseEntity adicionarResposta(@RequestBody Resposta resposta) {

        List<RespostaCriterio> respostasCriterios = resposta.getRespostasCriterios();

        if (respostasCriterios != null && !respostasCriterios.isEmpty()) {
            for (RespostaCriterio rc : respostasCriterios) {
                rc.setResposta(resposta);
            }
        } else {
            return new ResponseEntity("Falha ao criar a resposta", HttpStatus.BAD_REQUEST);
        }

        Resposta novaResposta = candidatoRepository.save(resposta);
        return new ResponseEntity(novaResposta, HttpStatus.CREATED);
    }

    @GetMapping(path = "/resposta/usuario/{id}")
    public ResponseEntity listarPorUsuario(@PathVariable Integer id) {

        ResponseEntity retorno = ResponseEntity.notFound().build();

        List<Resposta> respostas = candidatoRepository.findByIdUsuario(id);
        if (!respostas.isEmpty()) {
            retorno = ResponseEntity.ok(respostas);
        }

        return retorno;
    }
}
