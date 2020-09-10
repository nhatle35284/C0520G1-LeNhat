package menu.dao.contractDetailDao;

import menu.dao.DBConnection;
import menu.model.ContractDetail;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContractDetailDao implements  IContractDetailDao {
//    insertContractDetail
public static String INSERT_CONTRACT_DETAIL_SQL= "insert into contract_detail(contract_detail_id,contract_id,attach_service_id,quantity) values (?,?,?,?)";
    @Override
    public void insertContractDetail(ContractDetail contractDetail) {
        try {
            PreparedStatement preparedStatement = null;
            preparedStatement = DBConnection.getConnection().prepareStatement(INSERT_CONTRACT_DETAIL_SQL);
            preparedStatement.setInt(1, contractDetail.getContractDetailId());
            preparedStatement.setInt(2, contractDetail.getContractId());
            preparedStatement.setInt(3, contractDetail.getAttachServiceId());
            preparedStatement.setString(4, contractDetail.getQuantity());
            preparedStatement.executeUpdate();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
}
