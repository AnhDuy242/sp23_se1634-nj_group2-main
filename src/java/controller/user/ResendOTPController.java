/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import dal.OTPRequestDBContext;
import dal.UserDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import utils.Email;

/**
 *
 * @author asus
 */
public class ResendOTPController extends HttpServlet {

    UserDBContext ud = new UserDBContext();
    OTPRequestDBContext otp = new OTPRequestDBContext();
    Email emails = new Email();

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ResendOTPController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ResendOTPController at " + request.getContextPath() + "</h1>");
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
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        int type_otp = Integer.parseInt(request.getParameter("type_otp"));

        String code = otp.createNewOTP_For_User(user_id, type_otp, 0);
        int otp_id = ud.getCodeNotActive(code, user_id).getOtp_id();
        //Tao mess
        String name = ud.findUserByID(user_id).getDisplay_name();
        String message_type_otp = otp.messageType(type_otp, code, name);
        //Gui email
        String email = ud.findUserByID(user_id).getEmail();
        ThreadSendEmail t = new ThreadSendEmail(emails, email, "Code Active", message_type_otp);
        t.start();
        //Tao ban ghi email da gui
        otp.createNewSentEmail_For_User(user_id, 1, type_otp, code);
        request.setAttribute("message", "Code is resend!!!");
        request.setAttribute("otp_id", otp_id);
        request.setAttribute("code_time", "Time create code: " + ud.getTimeCodeCreate(user_id, otp_id));
        request.setAttribute("user", ud.findUserByID(user_id));
        try {
            Thread.sleep(1000);
            request.getRequestDispatcher("/views/user/active.jsp").forward(request, response);
        } catch (Exception e) {
        }
    }

    class ThreadSendEmail extends Thread {

        //Luong` gui email
        Email t;
        String title;
        String mail;
        String content;

        ThreadSendEmail(Email t, String mail, String title, String content) {
            this.t = t;
            this.title = title;
            this.mail = mail;
            this.content = content;
        }

        public void run() {
            try {
                Thread.sleep(100);
                t.sendMail(mail, title, content);
            } catch (Exception e) {
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
//        processRequest(request, response);
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
