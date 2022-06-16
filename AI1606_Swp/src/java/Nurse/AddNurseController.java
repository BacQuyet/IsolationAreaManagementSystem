/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nurse;

import dao.AccountDAO;
import dao.AreaDAO;
import dao.NurseDAO;
import entity.Account;
import entity.Area;
import entity.Nurse;
import entity.TypeAccount;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.Configs;
import utils.Notification;

/**
 *
 * @author Thanh Duy
 */
public class AddNurseController extends HttpServlet {

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
            out.println("<title>Servlet AddNurseController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddNurseController at " + request.getContextPath() + "</h1>");
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
        String fullname = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repass");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String area = request.getParameter("loai");
        String email = request.getParameter("email");
        int phoneNumber = Integer.parseInt(phone);

        AccountDAO accountDAO = new AccountDAO();
        Account user = accountDAO.find(username);
        AreaDAO a = new AreaDAO();
        
        if (user != null) {
            Notification noti = new Notification("Error", "Tài khoản đã tồn tại", "error");
            request.setAttribute("notify", noti);
            RequestDispatcher rt = request.getRequestDispatcher("/Nurse/add-nurse.jsp");
            rt.forward(request, response);
        } else {
            if (password.equals(repassword)) {
                Account newUser = new Account();
                newUser.setUserName(username);
                newUser.setPassword(password);
                newUser.setEmail(email);
                newUser.setAvatar(Configs.IMG_PATH_AVATAR_DEFAULT);
                newUser.setType(new TypeAccount(2));
                accountDAO.create(newUser);
                Account user1 = accountDAO.find(username);
                Nurse nurse = new Nurse();
                nurse.setAddress(address);
                nurse.setFullName(fullname);
                nurse.setId_area(Integer.parseInt(area));
                nurse.setPhone(phoneNumber);
                nurse.setId_account(user1.getAccountId());
                nurse.setName_nurse("abc");
                NurseDAO nu = new NurseDAO();
                nu.create(nurse);
                List<Area> ar = a.getAll();
                request.setAttribute("listarea", ar);
                Notification noti = new Notification("Success", "Thêm tài khoản nhân sự thành công.", "success");
                request.setAttribute("notify", noti);
                RequestDispatcher r1 = request.getRequestDispatcher("viewnurse");
                r1.forward(request, response);
            } else {
                Notification noti = new Notification("Error", "sai mk", "error");
                request.setAttribute("notify", noti);
                RequestDispatcher rt = request.getRequestDispatcher("/Nurse/add-nurse.jsp");
                rt.forward(request, response);
            }
            

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
