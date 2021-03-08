/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
//import java.util.Calendar;
//import java.util.Date;

/**
 *
 * @author andersons
 */
@WebServlet(name = "JurosSimplesServelet", urlPatterns = {"/juros-simples.html"})
public class JurosSimplesServelet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servelet JUROS SIMPLES - JAVA EE</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>CALCULO DE JUROS SIMPLES -JAVA EE </h1>");
                        //tratamento de erro
            try{
                //recebe n1 do index, converte para double e armazena na variavel n1
                double valorPresente = Double.parseDouble( request.getParameter("n1"));
                //recebe n2 do index, converte para double e armazena na variavel n2
                double taxaJuros = Double.parseDouble( request.getParameter("n2"));
                //recebe n2 do index, converte para double e armazena na variavel n2
                int periodo = Integer.parseInt ( request.getParameter("n3"));
                
                
                out.println("<h2>VALOR PRESENTE(R$) = " + valorPresente + " </h2>");
                out.println("<h2>TAXA DE JUROS(%) = "  + taxaJuros + " </h2>");
                out.println("<h2>PERÍODO(MESES) = "  + periodo + " </h2>");
                //passando o valor da taxa de juros inserido pelo usuário para percentual
                taxaJuros =  taxaJuros/100;
                double valorFuturo = valorPresente*(1+taxaJuros*periodo);
                //tratando o calculo realizado , para apresentação com 2 casas decimais
                String formato = " #,##0.00";
                DecimalFormat d = new DecimalFormat(formato);
                
                out.println("<h2>VALOR FUTURO(R$) = "+(d.format(valorFuturo))+"</h2>");
                
            }catch(Exception ex){
            
                out.println("<h2>OCORREU UM ERRO = "+ex.getLocalizedMessage()+"</h2>");
            }
            out.println("<h3><a href='index.html'>Voltar</a></h3>"); // retorna pro INDEX
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
