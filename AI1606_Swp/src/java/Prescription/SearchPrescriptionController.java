/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prescription;

import dao.PrescriptionDAO;
import entity.Presciption;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author X1 Carbon Gen 7
 */
public class SearchPrescriptionController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String key = request.getParameter("key");
        int page = 1;
        int recordsPerPage = 10;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        PrescriptionDAO dao = new PrescriptionDAO();
        List<Presciption> list1 = dao.SearchByKey(key);
        List<Presciption> list2 = new ArrayList<>();
        int noOfRecords = list1.size();
        int t;
        if (noOfRecords > 10 * page) {
            t = recordsPerPage;
        } else {
            t = noOfRecords % recordsPerPage;
        }
        for (int i = 0; i < t; i++) {
            list2.add(list1.get(i + (page - 1) * recordsPerPage));
        }
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        request.setAttribute("noOfRecords", noOfRecords);
        request.setAttribute("ngCachLyList", list2);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        request.setAttribute("key", key);
        String fname = (String) request.getParameter("fname");
        String ffrom = (String) request.getParameter("ffrom");
        String fto = (String) request.getParameter("fto");
        String fsort = (String) request.getParameter("fsort");
        request.setAttribute("fname", fname);
        request.setAttribute("ffrom", ffrom);
        request.setAttribute("fto", fto);
        request.setAttribute("fsort", fsort);
        RequestDispatcher view = request.getRequestDispatcher("ListPrescription.jsp");
        view.forward(request, response);
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
