package br.edu.infnet.app.usuarios;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.domain.usuarios.Usuario;
import br.edu.infnet.infra.usuarios.UsuarioService;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getRemoteUser();
        UsuarioService us = new UsuarioService();
        Usuario usuario = us.obterPorEmail(email);
        request.setAttribute("usuario", usuario);

        String caixaEntrada = "";
        if (request.isUserInRole("empresa")) {
            caixaEntrada = "empresas/index.jsp";
        } else if (request.isUserInRole("candidato")) {
            caixaEntrada = "candidatos/index.jsp";
        } else if (request.isUserInRole("administrador")) {
            caixaEntrada = "administradores/index.jsp";
        }

        RequestDispatcher rd = request.getRequestDispatcher(caixaEntrada);
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

}
