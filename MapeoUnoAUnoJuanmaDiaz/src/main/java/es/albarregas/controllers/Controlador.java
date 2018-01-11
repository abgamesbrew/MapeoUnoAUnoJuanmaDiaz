package es.albarregas.controllers;

import es.albarregas.dao.IGenericoDAO;
import es.albarregas.daofactory.DAOFactory;
import es.albarregas.beans.Puerto;
import es.albarregas.beans.Servicio;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import es.albarregas.dao.IPuertoDAO;

/**
 *
 * @author Jesus
 */
@WebServlet(name = "Controlador", urlPatterns = {"/control"})
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAOFactory daof = DAOFactory.getDAOFactory();
        IPuertoDAO pdao = daof.getPuertoDAO();
//        IGenericoDAO gdao = daof.getGenericoDAO();
        Puerto puerto = new Puerto();
        Servicio servicio = new Servicio();
        String url = null;
        switch (request.getParameter("op")) {
            case "add":

                try {
                    //además de rellenar el bean puerto hay que rellenar el bean servicio e introducirlo dentro del puerto antes de introducirlo en la base de datos
                    BeanUtils.populate(puerto, request.getParameterMap());
                    BeanUtils.populate(servicio, request.getParameterMap());
                    puerto.setServicio(servicio);

                } catch (IllegalAccessException | InvocationTargetException ex) {
                    ex.printStackTrace();
                }
                pdao.add(puerto);
                url = "index.html";
                break;
            case "delete":
//                profesor = adao.getOne(Integer.parseInt(request.getParameter("registro")));
//                adao.delete(profesor);
                puerto = pdao.getOne(Integer.parseInt(request.getParameter("registro")));
                pdao.delete(puerto);
                url = "index.html";
                break;
            case "update":
                puerto = pdao.getOne(Integer.parseInt(request.getParameter("registro")));
                request.setAttribute("puerto", puerto);
                url = "JSP/formularioActualizar.jsp";
                break;
        }
        request.getRequestDispatcher(url).forward(request, response);
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
