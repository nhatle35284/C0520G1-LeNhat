package menu.bo;

import menu.model.MatBang;

import java.sql.SQLException;
import java.util.List;

public interface IMatBangBo {
    public List<MatBang> selectAllMatBang();
    public MatBang getMatBangById(String id);
    public void deleteMatBang(String id) throws SQLException;
    public void insertMatBang(MatBang matBang);
    public List<MatBang> searchVanPhong(String loai_van_phong);
}
