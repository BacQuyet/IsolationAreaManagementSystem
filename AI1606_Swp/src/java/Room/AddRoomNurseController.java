/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Room;

import dao.AreaDAO;
import dao.RoomDAO;
import entity.Nurse;
import entity.Room;
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
 * @author Admin
 */
public class AddRoomNurseController extends HttpServlet {

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
            out.println("<title>Servlet AddRoomNurseController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddRoomNurseController at " + request.getContextPath() + "</h1>");
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
        HttpSession ss = request.getSession();
        String roomName = request.getParameter("roomName");
        String bedNumber = request.getParameter("bedNumber");
        String note = request.getParameter("note");
        Nurse nurse = (Nurse) ss.getAttribute("nurse");
        
        if (roomName == null ||  bedNumber == null) {
            Notification noti = new Notification("Warning", "H??y ??i???n ????? t???t c??? th??ng tin.", "warning");
            request.setAttribute("notify", noti);
            RequestDispatcher add = request.getRequestDispatcher("/Room/add.jsp");
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
        //room.setArea(daoArea.gt(se.garea()));
        //room.setArea(daoArea.get(nurse.getId_area()))
        dao.create(room);
        
        Notification noti = new Notification("Success", "Th??m ph??ng c??ch ly th??nh c??ng.", "success");
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
