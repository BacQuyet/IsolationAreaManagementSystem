/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Room;

import dao.AreaDAO;
import dao.RoomDAO;
import entity.Room;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Notification;


public class AddRoomFromAdminController extends HttpServlet {

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
            out.println("<title>Servlet AddRoomFromAdminController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddRoomFromAdminController at " + request.getContextPath() + "</h1>");
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
        //
        String roomName = request.getParameter("roomName");
        String bedNumber = request.getParameter("bedNumber");
        String note = request.getParameter("note");
        int area = Integer.parseInt(request.getParameter("area"));
        
        if (roomName == null || bedNumber == null) {
            Notification noti = new Notification("Warning", "Hãy điền đủ tất cả thông tin.", "warning");
            request.setAttribute("notify", noti);
            RequestDispatcher add = request.getRequestDispatcher("/Room/addadmin.jsp");
            add.forward(request, response);
        }
        if (note.length() == 0) {
            note = "no notes";
        }
        
        RoomDAO dao = new RoomDAO();
        AreaDAO daoArea = new AreaDAO();
        Room room = new Room();
        room.setRoomName(roomName);
        room.setBedNumber(Integer.parseInt(bedNumber));
        room.setNote(note);
        room.setArea(daoArea.get(area));
        dao.create(room);
        
        Notification noti = new Notification("Success", "Thêm phòng cách ly thành công.", "success");
        request.setAttribute("notify", noti);
        response.sendRedirect("viewroom");
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
