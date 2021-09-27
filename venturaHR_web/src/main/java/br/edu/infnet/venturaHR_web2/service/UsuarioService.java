package br.edu.infnet.venturaHR_web2.service;

import br.edu.infnet.venturaHR_web2.RestTemplateClient;
import br.edu.infnet.venturaHR_web2.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UsuarioService {
    
    private final String uri = "http://localhost:8081/usuarios";
    
    @Autowired
    RestTemplate restTemplate; 
    
    public Usuario cadastrar(Usuario usuario){
                
        Usuario novoUsuario = restTemplate.postForObject(uri, usuario, Usuario.class);
        
        return novoUsuario;
    }
    
    public Usuario obterPorEmail(String email){
        
        String uriEmail = uri + "/email/{email}";
        Usuario validoUsuario = restTemplate.getForObject(uriEmail, Usuario.class, email);
        
        return validoUsuario;
        
    }
    
}
