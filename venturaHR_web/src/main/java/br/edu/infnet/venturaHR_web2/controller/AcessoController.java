package br.edu.infnet.venturaHR_web2.controller;

import br.edu.infnet.venturaHR_web2.domain.Usuario;
import br.edu.infnet.venturaHR_web2.domain.Vaga;
import br.edu.infnet.venturaHR_web2.service.VagaService;
import br.edu.infnet.venturaHR_web2.service.UsuarioService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@SessionAttributes("user")
@Controller
public class AcessoController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private VagaService vagaService;

    @GetMapping(value = "/")
    public String telaInicio(Model model, HttpSession session) {

        Usuario user = (Usuario) session.getAttribute("user");

        if (user != null) {
            switch (user.getTipo()) {
                case Usuario.EMPRESA:
                    List<Vaga> vagas = vagaService.obterVagasPorId(user.getId());
                    model.addAttribute("vagas", vagas);
                    return telaEmpresa(model);
                case Usuario.CANDIDATO:
                    return telaCandidato(model);
                case Usuario.ADMINISTRADOR:
                    return "/usuarios/administradores/index";
                default:
                    return "/";
            }
        } else {
            Vaga vagaExemplo = vagaService.obterVagaAleatoria();
            Vaga vagaExemplo2 = vagaService.obterVagaAleatoria();
            model.addAttribute("vagaExemplo", vagaExemplo);
            model.addAttribute("vagaExemplo2", vagaExemplo2);
        }

        return "index";
    }

    @PostMapping(value = "/login")
    public String login(Model model, @RequestParam String email) {

        Usuario user = usuarioService.obterPorEmail(email);
        
        if (user != null) {
            model.addAttribute("user", user);
        }

        return "redirect:/";
    }

    @GetMapping(value = "/usuarios/empresas/index")
    public String telaEmpresa(Model model) {
        
        return "/usuarios/empresas/index";
    }

    @GetMapping(value = "/usuarios/candidatos/index")
    public String telaCandidato(Model model) {
        
        return "/usuarios/candidatos/index";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpSession session, SessionStatus status) {
        
        status.setComplete();
        session.invalidate();
        return "redirect:/";
    }

}
