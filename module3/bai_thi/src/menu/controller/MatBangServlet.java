package menu.controller;

import common.Validate;
import menu.bo.IMatBangBo;
import menu.bo.MatBangBo;
import menu.model.MatBang;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "MatBangServlet", urlPatterns = {"", "/homePage"})
public class MatBangServlet extends HttpServlet {
    IMatBangBo iMatBangBo = new MatBangBo();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertProduct(request, response);
                break;
            case "search":
                search(request, response);
                break;
            default:
                break;
        }
    }


    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String dien_tich = request.getParameter("dien_tich");
        String trang_thai = request.getParameter("trang_thai");
        int tang = Integer.parseInt(request.getParameter("tang"));
        String loai_van_phong = request.getParameter("loai_van_phong");
        double gia = Double.parseDouble(request.getParameter("gia"));
        String ngay_bat_dau = request.getParameter("ngay_bat_dau");
        String ngay_ket_thuc = request.getParameter("ngay_ket_thuc");
        if (!Validate.isValid(dien_tich,Validate.DIEN_TICH)){
            RequestDispatcher dispatcher = request.getRequestDispatcher("mat_bang/create.jsp");
            dispatcher.forward(request, response);
        }
        else {
            MatBang matBang = new MatBang(ma,Double.parseDouble(dien_tich),trang_thai,tang,loai_van_phong,gia,ngay_bat_dau,ngay_ket_thuc);
            iMatBangBo.insertMatBang(matBang);
            List<MatBang> listMatBang = iMatBangBo.selectAllMatBang();
            request.setAttribute("listMatBang", listMatBang);
            RequestDispatcher dispatcher = request.getRequestDispatcher("mat_bang/list.jsp");
            dispatcher.forward(request, response);
        }
    }
    private void search(HttpServletRequest request, HttpServletResponse response) {
        String loai_van_phong = request.getParameter("loai_van_phong");
        List<MatBang> listMatBang = null;
        listMatBang = iMatBangBo.searchVanPhong(loai_van_phong);
        RequestDispatcher dispatcher = request.getRequestDispatcher("mat_bang/list.jsp");
        request.setAttribute("listMatBang", listMatBang);
//        request.setAttribute("message","List ALL Users");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            case "delete":
                deleteProduct(request, response);
                break;
            default:
                showProduct(request, response);
                break;
        }
    }

    private void showProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MatBang> listMatBang = iMatBangBo.selectAllMatBang();
        request.setAttribute("listMatBang", listMatBang);
        RequestDispatcher dispatcher = request.getRequestDispatcher("mat_bang/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("mat_bang/create.jsp");
        dispatcher.forward(request, response);
    }

//    private void showUpdateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String id = request.getParameter("id");
//        Product existingUser = iMatBangBo.getMatBangById(id);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
//        request.setAttribute("product", existingUser);
//        dispatcher.forward(request, response);
//    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        try {
            iMatBangBo.deleteMatBang(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<MatBang> listMatBang = iMatBangBo.selectAllMatBang();
        request.setAttribute("listMatBang", listMatBang);
        RequestDispatcher dispatcher = request.getRequestDispatcher("mat_bang/list.jsp");
        dispatcher.forward(request, response);
    }
}
