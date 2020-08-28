package controller;

import models.Customers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customerList")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customers> customersList = new ArrayList<>();
        customersList.add(new Customers("Nhat","28/04/2000","Quang Trịi","m"));
        customersList.add(new Customers("Chuong","28/04/1988","Quang Tri","m"));
        customersList.add(new Customers("Quang","28/04/1996","Da Nang","m"));
        request.setAttribute("customerListServlet",customersList);

        request.getRequestDispatcher("customers/list.jsp").forward(request,response);
    };
}
