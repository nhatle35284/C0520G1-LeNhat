package menu.dao;

import menu.model.MatBang;

import java.sql.SQLException;
import java.util.List;

public interface IMatBangDao {
    public List<MatBang> selectAllMatBang();
    public MatBang getMatBangById(String ma);
    public void deleteMatBang(String ma) throws SQLException;
    public void insertMatBang(MatBang matBang);
//    public void updateProduct(MatBang matBang) throws SQLException;
    public List<MatBang> searchVanPhong(String loai_van_phong);
}
