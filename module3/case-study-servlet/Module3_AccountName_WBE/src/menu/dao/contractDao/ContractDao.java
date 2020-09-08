package menu.dao.contractDao;

import menu.dao.DBConnection;
import menu.model.Contract;
import menu.model.Employee;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContractDao implements  IContractDao {
    public static String INSERT_CONTRACT_SQL= "insert into contract(contract_id,contract_start_date,contract_end_date,contract_deposit,contract_total_money,employee_id,customer_id,service_id) values (?,?,?,?,?,?,?,?)";
    @Override
    public void insertContract(Contract contract) {
        try {
            PreparedStatement preparedStatement = null;
            preparedStatement = DBConnection.getConnection().prepareStatement(INSERT_CONTRACT_SQL);
            preparedStatement.setInt(1, contract.getContractId());
            preparedStatement.setString(2, contract.getContractStartDate());
            preparedStatement.setString(3, contract.getContractEndDate());
            preparedStatement.setDouble(4, contract.getContractDeposit());
            preparedStatement.setDouble(5, contract.getContractTotalMoney());
            preparedStatement.setInt(6, contract.getEmployeeId());
            preparedStatement.setInt(7, contract.getCustomerId());
            preparedStatement.setInt(8, contract.getServiceId());
            preparedStatement.executeUpdate();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
}
