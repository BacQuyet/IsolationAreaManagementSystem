/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Feedback;

import dao.FeedbackDAO;
import dao.PatientDAO;
import entity.Feedback;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Notification;

/**
 *
 * @author ADMIN
 */
public class UpdateFeedbackController extends HttpServlet {

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
            out.println("<title>Servlet UpdateFeedbackController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateFeedbackController at " + request.getContextPath() + "</h1>");
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
        int feedbackId = Integer.parseInt(request.getParameter("feedbackId"));
        FeedbackDAO feed = new FeedbackDAO();
        request.setAttribute("feedback", feed.get(feedbackId));
        RequestDispatcher r = request.getRequestDispatcher("/Feedback/update.jsp");
        r.forward(request, response);
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
        String content = request.getParameter("feedbackName");
        int feedbackId = Integer.parseInt(request.getParameter("feedbackId"));
        int Patient_Id = Integer.parseInt(request.getParameter("PatientId"));
        
        if (content == null) {
            Notification noti = new Notification("Warning", "Hãy điền đủ thông tin.", "warning");
            request.setAttribute("notify", noti);
            RequestDispatcher add = request.getRequestDispatcher("/Feedback/update.jsp");
            add.forward(request, response);
        }
        
        if (content != null) {
            PatientDAO pa = new PatientDAO();
            long millis = System.currentTimeMillis();
            Timestamp date = new Timestamp(millis);
            Feedback fe = new Feedback();
            fe.setFeedback_id(feedbackId);
            fe.setPatient(pa.get(Patient_Id));
            fe.setContent(content);
            fe.setCreateDate(date);
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
