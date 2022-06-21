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
import java.sql.Timestamp;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.Notification;

/**
 *
 * @author ADMIN
 */
public class AddReportController extends HttpServlet {

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
            out.println("<title>Servlet AddReportController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddReportController at " + request.getContextPath() + "</h1>");
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
        doPost(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String content = "";
        for (int i = 1; i < 10; i++) {
            String x = request.getParameter("s" + i);
            if (x != null) {
                content += x + "; ";
            }
        }
        String x = request.getParameter("cother");
        if (x != null) {
            if (request.getParameter("other") != null) {
                content += request.getParameter("other") + "; ";
            }
        }
        if ("".equals(content.trim())) {
            content = "Không có triệu trứng bệnh; ";
        }
        content += request.getParameter("test");
        long millis = System.currentTimeMillis();
        Timestamp date = new Timestamp(millis);
        Report report = new Report();
        report.setContent(content);
        report.setCreateDate(date);

        HttpSession session = request.getSession();
        Account userLogin = (Account) session.getAttribute("userLogin");
        report.setPatient(userLogin.getPatient());
        ReportDAO dao = new ReportDAO();
        dao.create(report);
        Notification noti = new Notification("Success", "Thêm báo cáo thành công.", "success");
        request.setAttribute("notify", noti);
        RequestDispatcher add = request.getRequestDispatcher("listReport");
        add.forward(request, response);
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
