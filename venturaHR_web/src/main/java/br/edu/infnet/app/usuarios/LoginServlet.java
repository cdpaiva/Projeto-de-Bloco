package br.edu.infnet.app.usuarios;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.domain.usuarios.Usuario;
import br.edu.infnet.domain.vagas.Vaga;
import br.edu.infnet.infra.usuarios.UsuarioService;
import br.edu.infnet.infra.vagas.VagaService;
import java.util.List;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        UsuarioService us = new UsuarioService();
        Usuario usuario = us.obterPorEmail(email);
        
        HttpSession sessao = request.getSession();
        sessao.setAttribute("usuario", usuario);

        String caixaEntrada;
        switch (usuario.getTipo()) {
            case Usuario.EMPRESA:
                VagaService vs = new VagaService();
                List<Vaga> vagas = vs.listarPorIdUsuario(usuario.getId());
                request.setAttribute("vagas", vagas);
                caixaEntrada = "empresas/index.jsp";
                break;
            case Usuario.CANDIDATO:
                caixaEntrada = "candidatos/index.jsp";
                break;
            case Usuario.ADMINISTRADOR:
                caixaEntrada = "administradores/index.jsp";
                break;
            default:
                caixaEntrada = "home.jsp";
                break;
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
