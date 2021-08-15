package br.edu.infnet.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.domain.Usuario;
import br.edu.infnet.infra.UsuarioRepository;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping({"/usuarios"})
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping(path = "/email/{email}")
    public ResponseEntity obterUsuarioPorEmail(@PathVariable String email) {

        ResponseEntity retorno = ResponseEntity.notFound().build();
        Usuario user = this.repository.obterPorEmail(email);
        if (user != null) {
            retorno = ResponseEntity.ok().body(user);
        }
        return retorno;
    }

    @PostMapping
    public ResponseEntity criarConta(@RequestBody Usuario user) {

        Usuario novoUser = this.repository.inserir(user);
        if (novoUser != null) {
            return new ResponseEntity(novoUser,HttpStatus.CREATED);
        }
        return new ResponseEntity("Falha ao criar o usuário", HttpStatus.BAD_REQUEST);
    }

}
