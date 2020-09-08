package menu.dao.serviceDao;

import menu.dao.DBConnection;
import menu.model.Employee;
import menu.model.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDao implements IServiceDao {
    public static String FIND_SERVICE_SQL = "select service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,standard_room,description_order_convenience,pool_area,number_floors from service where service_id=?";
    public static String SEARCH_SERVICE_SQL = "select *from service where service_name like ?";
    public static String DELETE_SERVICE_SQL = "delete from service where service_id=?";
    public static String SELECT_ALL_SERVICE = "select * from service";
    public static String INSERT_SERVICE_SQL= "insert into service(service_id,service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,standard_room,description_order_convenience ,pool_area,number_floors) " +
            "values (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE_SERVICE_SQL = "update service set service_name=?,service_area=?,service_cost=?,service_max_people=?,rent_type_id=?,service_type_id=?,standard_room=?,description_order_convenience=?,pool_area=?,number_floors=? where service_id = ?";


    @Override
    public List<Service> searchByName(String name) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Service> serviceList = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SEARCH_SERVICE_SQL);
                statement.setString(1, "%" + name + "%");
                resultSet = statement.executeQuery();
                Service service = null;
                while (resultSet.next()) {
                    service = new Service();
                    service.setServiceId(resultSet.getInt("service_id"));
                    service.setServiceName(resultSet.getString("service_name"));
                    service.setServiceArea(resultSet.getDouble("service_area"));
                    service.setServiceCost(resultSet.getDouble("service_cost"));
                    service.setServiceMaxPeople(resultSet.getInt("service_max_people"));
                    service.setRentTypeId(resultSet.getInt("rent_type_id"));
                    service.setServiceTypeId(resultSet.getInt("service_type_id"));
                    service.setStandardRoom(resultSet.getString("standard_room"));
                    service.setDescriptionOrderConvenience(resultSet.getString("description_order_convenience"));
                    service.setPoolArea(resultSet.getInt("pool_area"));
                    service.setNumberFloor(resultSet.getInt("number_floors"));
                    serviceList.add(service);
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
        return serviceList;
    }
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
    @Override
    public List<Service> selectAllService() {
        List<Service> listService = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int serviceId = rs.getInt("service_id");
                String serviceName = rs.getString("service_name");
                double serviceArea = rs.getDouble("service_area");
                double serviceCost = rs.getDouble("service_cost");
                int serviceMaxPeople = rs.getInt("service_max_people");
                int rentTypeId = rs.getInt("rent_type_id");
                int serviceTypeId = rs.getInt("service_type_id");
                String standardRoom = rs.getString("standard_room");
                String descriptionOrderConvenience = rs.getString("description_order_convenience");
                double poolArea = rs.getDouble("pool_area");
                int numberFloor = rs.getInt("number_floors");
                listService.add(new Service(serviceId, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId, serviceTypeId, standardRoom, descriptionOrderConvenience,poolArea,numberFloor));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listService;
    }
    @Override
    public void updateService(Service service) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE_SERVICE_SQL);
        statement.setString(1, service.getServiceName());
        statement.setDouble(2, service.getServiceArea());
        statement.setDouble(3, service.getServiceCost());
        statement.setInt(4, service.getServiceMaxPeople());
        statement.setInt(5, service.getRentTypeId());
        statement.setInt(6, service.getServiceTypeId());
        statement.setString(7, service.getDescriptionOrderConvenience());
        statement.setDouble(8, service.getPoolArea());
        statement.setDouble(9, service.getPoolArea());
        statement.setInt(10, service.getNumberFloor());
        statement.setInt(11, service.getServiceId());
        statement.executeUpdate();
    }
    @Override
    public Service getServiceById(int id) {
        Service service = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(FIND_SERVICE_SQL);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String serviceName = rs.getString("service_name");
                double serviceArea = rs.getDouble("service_area");
                double serviceCost = rs.getDouble("service_cost");
                int serviceMaxPeople = rs.getInt("service_max_people");
                int rentTypeId = rs.getInt("rent_type_id");
                int serviceTypeId = rs.getInt("service_type_id");
                String standardRoom = rs.getString("standard_room");
                String descriptionOrderConvenience = rs.getString("description_order_convenience");
                double poolArea = rs.getDouble("pool_area");
                int numberFloor = rs.getInt("number_floors");
                service = new Service(id, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId, serviceTypeId, standardRoom, descriptionOrderConvenience, poolArea, numberFloor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return service;
    }
    @Override
    public void deleteService(int id) {
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_SERVICE_SQL);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
