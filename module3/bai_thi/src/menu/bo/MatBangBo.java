package menu.bo;

import menu.dao.IMatBangDao;
import menu.dao.MatBangDao;
import menu.model.MatBang;

import java.sql.SQLException;
import java.util.List;

public class MatBangBo implements IMatBangBo {
    IMatBangDao iMatBangDao = new MatBangDao();

    @Override
    public List<MatBang> selectAllMatBang() {
        return iMatBangDao.selectAllMatBang();
    }

    @Override
    public MatBang getMatBangById(String ma) {
        return iMatBangDao.getMatBangById(ma);
    }

    @Override
    public void deleteMatBang(String ma) throws SQLException {
        iMatBangDao.deleteMatBang(ma);
    }

    @Override
    public void insertMatBang(MatBang matBang) {
        iMatBangDao.insertMatBang(matBang);
    }

    @Override
    public List<MatBang> searchVanPhong(String loai_van_phong) {
        return iMatBangDao.searchVanPhong(loai_van_phong);
    }
}
