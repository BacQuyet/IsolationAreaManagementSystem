/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

import dao.ReportDAO;
import entity.Account;
import entity.Report;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
public class ViewReportController extends HttpServlet {

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
            out.println("<title>Servlet ViewReportController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewReportController at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        int page = 1;
        int recordPerPage = 5;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        int id = 0;
        HttpSession session = request.getSession();
        Account userLogin = (Account) session.getAttribute("userLogin");
        if (userLogin.getType().getAccountTypeId() == 4) {// Patient
            id = userLogin.getPatient().getPatientId();
        }

        String fname = (String) request.getParameter("fname");
        String ffrom = (String) request.getParameter("ffrom");
        String fto = (String) request.getParameter("fto");
        String fsort = (String) request.getParameter("fsort");

        ReportDAO dao = new ReportDAO();
        List<Report> list = dao.getIndex((page - 1) * recordPerPage + 1, page * recordPerPage, id);
        int noOfRecord = dao.getNoOfRecord();
        int noOfPage = (int) ((noOfRecord + 4) / 5);
        request.setAttribute("noOfRecords", noOfRecord);
        request.setAttribute("listReport", list);
        request.setAttribute("noOfPages", noOfPage);
        request.setAttribute("currentPage", page);
        if (userLogin.getType().getAccountTypeId() == 4) {// List for Patient
            RequestDispatcher view = request.getRequestDispatcher("personalList.jsp");
            view.forward(request, response);
        } else {
            // List  Doctors
            request.setAttribute("fname", fname);
            request.setAttribute("ffrom", ffrom);
            request.setAttribute("fto", fto);
            request.setAttribute("fsort", fsort);
            RequestDispatcher view = request.getRequestDispatcher("list.jsp");
            view.forward(request, response);
        }
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
