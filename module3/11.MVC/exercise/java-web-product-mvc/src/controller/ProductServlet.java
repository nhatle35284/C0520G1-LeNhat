package controller;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import dao.ProductDao;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductServlet",urlPatterns = "/productServlet")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action){
            case "create":
                registerNewStudent(request,response);
                break;
            case "update":
                updateProduct(request,response);
                break;
        }
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action){
            case "create":
                response.sendRedirect("create.jsp");
                break;
            case "detail":
                getInfoProduct(request,response);
                break;
            case "update":
                goUpdate(request,response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            case "find":
                findProduct(request,response);
                break;
            default:
                listProduct(request,response);
        }
    }




    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listProduct", ProductDao.getListStudent());
        request.getRequestDispatcher("WEB-INF/list.jsp").forward(request,response);
    }
    private void registerNewStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = (int) (Math.random()*1000);
        String name = request.getParameter("name");
        Product product = new Product(id,name);
        ProductDao.save(product);
        request.setAttribute("message","create new product successfully!!");
        listProduct(request,response);
    }
    private void getInfoProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Product product = ProductDao.findById(id);
        request.setAttribute("product",product);
        request.getRequestDispatcher("detail.jsp").forward(request,response);
    }
    private void goUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Product product = ProductDao.findById(id);
        request.setAttribute("product",product);
        request.getRequestDispatcher("update.jsp").forward(request,response);
    }
    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        Product product = new Product(id,name);
        ProductDao.save(product);
        request.setAttribute("message","Update Information product successfully!!");
        listProduct(request,response);
    }
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        ProductDao.deleteById(id);
        request.setAttribute("message","Delete product successfully!!");
        listProduct(request,response);
    }
    private void findProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        Product product = ProductDao.findByName(name);
        request.setAttribute("product",product);
        request.getRequestDispatcher("find.jsp").forward(request,response);

    }
}
