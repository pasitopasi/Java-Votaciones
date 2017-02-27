/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.*;
import Modelo.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pasito
 */
public class ServletInsertarUsuario extends HttpServlet {

    private Connection conexion;

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
        try (PrintWriter out = response.getWriter()) {

            String dni = request.getParameter("dni");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String contrasena = request.getParameter("contrasena");

            Usuario user = new Usuario(dni, nombre, apellido, contrasena);
            if (new Operaciones().IntroducirUsuario(this.conexion, user)) {
                response.sendRedirect("index.jsp");
            } else {
                HttpSession session = request.getSession(true);
                session.setAttribute("men", "Usuario ya registrado.");
                response.sendRedirect("Vistas/AltaUsuario.jsp");
            }

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

    @Override
    public void init() throws ServletException {
        /* Establecemos la conexión, si no existe */
        try {
            Conexion ConexBD = Conexion.getConexion();
            this.conexion = ConexBD.getConex();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }
}
