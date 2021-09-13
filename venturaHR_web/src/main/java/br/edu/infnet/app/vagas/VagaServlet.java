
package br.edu.infnet.app.vagas;

import br.edu.infnet.domain.usuarios.Usuario;
import br.edu.infnet.domain.vagas.Criterio;
import br.edu.infnet.domain.vagas.Vaga;
import br.edu.infnet.infra.vagas.VagaService;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VagaServlet extends HttpServlet {

    /*
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sessao = request.getSession();
        
        Vaga vaga = new Vaga(
                        12,
                        request.getParameter("cargo"),
                        request.getParameter("cidade"),
                        request.getParameter("formaContratacao"));
        
        sessao.setAttribute("vaga", vaga);
        
        RequestDispatcher rd = request.getRequestDispatcher("/usuarios/empresas/publicarVaga.jsp");
        rd.forward(request, response);
    }*/

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        
        Vaga vaga = (Vaga) sessao.getAttribute("vaga");
        List<Criterio> criterios = (List) sessao.getAttribute("criterios");
        vaga.setCriterios(criterios);
        
        VagaService vagaService = new VagaService();
        
        vagaService.publicarVaga(vaga);
                
        request.setAttribute("msgSucesso", "Vaga publicada com sucesso");
        RequestDispatcher rd = request.getRequestDispatcher("/usuarios/empresas/publicarVaga.jsp");
        rd.forward(request, response);
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        
        Usuario usuario = (Usuario) sessao.getAttribute("usuario");
        
        Vaga vaga = new Vaga(
                        12,
                        request.getParameter("cargo"),
                        request.getParameter("cidade"),
                        request.getParameter("formaContratacao"),
                        usuario.getId());
        
        sessao.setAttribute("vaga", vaga);
        
        RequestDispatcher rd = request.getRequestDispatcher("/usuarios/empresas/publicarVaga.jsp");
        rd.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
