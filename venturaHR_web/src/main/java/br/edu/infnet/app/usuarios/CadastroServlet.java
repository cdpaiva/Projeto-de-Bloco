package br.edu.infnet.app.usuarios;

import br.edu.infnet.domain.usuarios.Usuario;
import br.edu.infnet.infra.usuarios.UsuarioService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastroServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Usuario usuario = new Usuario(
                request.getParameter("nome"),
                request.getParameter("endereco"),
                request.getParameter("telefone"),
                request.getParameter("email"),
                request.getParameter("senha"),
                request.getParameter("cpf"),
                request.getParameter("razaoSocial"),
                request.getParameter("cnpj"),
                request.getParameter("tipo").charAt(0)
        );
    
        UsuarioService us = new UsuarioService();
        Usuario confirmado = us.criarConta(usuario);

        request.setAttribute("nome", confirmado.getNome());
        request.setAttribute("email", confirmado.getEmail());
        RequestDispatcher rd = request.getRequestDispatcher("confirmacao.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
