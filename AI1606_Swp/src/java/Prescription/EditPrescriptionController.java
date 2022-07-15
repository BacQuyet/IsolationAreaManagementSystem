/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prescription;

import dao.MedicienDAO;
import dao.PatientDAO;
import entity.Presciption;
import dao.PrescriptionDAO;
import entity.Doctor;
import entity.Medicine;
import entity.Patient;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.Notification;
import utils.Utils;

/**
 *
 * @author X1 Carbon Gen 7
 */
public class EditPrescriptionController extends HttpServlet {

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
            out.println("<title>Servlet EditPrescriptionController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditPrescriptionController at " + request.getContextPath() + "</h1>");
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
        Integer id = Integer.parseInt(request.getParameter("id"));
        PrescriptionDAO dao = new PrescriptionDAO();
        Presciption presciption = dao.get(id);
        request.setAttribute("prescription", presciption);
        request.getRequestDispatcher("EditPrescription.jsp").forward(request, response);
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
        Integer id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        Doctor doctorCurrent = (Doctor)session.getAttribute("doctor");
        String prescriptionName = request.getParameter("prescriptionName");
        //String time = request.getParameter("time");
        
        String timeIn = Utils.getToday();
        Date TimeIn = null;
        try {
            TimeIn = Utils.DATE_FORMATER.parse(timeIn);
        } catch (ParseException ex) {
            TimeIn = new Date();
        }
        
        PatientDAO patientDAO = new PatientDAO();
        String patientId = request.getParameter("patient");
        Patient patient = patientDAO.get(Integer.parseInt(patientId));
        
        MedicienDAO medicienDAO = new MedicienDAO();
        String medicineId = request.getParameter("medicine");
        Medicine medicine = medicienDAO.get(Integer.parseInt(medicineId));
        
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        
        Presciption prescription = new Presciption();
        prescription.setPresciptionId(id);
        prescription.setPresciptionName(prescriptionName);
        prescription.setCreateDate(new java.sql.Timestamp(TimeIn.getTime()));
        prescription.setPatient(patient);
        prescription.setDoctor(doctorCurrent);
        prescription.setMedicine(medicine);
        prescription.setQuantity(quantity);
        
        PrescriptionDAO prescriptionDAO = new PrescriptionDAO();
        prescriptionDAO.updatePrescription(prescription);
        
        Notification noti = new Notification("Success", "Chỉnh sửa đơn thuốc thành công", "success");
        request.setAttribute("notify", noti);
        RequestDispatcher r1 = request.getRequestDispatcher("/Prescription/List");
        r1.forward(request, response);
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
