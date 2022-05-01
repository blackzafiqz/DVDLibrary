/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.dvd.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author black
 */
public class AddDVDFormServlet extends HttpServlet {
    private String[] genres;
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
        genres= new String[]{"Sci-Fi","Drama","Comedy"};
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {

            out.println(String.format("""
                        <!DOCTYPE html>
                        <html>
                            <head>
                                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                                <title>Add DVD</title>
                            </head>
                            <body>
                                <h1>Add DVD</h1>
                        
                                <form name="Name Input Form" action="add_dvd.do" method="post">
                                    Title : <input type="text" name="title" value="%s" /> <br>
                                    Year : <input type="text" name="year" value="%s"/><br>
                                    Genre : <select name="genre">
                                        """,request.getParameter("title")== null ? "":request.getParameter("title")
                                           ,request.getParameter("year")== null ? "":request.getParameter("year")));

            for (String i : genres) 
            {
                String genre = request.getParameter("genre");
                
                String selected= "";
                if(genre!=null)
                    if(i.equals(genre))
                        selected = "selected";
                out.println(String.format("<option value='%s' %s >%s</option>", i,selected, i));
            }
            out.println("""
                                    </select>
                                    or new genre: <input type="text" name="newGenre"/>
                                    <input type="submit" value="OK" />
                                </form>
                            </body>
                        </html>
                        
            """
            );

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
        var errorMsgs = (LinkedList) request.getAttribute("errorMsgs");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>DVD Library Application: Error Page</title>");
        out.println("</head>");
        out.println("<body bgcolor='white'>");
        out.println("<h2>Error Report</h2>");
        out.println("<font color='red'>Please correct the following errors:");
        out.println("<ul>");
        errorMsgs.forEach(i->out.println("  <li>" + i + "</li>"));


        out.println("</ul>");
        out.println("Back up and try again.");
        out.println("</font>");
        out.println("</body>");
        out.println("</html>");
        out.close();
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
