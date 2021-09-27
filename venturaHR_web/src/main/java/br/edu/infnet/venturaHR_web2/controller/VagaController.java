package br.edu.infnet.venturaHR_web2.controller;

import br.edu.infnet.venturaHR_web2.domain.Criterio;
import br.edu.infnet.venturaHR_web2.domain.Usuario;
import br.edu.infnet.venturaHR_web2.domain.Vaga;
import br.edu.infnet.venturaHR_web2.service.VagaService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes(names = {"vaga", "criterios"})
@Controller
public class VagaController {

    @Autowired
    private VagaService vagaService;

    @GetMapping(value = "/usuarios/empresas/publicarVaga")
    public String telaPublicarVaga() {
        
        return "usuarios/empresas/publicarVaga";
    }

    @PostMapping(value = "/usuarios/empresas/adicionarVaga")
    public String adicionarVaga(Model model, Vaga vaga, 
            @SessionAttribute Usuario user) {

        vaga.setIdUsuario(user.getId());
        model.addAttribute("vaga", vaga);
        
        return "usuarios/empresas/publicarVaga";
    }

    @PostMapping(value = "/usuarios/empresas/adicionarCriterio")
    public String adicionarCriterio(Model model, Criterio criterio) {

        List<Criterio> criterios = (List) model.getAttribute("criterios");
        
        if (criterios == null) {
            criterios = new ArrayList<>();
        }
        criterios.add(criterio);

        model.addAttribute("criterios", criterios);

        return "usuarios/empresas/publicarVaga";
    }

    @PostMapping(value = "/usuarios/empresas/publicarVaga")
    public String publicarVaga(Model model, HttpSession session) {

        Vaga vaga = (Vaga) model.getAttribute("vaga");
        List<Criterio> criterios = (List) model.getAttribute("criterios");
        
        if (criterios != null) {
            vaga.setCriterios(criterios);
        }
        
        vagaService.publicarVaga(vaga);

        model.addAttribute("msgSucesso", "Vaga publicada com sucesso");
        //Reiniciar os atributos de sessão manualmente
        model.addAttribute("criterios", new ArrayList<Criterio>());
        model.addAttribute("vaga", new Vaga());

        return "usuarios/empresas/publicarVaga";
    }

    @GetMapping(value = "/usuarios/candidatos/pesquisarCargo")
    public String pesquisarVagaPorCargo(Model model, @RequestParam String pesquisa) {

        String msgPesquisa = null;

        if (pesquisa.isEmpty()) {
            msgPesquisa = "Insira algum critério para realizar a pesquisa";
        } else {
            List<Vaga> vagas = vagaService.pesquisarVagasPorCargo(pesquisa);

            if (vagas != null && !vagas.isEmpty()) {
                model.addAttribute("vagas", vagas);
                msgPesquisa = "Resultados da busca pelo cargo: " + pesquisa;
            } else {
                msgPesquisa = "Não foi encontrada nenhuma vaga para o critério fornecido";
            }
        }

        model.addAttribute("msgPesquisa", msgPesquisa);
        
        return "usuarios/candidatos/index";
    }

    @GetMapping(value = "/usuarios/candidatos/pesquisarCidade")
    public String pesquisarVagaPorCidade(Model model, @RequestParam String pesquisa) {

        
        String msgPesquisa = null;

        if (pesquisa.isEmpty()) {
            msgPesquisa = "Insira algum critério para realizar a pesquisa";
        } else {
            List<Vaga> vagas = vagaService.pesquisarVagasPorCidade(pesquisa);

            if (vagas != null && !vagas.isEmpty()) {
                model.addAttribute("vagas", vagas);
                msgPesquisa = "Resultados da busca pela cidade: " + pesquisa;
            } else {
                msgPesquisa = "Não foi encontrada nenhuma vaga para o critério fornecido";
            }
        }

        model.addAttribute("msgPesquisa", msgPesquisa);

        return "usuarios/candidatos/index";
    }

    @GetMapping(value = "/usuarios/candidatos/vaga/{id}")
    public String obterVagaPorIdVaga(Model model, @PathVariable Integer id) {
        
        Vaga vaga = vagaService.obterVagaPorIdVaga(id);
        
        model.addAttribute("vaga", vaga);
        
        return "usuarios/candidatos/detalhesVaga";
    }

    @GetMapping(value = "/usuarios/empresas/excluir/{id}")
    public String excluirVaga(Model model, @PathVariable Integer id) {
        
        Vaga vaga = vagaService.obterVagaPorIdVaga(id);
        
        String mensagem = null;
        try {
            vagaService.excluir(id);
            mensagem = "Usuário removido com sucesso";
        } catch (Exception e) {
            mensagem = "Foi impossível realizar a exclusão da vaga";
        }

        model.addAttribute("mensagem", vaga);
        
        return "redirect:/";
    }
}
