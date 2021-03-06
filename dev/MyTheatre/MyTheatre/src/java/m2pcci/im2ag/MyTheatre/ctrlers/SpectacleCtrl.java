/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2pcci.im2ag.MyTheatre.ctrlers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import m2pcci.im2ag.MyTheatre.DAO.SpectacleDAO;
import m2pcci.im2ag.MyTheatre.Models.Spectacle;

/**
 *
 * @author sedirih
 */
@WebServlet(name = "SpectacleCtrl", urlPatterns = {"/SpectacleCtrl"})
public class SpectacleCtrl extends HttpServlet {

    @Resource(name = "jdbc/MyTheatre")
    private DataSource dataSource;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String dateDebut = request.getParameter("dateSpectacleDebut");
        String dateFin = request.getParameter("dateSpectacleFin");

        try  {
            List<Spectacle> sp = SpectacleDAO.getRepEntreDeuxDates(dataSource, dateDebut,dateFin);
            request.setAttribute("lesSpectacles", sp);
            request.getRequestDispatcher("/WEB-INF/infosSpectacle.jsp").forward(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex.getMessage(), ex);
        }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
