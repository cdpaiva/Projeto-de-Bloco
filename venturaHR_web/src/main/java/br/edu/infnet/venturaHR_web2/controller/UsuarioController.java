package br.edu.infnet.venturaHR_web2.controller;

import br.edu.infnet.venturaHR_web2.domain.Usuario;
import br.edu.infnet.venturaHR_web2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/cadastro")
    public String telaCadastro(Model model) {
        
        return "cadastro";
    }

    @PostMapping(value = "/cadastrar")
    public String realizarCadastro(Model model, Usuario usuario) {
        
        Usuario novoUser = usuarioService.cadastrar(usuario);
        
        model.addAttribute("usuario", novoUser);
        model.addAttribute("msgSucesso", "Usuário cadastrado com sucesso");
        
        return telaCadastro(model);
    }

    @GetMapping(value = "confirmacao")
    public String telaConfirmacao(Model model) {
        
        return "confirmacao";
    }
}
