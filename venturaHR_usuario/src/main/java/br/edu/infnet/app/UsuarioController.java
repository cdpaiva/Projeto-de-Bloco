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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping({"/usuarios"})
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public @ResponseBody Iterable<Usuario> listarUsuarios(){
        
        return usuarioRepository.findAll();
    }
    
    private Usuario findById(int id){
    
        Usuario retorno = null;
        try{
            retorno = usuarioRepository.findById(id);
        } catch (Exception e){
        }
        return retorno;
    }
    
    @GetMapping(path="{id}")
    public ResponseEntity obterUsuarioPorId(@PathVariable int id){
        ResponseEntity retorno = ResponseEntity.notFound().build();
        Usuario user = this.findById(id);
        if(user!=null){
            retorno = ResponseEntity.ok().body(user);
        }
        return retorno;
    }
    
    @GetMapping(path = "/email/{email}")
    public ResponseEntity obterUsuarioPorEmail(@PathVariable String email) {

        ResponseEntity retorno = ResponseEntity.notFound().build();
        Usuario user = usuarioRepository.findByEmail(email);
        if (user != null) {
            retorno = ResponseEntity.ok().body(user);
        }
        return retorno;
    }

    @PostMapping
    public ResponseEntity criarUsuario(@RequestBody Usuario user) {
        
        //TODO: melhorar estas validações
        
        if (user != null && user.getId()!=null) {
            Usuario novoUser = usuarioRepository.save(user);
            return new ResponseEntity(novoUser,HttpStatus.CREATED);
        }
        return new ResponseEntity("Falha ao criar o usuário", HttpStatus.BAD_REQUEST);
    }
    
    @PutMapping
    public ResponseEntity atualizarUsuario(@RequestBody Usuario user) {
        
        if (user != null && user.getId()!=null) {
            Usuario usuarioGravado = this.findById(user.getId());
            
            if(usuarioGravado!=null){
                try {
                    usuarioGravado = usuarioRepository.save(user);
                    return new ResponseEntity(usuarioGravado,HttpStatus.OK);
                }catch (Exception e){
                }
            }
            
        }
        return new ResponseEntity("Falha ao editar o usuário", HttpStatus.BAD_REQUEST);
    }

}
