package menu.controller;

import com.sun.javafx.image.impl.IntArgb;
import menu.bo.CustomerBo;
import menu.bo.ICustomerBo;
import menu.model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FuramaServlet",urlPatterns = {"","/homePage"})
public class FuramaServlet extends HttpServlet {
    ICustomerBo iCustomerBo = new CustomerBo();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                insertCustomer(request,response);
                break;
            default:
                break;
        }
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer customerId = Integer.valueOf(request.getParameter("customer_id"));
        Integer customerTypeId = Integer.valueOf(request.getParameter("customer_type_id"));
        String customerName = request.getParameter("customer_name");
        String customerBirthday = request.getParameter("customer_birthday");
        Integer customerGender = Integer.valueOf(request.getParameter("customer_gender"));
        Integer customerIdCard = Integer.valueOf(request.getParameter("customer_id_card"));
        String customerPhone = request.getParameter("customer_phone");
        String customerEmail = request.getParameter("customer_email");
        String customerAddress = request.getParameter("customer_address");

        Customer customerAdd = new Customer(customerId,customerTypeId,customerName,customerBirthday,customerGender,customerIdCard,customerPhone,customerEmail,customerAddress);
        iCustomerBo.insertCustomer(customerAdd);
        RequestDispatcher dispatcher = request.getRequestDispatcher("furama/create_customer.jsp");
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                showNewCustomer(request,response);
                break;
            default:
                showAllCustomer(request,response);
                break;
        }
    }

    private void showNewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("furama/create_customer.jsp");
        dispatcher.forward(request,response);
    }

    private void showAllCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Customer> listCustomer = iCustomerBo.selectAllCustomer();
//        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("furama/display.jsp");
        dispatcher.forward(request, response);
    }
}
