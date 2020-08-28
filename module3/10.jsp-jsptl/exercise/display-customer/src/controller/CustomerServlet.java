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
        String m1 = "<img src=\"image/Bao_Anh_(2)_(2018).png\" height =\"50\" width =\"50\">";
        customersList.add(new Customers("Nhat","28/04/2000","Quang Tri",m1));
        customersList.add(new Customers("Chuong","28/04/1988","Quang Tri",m1));
        customersList.add(new Customers("Quang","28/04/1996","Da Nang",m1));
        request.setAttribute("customerListServlet",customersList);

        request.getRequestDispatcher("customers/list.jsp").forward(request,response);
    };
}
