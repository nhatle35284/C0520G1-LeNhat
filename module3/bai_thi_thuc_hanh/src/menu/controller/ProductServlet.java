package menu.controller;

import menu.bo.IProductBo;
import menu.bo.ProductBo;
import menu.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"", "/homePage"})
public class ProductServlet extends HttpServlet {
    IProductBo iProductBo = new ProductBo();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertProduct(request, response);
                break;
            case "edit":
                updateProduct(request, response);
                break;
            default:
                break;
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        String category = request.getParameter("category");
        Product product = new Product(id, name, price, quantity, color, description, category);
        try {
            iProductBo.updateProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Product> listCustomer = iProductBo.selectAllProduct();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        String category = request.getParameter("category");
        Product product = new Product(id, name, price, quantity, color, description, category);
        iProductBo.insertProduct(product);
        List<Product> listProduct = iProductBo.selectAllProduct();
        request.setAttribute("listProduct", listProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showNewProduct(request, response);
                break;
            case "edit":
                showUpdateProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            default:
                showProduct(request, response);
                break;
        }
    }

    private void showProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> listProduct = iProductBo.selectAllProduct();
        request.setAttribute("listProduct", listProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showUpdateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product existingUser = iProductBo.getProductById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
        request.setAttribute("product", existingUser);
        dispatcher.forward(request, response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            iProductBo.deleteProduct(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Product> listProduct = iProductBo.selectAllProduct();
        request.setAttribute("listProduct", listProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request, response);
    }
}
