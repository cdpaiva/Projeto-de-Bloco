package br.edu.infnet.infra;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import br.edu.infnet.domain.Usuario;

@Repository
public class UsuarioRepository {
	//Simulação de um BD
	
	private HashMap<String, Usuario> usuarios;
	
	public UsuarioRepository() {
		usuarios = new HashMap<>();
		usuarios.put("ana@gmail.com", new Usuario("Ana", "ana@gmail.com", "21372846"));
		usuarios.put("bob@gmail.com", new Usuario("Bob", "bob@gmail.com", "21854328"));
		usuarios.put("cris@gmail.com", new Usuario("Cristina", "cris@gmail.com", "21001846"));
	}
	
	public Usuario obterPorEmail(String email) {
		return usuarios.get(email);
	}
	
	public Usuario inserir(Usuario user) {
		Usuario retorno = null;
		if(user.getEmail()!=null) {
			usuarios.putIfAbsent(user.getEmail(), user);
			retorno = user;
		}
		return retorno;
	}
        
}