/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nurse;

import dao.AccountDAO;
import dao.AreaDAO;
import dao.NurseDAO;
import entity.Nurse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Notification;

/**
 *
 * @author Thanh Duy
 */
public class UpdateNurseController extends HttpServlet {

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
            out.println("<title>Servlet UpdateNurseController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateNurseController at " + request.getContextPath() + "</h1>");
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
        NurseDAO dao = new NurseDAO();
        AccountDAO daoacc = new AccountDAO();
        AreaDAO areadao = new AreaDAO();
        
        if (request.getParameter("nurseId") == null) {
            RequestDispatcher view = request.getRequestDispatcher("viewnurse");
            view.forward(request, response);
        }
        int nurseId = Integer.parseInt(request.getParameter("nurseId"));
        String nurseName = request.getParameter("nurseName");
        String phone = request.getParameter("phone");
        String accountId = request.getParameter("accountId");
        String address = request.getParameter("address");
        String areaId = request.getParameter("areaId");
        String fullname = request.getParameter("fullname");
        if (nurseName != null && phone != null && accountId != null && address != null && areaId != null && fullname != null) {
            if (nurseName.length() > 0 && phone.length() > 0 && accountId.length() > 0 && address.length() > 0 && areaId.length() > 0 && fullname.length() > 0) {
            Nurse nurse = new Nurse();
            nurse.setId_nurse(nurseId);
            nurse.setName_nurse(nurseName);
            nurse.setPhone(Integer.parseInt(phone));
            nurse.setId_account(daoacc.get(Integer.parseInt(accountId)));
            nurse.setAddress(address);
            nurse.setId_area(areadao.get(Integer.parseInt(areaId)));
            nurse.setFullName(fullname);
            
            if (nurseName != null && phone != null && accountId != null && address != null && areaId != null && fullname != null) {
            Notification noti = new Notification("Warning", "Hãy điền đủ tất cả thông tin.", "warning");
            request.setAttribute("notify", noti);
        }
            }
        }
        
        RequestDispatcher update = request.getRequestDispatcher("/Nurse/update-nurse.jsp");
        update.forward(request, response);
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
