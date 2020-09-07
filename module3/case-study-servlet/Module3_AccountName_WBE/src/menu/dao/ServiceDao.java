package menu.dao;

import menu.model.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServiceDao implements  IServiceDao {
    public static String SELECT_ALL_SERVICE = "select * from service";
    public static String INSERT_SERVICE_SQL= "insert into service(service_id,service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,standard_room,description_order_convenience ,pool_area,number_floors) " +
            "values (?,?,?,?,?,?,?,?,?,?,?)";

    @Override
    public void insertService(Service service) {
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(INSERT_SERVICE_SQL);
            preparedStatement.setInt(1,service.getServiceId());
            preparedStatement.setString(2,service.getServiceName());
            preparedStatement.setDouble(3,service.getServiceArea());
            preparedStatement.setDouble(4,service.getServiceCost());
            preparedStatement.setInt(5,service.getServiceMaxPeople());
            preparedStatement.setInt(6,service.getRentTypeId());
            preparedStatement.setInt(7,service.getServiceTypeId());
            preparedStatement.setString(8,service.getStandardRoom());
            preparedStatement.setString(9,service.getDescriptionOrderConvenience());
            preparedStatement.setDouble(10,service.getPoolArea());
            preparedStatement.setInt(11,service.getNumberFloor());
            preparedStatement.executeUpdate();
        } catch ( SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
