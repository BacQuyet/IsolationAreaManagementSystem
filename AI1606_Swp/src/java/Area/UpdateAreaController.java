/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Area;

import dao.AreaDAO;
import entity.Area;
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
public class UpdateAreaController extends HttpServlet {

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
            out.println("<title>Servlet UpdateAreaController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateAreaController at " + request.getContextPath() + "</h1>");
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
        AreaDAO areadao = new AreaDAO();
        
        if (request.getParameter("areaId") == null) {
            RequestDispatcher view = request.getRequestDispatcher("viewarea");
            view.forward(request, response);
        }
        
        int areaId = Integer.parseInt(request.getParameter("areaId"));
        String areaName = request.getParameter("areaName");
        String areaAddress = request.getParameter("areaAddress");
        String areaContact = request.getParameter("areaContact");
        
        if(areaName != null && areaAddress != null && areaContact != null){
            if(areaName.length() > 0 && areaAddress.length() > 0 && areaContact.length() > 0){
                Area a = new Area();
                a.setAreaId(areaId);
                a.setAreaName(areaName);
                a.setAreaAddress(areaAddress);
                a.setContact(areaContact);
                areadao.updateArea(a);
                Notification noti = new Notification("Success", "Cập nhật khu vực cách ly thành công.", "success");
                request.setAttribute("notify", noti);
                RequestDispatcher update = request.getRequestDispatcher("viewarea");
                update.forward(request, response);
            }
        }
        
        request.setAttribute("area", areadao.get(areaId));
        RequestDispatcher update = request.getRequestDispatcher("/Area/update.jsp");
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
