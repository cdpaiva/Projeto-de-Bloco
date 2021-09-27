package br.edu.infnet.venturaHR_web2.controller;

import br.edu.infnet.venturaHR_web2.domain.Criterio;
import br.edu.infnet.venturaHR_web2.domain.Resposta;
import br.edu.infnet.venturaHR_web2.domain.RespostaCriterio;
import br.edu.infnet.venturaHR_web2.domain.Usuario;
import br.edu.infnet.venturaHR_web2.domain.Vaga;
import br.edu.infnet.venturaHR_web2.service.CandidatoService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("respostasCriterios")
@Controller
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @PostMapping(value = "/usuarios/resposta/adicionarRespostaCriterio")
    public String adicionarCriterio(Model model, RespostaCriterio rc,
            @RequestParam Integer idCriterio,
            @SessionAttribute Vaga vaga) {

        List<RespostaCriterio> respostasCriterios = 
                (List) model.getAttribute("respostasCriterios");

        if (respostasCriterios == null) {
            respostasCriterios = new ArrayList<>();
        }
        //Associação da RespostaCriterio ao seu Critério
        List<Criterio> criterios = vaga.getCriterios();
        for (Criterio criterio : criterios) {
            if (Objects.equals(criterio.getId(), idCriterio)) {
                rc.setCriterio(criterio);
            }
        }

        respostasCriterios.add(rc);
        model.addAttribute("respostasCriterios", respostasCriterios);

        return "usuarios/candidatos/detalhesVaga";
    }

    @PostMapping(value = "/usuarios/candidatos/responderVaga")
    public String responderVaga(Model model,
            @SessionAttribute(required = true, name = "user") Usuario usuario,
            @SessionAttribute(required = true) Vaga vaga) {

        List<RespostaCriterio> respostasCriterios = 
                (List<RespostaCriterio>) model.getAttribute("respostasCriterios");

        if (respostasCriterios == null || respostasCriterios.isEmpty()) {
            model.addAttribute("msg", "Impossível submeter a resposta");
            return "usuarios/candidatos/detalhesVaga";
        }

        Resposta respostaVaga = new Resposta();

        respostaVaga.setUsuario(usuario);
        respostaVaga.setVaga(vaga);
        respostaVaga.setRespostasCriterios(respostasCriterios);
        respostaVaga.setData(Calendar.getInstance().getTime());
        //TODO: Implementar método para calcular o índice
        respostaVaga.setIndice(7);

        Resposta novaResposta = candidatoService.responderVaga(respostaVaga);

        if (novaResposta != null) {
            model.addAttribute("msg", "Vaga respondida");
            model.addAttribute("respostasCriterios", new ArrayList<>());
        }

        return "usuarios/candidatos/detalhesVaga";
    }

    @GetMapping(value = "usuarios/candidatos/listaRespostas")
    public String listaRespostas(Model model,
            @SessionAttribute(name = "user") Usuario usuario) {

        List<Resposta> respostas = candidatoService.
                obterRespostasPorIdUsuario(usuario.getId());

        if (respostas != null && !respostas.isEmpty()) {
            model.addAttribute("respostas", respostas);
        } else {
            model.addAttribute("msg", "Falha ao obter a lista");
        }

        return "usuarios/candidatos/listaRespostas";
    }
}
