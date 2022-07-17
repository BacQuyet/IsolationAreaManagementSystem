/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doctor;

import dao.DoctorDAO;
import entity.Doctor;
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
 * @author Administrator
 */
public class UpdateDoctorsController extends HttpServlet {

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
            out.println("<title>Servlet UpdateDoctorController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateDoctorController at " + request.getContextPath() + "</h1>");
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
        DoctorDAO dao = new DoctorDAO();
        if (request.getParameter("id_doctor") == null) {
            RequestDispatcher view = request.getRequestDispatcher("ViewDoctor");
            view.forward(request, response);
        }
        int id = Integer.parseInt(request.getParameter("id_doctor"));
        String fullname = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        if (fullname != null && address != null) {
            if (fullname.length() > 0 && address.length() > 0) {            
                Doctor d = new Doctor();
                d.setDoctor(id);
                d.setFullName(fullname);
                d.setPhone(Integer.parseInt(phone));
                d.setAddress(address);               
                dao.updateDoctor(d);
                Notification noti = new Notification("Success", "Cập nhật thông tin bác sĩ thành công.", "success");
                request.setAttribute("notify", noti);
                 request.getRequestDispatcher("ViewDoctor").forward(request, response);                              
            }
        }
        if ((fullname != null && address != null)) {
            Notification noti = new Notification("Warning", "Hãy điền đủ tất cả thông tin.", "warning");
            request.setAttribute("notify", noti);
        }
        request.setAttribute("doctor", dao.get(id));
        request.getRequestDispatcher("/Doctors/update-doctor.jsp").forward(request, response);
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
