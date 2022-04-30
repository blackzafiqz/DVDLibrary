/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.dvd.controller;

import com.dvd.model.DVDItem;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author black
 */
public class ListLibraryServlet extends HttpServlet {

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
            List dvds = new ArrayList();
            dvds.add(new DVDItem("Aquaman","2019","Sci-Fi"));
            dvds.add(new DVDItem("Robin Hood","2018","Action"));
            dvds.add(new DVDItem("The Grinch","2018","Comedy"));
            
            out.print("""
                      <html>
                      <head>
                      <title>ListLibraryServlet</title>
                      <body bgcolor='white'>
                      You currently have <b>
                      """ + dvds.size() +
                      """
                      </b> DVDs in your collection:<br>
                      <table border='0' cellspacing='0' cellpadding='5'>
                      <tr>
                        <th>TITLE</th>
                        <th>YEAR</th>
                        <th>GENRE</th>
                      </tr>
                      
                      """
                    );
            dvds.forEach(i-> {
                    var t = (DVDItem)i;
                    out.print( "<tr> " +
                               "    <td>" + t.getTitle() + "</td>" +
                               "    <td>" + t.getYear() + "</td>" +
                               "    <td>" + t.getGenre() + "</td></tr>"
                    );
            });
            out.print("""
                      </table>
                      End of list...
                      </body>
                      </html>
                    """);
            
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
