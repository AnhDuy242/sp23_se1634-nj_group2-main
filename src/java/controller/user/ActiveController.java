/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.user;

import dal.UserDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import model.OTPRequest;
/**
 *
 * @author asus
 */
public class ActiveController extends HttpServlet {
    UserDBContext ud = new UserDBContext();

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet ActiveController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ActiveController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        String code = request.getParameter("code");
        OTPRequest VerifyCode = ud.checkCodeActive(code, user_id);
        String otp = request.getParameter("otp_id");
        int otp_id;
        if (otp == null) {
            otp_id = VerifyCode.getOtp_id();
        } else {
            otp_id = Integer.parseInt(otp);
        }
        if (VerifyCode != null) { // nhap ma code dung
            if (ud.checkTimeCode(VerifyCode.getExp_time())) { // code chua het han
                //verify code
                ud.VerifyCodeActive(VerifyCode.getOtp_id());
                // active user   
                ud.ActiveUser(VerifyCode.getUser_id());
                request.setAttribute("mess-succes", "Account Active successfully!!!!");
               request.getRequestDispatcher("/views/user/home.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "Code expired!!!!");
                request.setAttribute("user", ud.findUserByID(user_id));
                request.setAttribute("otp_id", otp_id);
                request.setAttribute("code_time", "Time create code: " + ud.getTimeCodeCreate(user_id, otp_id));
                request.getRequestDispatcher("/views/user/active.jsp").forward(request, response);
            }
//sent mess-succes den trang login 
//request.getRequestDispatcher("login.jsp").forward(request, response);
        } else { // nhap ma code sai 
            request.setAttribute("message", "Code is invalid!!!!");
            request.setAttribute("user", ud.findUserByID(user_id));
            request.setAttribute("otp_id", otp_id);
            request.setAttribute("code_time", "Time create code: " + ud.getTimeCodeCreate(user_id, otp_id));
            request.getRequestDispatcher("/views/user/active.jsp").forward(request, response);
        }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
