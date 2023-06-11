/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author AD
 */
public class CalHTML extends HttpServlet {

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
        String f = request.getParameter("first");
        String s = request.getParameter("second");
        String o = request.getParameter("oper");
        String result;
        result = calculate(f, s, o);
        if (result == null) {
            f = "";
            s = "";
            result = "";
        }
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Caculator</title>");
            out.println("");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Caculator simple </h1>");
            out.println("<form action=\"CalHTML\">\n"
                    + "<table>"
                    + "<tr>"
                    + "<td>            First:\n</td>"
                    + "<td>            <input type=\"text\" name=\"first\" value=\"" + f + "\"/>\n</td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>            Second:\n</td>"
                    + "<td>            <input type=\"text\" name=\"second\" value=\"" + s + "\"/>\n</td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>            Operator:\n</td>"
                    + "<td>            <select name=\"oper\" value=\"" + o + "\">\n"
                    + "                <option>+</option>\n"
                    + "                <option>-</option>\n"
                    + "                <option>*</option>\n"
                    + "                <option>/</option>\n"
                    + "            </select>\n</td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>            <input type=\"submit\" name=\"submit\" value=\"Compute\"/>\n</td>"
                    + "</tr>");

            out.println("<tr><td>            Result:</td><td> <input type=\"text\" name=\"result\" value=\"" + result + "\"/>\n</td></tr>");
            out.println("</table></form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public String calculate(String a, String b, String c) {
        double r = 0;
        try {
            Double x = Double.parseDouble(a);
            Double y = Double.parseDouble(b);
            switch (c) {
                case "+":
                    r = x + y;
                    break;
                case "-":
                    r = x - y;
                    break;
                case "*":
                    r = x * y;
                    break;
                case "/":
                    if (y != 0) {
                        r = x / y;
                        break;
                    } else {
                        throw new ArithmeticException();
                    }
            }
        } catch (Exception e) {
            return null;
        }
        return Double.toString(r);
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
