package menu.dao.customerUserService;

import menu.dao.DBConnection;
import menu.model.CustomerUserService;
import menu.model.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerUserServiceDao implements ICustomerUserServiceDao {
    public static String SELECT_ALL_SERVCIE ="select *from service;";
    public static String CUSTOMER_USER_SERVICE_SQL = "select customer.customer_id,customer.customer_name,service.service_id,service.service_name,contract.contract_id,attach_service.attach_service_name\n" +
            "from customer\n" +
            "inner join contract on customer.customer_id = contract.customer_id\n" +
            "inner join service on service.service_id = contract.service_id\n" +
            "inner join contract_detail on contract.contract_id = contract_detail.contract_id\n" +
            "inner join attach_service on contract_detail.attach_service_id = attach_service.attach_service_id;";
    @Override
    public List<CustomerUserService> selectCustomerUserService() {
        List<CustomerUserService> listUserService = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CUSTOMER_USER_SERVICE_SQL);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String customerId = rs.getString("customer_id");
                String customerName = rs.getString("customer_name");
                String serviceId = rs.getString("service_id");
                String serviceName = rs.getString("service_name");
                int contractId = rs.getInt("contract_id");
                String attachServiceName = rs.getString("attach_service_name");
                listUserService.add(new CustomerUserService(customerId,customerName, serviceId, serviceName, contractId, attachServiceName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listUserService;
    }

    @Override
    public List<Service> selectAllService() {
        List<Service> services = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVCIE);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String serviceId = rs.getString("service_id");
                String serviceName = rs.getString("service_name");
                double serviceArea = rs.getDouble("service_area");
                double serviceCost = rs.getDouble("service_cost");
                int serviceMaxPeople = rs.getInt("service_max_people");
                int rentTypeId = rs.getInt("customer_id_card");
                int serviceTypeId = rs.getInt("service_type_id");
                String standardRoom = rs.getString("standard_room");
                String descriptionOrderConvenience = rs.getString("description_order_convenience");
                double poolArea = rs.getDouble("pool_area");
                int numberFloor = rs.getInt("number_floor");
                services.add(new Service(serviceId, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId, serviceTypeId, standardRoom, descriptionOrderConvenience,poolArea,numberFloor));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }
    @Override
    public void deleteCustomerUserService(int id) throws SQLException {

    }
}