/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private static final String ERROR = "index.jsp";
    //---User---//
    private static final String LOGIN = "LoginController";
    private static final String LOGOUT = "LogoutController";
    //--Home--//
    private static final String SEARCH = "SearchController";
    private static final String MANAGER = "ManagerBook.jsp";
    private static final String HOME = "HomeController";
    private static final String CATEGORY = "CategoryController";
    //---Manager Book---//
    private static final String UPDATE = "UpdateController";
    private static final String ADD = "AddController";
    private static final String DELETE = "DeleteController";
    private static final String EDIT = "EditController";
    //---Cart---//
    private static final String ADDTOCART = "AddtoCartController";
    private static final String SHOWCART = "Cart.jsp";
    private static final String CHECKOUT = "CheckOutController";
    private static final String DISCOUNT = "Discount.jsp";
    private static final String CREATE = "DiscountController";
    private static final String USEVOUCHER = "VoucherController";
    private static final String HISTORY = "HistoryController";
    private static final String MOREDETAIL = "MoreDetailController";

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
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if ("Login".equals(action)) {
                url = LOGIN;
            } else if ("Search".equals(action)) {
                url = SEARCH;
            } else if ("manager".equals(action)) {
                url = MANAGER;
            } else if ("home".equals(action)) {
                url = HOME;
            } else if ("Update".equals(action)) {
                url = UPDATE;
            } else if ("CheckOut".equals(action)) {
                url = CHECKOUT;
            } else if ("Edit".equals(action)) {
                url = EDIT;
            } else if ("Add".equals(action)) {
                url = ADD;
            } else if ("Delete".equals(action)) {
                url = DELETE;
            } else if ("Logout".equals(action)) {
                url = LOGOUT;
            } else if ("category".equals(action)) {
                url = CATEGORY;
            } else if ("Cancel".equals(action)) {
                url = MANAGER;
            } else if ("AddtoCart".equals(action)) {
                url = ADDTOCART;
            } else if ("showcart".equals(action)) {
                url = SHOWCART;
            } else if ("discount".equals(action)) {
                url = DISCOUNT;
            } else if ("Create".equals(action)) {
                url = CREATE;
            }else if ("usevoucher".equals(action)) {
                url = USEVOUCHER;
            }else if ("History".equals(action)) {
                url = HISTORY;
            }else if ("MoreDetail".equals(action)) {
                url = MOREDETAIL;
            }else if ("Login With Google".equals(action)) {
                url = LOGIN;
            }else if ("Paypal".equals(action)) {
                url = CHECKOUT;
            }

        } catch (Exception e) {
            log("Error at MainController");
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
        processRequest(request, response);
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
