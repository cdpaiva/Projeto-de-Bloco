package br.edu.infnet.infra.vagas;

import br.edu.infnet.domain.vagas.Vaga;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import java.util.List;
import javax.ws.rs.core.MediaType;

public class VagaService {

    private final String REST_URI = "http://localhost:8082/vagas";
    private final Client client = ClientBuilder.newClient();

    public List<Vaga> listarPorIdUsuario(int idUsuario) {

        return client
                .target(REST_URI)
                .path("usuario")
                .path(String.valueOf(idUsuario))
                .request(MediaType.APPLICATION_JSON)
                .get(List.class);
    }

    public Vaga publicarVaga(Vaga vaga) {

        return client
                .target(REST_URI)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(vaga, MediaType.APPLICATION_JSON), Vaga.class);
    }

    public List<Vaga> pesquisarVaga(String pesquisa) {
        return client
                .target(REST_URI)
                .path("cargo")
                .path(pesquisa)
                .request(MediaType.APPLICATION_JSON)
                .get(List.class);
    }

}
