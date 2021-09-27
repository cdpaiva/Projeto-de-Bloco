package br.edu.infnet.venturaHR_web2.service;

import br.edu.infnet.venturaHR_web2.domain.Vaga;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VagaService {

    private final String url = "http://localhost:8082/vagas";

    @Autowired
    RestTemplate restTemplate;

    //Obter lista de vagas publicadas pela empresa
    public List<Vaga> obterVagasPorId(Integer id) {

        String uriVagas = url + "/usuario/" + id;

        ResponseEntity<List<Vaga>> vagas = restTemplate.exchange(uriVagas,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Vaga>>() {
        });
        return vagas.getBody();
    }

    public Vaga publicarVaga(Vaga vaga) {
        return restTemplate.postForObject(url, vaga, Vaga.class);
    }

    //Pesquisar vaga
    public List<Vaga> pesquisarVagasPorCargo(String cargo) {

        String uriPesquisa = url + "/cargo/" + cargo;
        ResponseEntity<List<Vaga>> vagas = null;
        try{
        vagas = restTemplate.exchange(
                uriPesquisa,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Vaga>>() {
        }
        );
        } catch (Exception e){
            
        }
        
        List<Vaga> resultados = new ArrayList<Vaga>();
        
        if (vagas != null && vagas.hasBody()){
            resultados = vagas.getBody();
        }

        return resultados;
    }
    
    public List<Vaga> pesquisarVagasPorCidade(String cidade) {
        String uriPesquisa = url + "/cidade/" + cidade;
        ResponseEntity<List<Vaga>> vagas = restTemplate.exchange(
                uriPesquisa,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Vaga>>() {
        }
        );

        return vagas.getBody();
    }

    public Vaga obterVagaPorIdVaga(Integer id) {
        String uri = url + "/" + id;
        return restTemplate.getForObject(uri, Vaga.class);
    }

    public int obterQuantidadeVagas() {
        return restTemplate.getForObject(url, Integer.class);
    }

    public Vaga obterVagaAleatoria() {
        int numVagas = obterQuantidadeVagas();
        Random r = new Random();
        return obterVagaPorIdVaga(r.nextInt(numVagas)+1);
    }
    
    public void excluir(Integer id){
        String uri = url + "/excluir/" + id;
        restTemplate.execute(uri, HttpMethod.GET, null, null);
    }

    
}
