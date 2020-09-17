package menu.dao;

import menu.model.MatBang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatBangDao implements IMatBangDao {
//    ma varchar(45),
//    dien_tich double,
//    trang_thai varchar(45),
//    tang int,
//    loai_van_phong varchar(45),
//    gia double,
//    ngay_bat_dau date,
//    ngay_ket_thuc date
    public static String INSERT_MAT_BANG_SQL = "insert into mat_bang (ma,dien_tich,trang_thai,tang,loai_van_phong,gia,ngay_bat_dau,ngay_ket_thuc)values (?,?,?,?,?,?,?,?) ";
    public static final String SELECT_ALL_MAT_BANG = "select * from  mat_bang";
    public static final String DELETE_MAT_BANG_SQL = "delete from mat_bang where ma = ?";
    public static final String FIND_MAT_BANG_SQL = "select * from mat_bang where ma = ?";
//    public static final String UPDATE_PRODUCT_SQL = "update product set name=?,price=?,quantity,color=?,`description`=?,category=? where id = ?";
    public static final String SEARCH_MAT_BANG_SQL = "select * from mat_bang where loai_van_phong in (?)";
    @Override
    public List<MatBang> selectAllMatBang() {
        List<MatBang> matBang = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MAT_BANG);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
//                ma,dien_tich,trang_thai,tang,loai_van_phong,gia,ngay_bat_dau,ngay_ket_thuc
                String ma = rs.getString("ma");
                double dien_tich = rs.getDouble("dien_tich");
                String trang_thai = rs.getString("trang_thai");
                int tang = rs.getInt("tang");
                String loai_van_phong = rs.getString("loai_van_phong");
                double gia = rs.getDouble("gia");
                String ngay_bat_dau = rs.getString("ngay_bat_dau");
                String ngay_ket_thuc = rs.getString("ngay_ket_thuc");
                matBang.add(new MatBang(ma,dien_tich,trang_thai,tang,loai_van_phong,gia,ngay_bat_dau,ngay_ket_thuc));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matBang;
    }

    @Override
    public void insertMatBang(MatBang matBang) {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MAT_BANG_SQL);

            preparedStatement.setString(1, matBang.getMa());
            preparedStatement.setDouble(2, matBang.getDienTich());
            preparedStatement.setString(3, matBang.getTrangThai());
            preparedStatement.setInt(4, matBang.getTang());
            preparedStatement.setString(5, matBang.getLoaiVanPhong());
            preparedStatement.setDouble(6, matBang.getGia());
            preparedStatement.setString(7, matBang.getNgayBatDau());
            preparedStatement.setString(8, matBang.getNgayKetThuc());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MatBang getMatBangById(String ma) {
        MatBang matBang = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(FIND_MAT_BANG_SQL);
            preparedStatement.setString(1, ma);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ma = rs.getString("ma");
                double dien_tich = rs.getDouble("dien_tich");
                String trang_thai = rs.getString("trang_thai");
                int tang = rs.getInt("tang");
                String loai_van_phong = rs.getString("loai_van_phong");
                double gia = rs.getDouble("gia");
                String ngay_bat_dau = rs.getString("ngay_bat_dau");
                String ngay_ket_thuc = rs.getString("ngay_ket_thuc");
                matBang = new MatBang(ma,dien_tich,trang_thai,tang,loai_van_phong,gia,ngay_bat_dau,ngay_ket_thuc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matBang;
    }
    @Override
    public void deleteMatBang(String id) throws SQLException {
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_MAT_BANG_SQL);
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
//    @Override
//    public void updateProduct(Product product) throws SQLException {
//        Connection connection = DBConnection.getConnection();
//        PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT_SQL);
//
//        statement.setString(1, product.getProductName());
//        statement.setDouble(2, product.getPrice());
//        statement.setInt(3, product.getQuantity());
//        statement.setString(4, product.getColor());
//        statement.setString(5, product.getDescription());
//        statement.setString(6, product.getCategory());
//        statement.setInt(7, product.getId());
//        statement.executeUpdate();
//    }

    @Override
    public List<MatBang> searchVanPhong(String loai_van_phong) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<MatBang> matBangList = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SEARCH_MAT_BANG_SQL);
                statement.setString(1, loai_van_phong );
                resultSet = statement.executeQuery();
                MatBang matBang = null;
                while (resultSet.next()) {
                    matBang = new MatBang();
                    matBang.setMa(resultSet.getString("ma"));
                    matBang.setDienTich(resultSet.getDouble("dien_tich"));
                    matBang.setTrangThai(resultSet.getString("trang_thai"));
                    matBang.setTang(resultSet.getInt("tang"));
                    matBang.setLoaiVanPhong(resultSet.getString("loai_van_phong"));
                    matBang.setGia(resultSet.getDouble("gia"));
                    matBang.setNgayBatDau(resultSet.getString("ngay_bat_dau"));
                    matBang.setNgayKetThuc(resultSet.getString("ngay_ket_thuc"));
                    matBangList.add(matBang);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return matBangList;
    }

}
