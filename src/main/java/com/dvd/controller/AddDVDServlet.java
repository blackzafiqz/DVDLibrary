/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.dvd.controller;

import com.dvd.model.DVDItem;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.LinkedList;

/**
 *
 * @author black
 */
public class AddDVDServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddDVDServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddDVDServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        //processRequest(request, response);
        LinkedList<String> errorMsgs = new LinkedList<String>();
        try {
            String title = request.getParameter("title");
            String year = request.getParameter("year");
            String genre = request.getParameter("newGenre");

            if ((genre == null) || (genre.trim().length() == 0)) {
                genre = request.getParameter("genre");
            }
            if (title == null || title.trim().length() == 0) {
                errorMsgs.add("Please enter the DVD title.");
            }
            if (year == null || year.trim().length() == 0) 
                errorMsgs.add("Please enter the year of release for the DVD.");
            else if (!year.trim().matches("\\d\\d\\d\\d"))
                errorMsgs.add("Please enter a valid year.");
            if (!errorMsgs.isEmpty()) {
                request.setAttribute("errorMsgs", errorMsgs);
                RequestDispatcher view = request.getRequestDispatcher("/add_dvd.view");
                view.forward(request, response);
                return;
            }
            DVDItem item = new DVDItem(title, year, genre);

            request.setAttribute("dvdItem", item);

            RequestDispatcher view = request.getRequestDispatcher("/success.view");
            view.forward(request, response);
        } catch (RuntimeException e) {
            var out = response.getWriter();
            out.println("Error" + e.getMessage());
            out.close();
        }
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
