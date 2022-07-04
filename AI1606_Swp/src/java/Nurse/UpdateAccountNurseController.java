/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nurse;

import dao.AccountDAO;
import dao.NurseDAO;
import entity.Account;
import entity.Nurse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.Notification;

/**
 *
 * @author Administrator
 */
public class UpdateAccountNurseController extends HttpServlet {

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
            out.println("<title>Servlet UpdateAccountNurseController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateAccountNurseController at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        request.getRequestDispatcher("/myaccount/editAccount.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("account_id"));
        AccountDAO dao = new AccountDAO();
        NurseDAO daoD = new NurseDAO();
        HttpSession ss = request.getSession();
        Account account = (Account) ss.getAttribute("userLogin");
        String phone = request.getParameter("phone");
        String full_name = request.getParameter("full_name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");

        //if (phone.length() == 10) {  // check so dien thoai có sai ko
        //check tung thuoc tinh xem co thay doi khong
        Account a = new Account();
        a.setAccountId(id);
        a.setEmail(email);
        dao.updateAccount(a);
        Nurse d = new Nurse();
        d.setFullName(full_name);
        d.setPhone(Integer.parseInt(phone));
        d.setAddress(address);
        d.setAccount_id(id);
        daoD.updateAccountNurse(d);

        Notification noti = new Notification("Success", "Cập nhật y tá thành công.", "success");
        request.setAttribute("notify", noti);
        Account userLogin = dao.get(account.getAccountId());
//          userLogin.setPatient(dao);
        ss.setAttribute("nurse", daoD.getNurseByAccountId(account.getAccountId()));
        ss.setAttribute("userLogin", userLogin);
        RequestDispatcher r1 = request.getRequestDispatcher("/myaccount/viewAccount");
        r1.forward(request, response);
//        } else {
//            Notification noti = new Notification("Error", "Nhập sai số điện thoại", "error");
//            request.setAttribute("notify", noti);
//            RequestDispatcher r1 = request.getRequestDispatcher("editAccount.jsp");
//            r1.forward(request, response);
//        }
        if ((full_name != null && address != null && phone != null)) {
            Notification notis = new Notification("Warning", "Hãy điền đủ tất cả thông tin.", "warning");
            request.setAttribute("notify", notis);
        }

        request.getRequestDispatcher("/myaccount/EditAccount").forward(request, response);
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
