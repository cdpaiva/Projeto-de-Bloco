package br.edu.infnet.venturaHR_web2.service;

import br.edu.infnet.venturaHR_web2.domain.Resposta;
import br.edu.infnet.venturaHR_web2.domain.Vaga;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CandidatoService {

    private final String url = "http://localhost:8083/resposta";

    @Autowired
    RestTemplate restTemplate;

    public Resposta responderVaga(Resposta resposta) {
        return restTemplate.postForObject(url, resposta, Resposta.class);

    }

    public List<Resposta> obterRespostasPorIdUsuario(Integer id) {

        String uriVagas = url + "/usuario/" + id;

        ResponseEntity<List<Resposta>> respostas = restTemplate.exchange(uriVagas,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Resposta>>() {
        });
        return respostas.getBody();
    }
}
