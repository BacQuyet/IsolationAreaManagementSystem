/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.base;

import dao.AccountDAO;
import dao.DoctorDAO;
import dao.NurseDAO;
import dao.PatientDAO;
import entity.Account;
import entity.Doctor;
import entity.Nurse;
import entity.Patient;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
public class ViewDetailAccountController extends HttpServlet {

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
            out.println("<title>Servlet ViewDetailAccountController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewDetailAccountController at " + request.getContextPath() + "</h1>");
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
        AccountDAO dao = new AccountDAO();
        HttpSession ss = request.getSession();
        DoctorDAO daoD = new DoctorDAO();
        NurseDAO daoN = new NurseDAO();
        PatientDAO daoP = new PatientDAO();
        Account account = (Account) ss.getAttribute("userLogin");
        Doctor d = daoD.getDoctorByAccountId(account.getAccountId());
        Nurse n = daoN.getNurseByAccountId(account.getAccountId());
        Patient p = daoP.getPatientByAccountId(account.getAccountId());
        Account userLogin = dao.get(account.getAccountId());
        ss.setAttribute("d", d);
        ss.setAttribute("nurse", n);
        ss.setAttribute("patient", p);
        ss.setAttribute("userLogin", userLogin);
        RequestDispatcher view = request.getRequestDispatcher("/myaccount/accountDetail.jsp");
         view.forward(request, response);
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
        doGet(request, response);
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
