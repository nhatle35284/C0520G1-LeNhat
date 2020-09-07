package menu.controller;

import menu.bo.*;
import menu.model.Customer;
import menu.model.Employee;
import menu.model.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "FuramaServlet", urlPatterns = {"", "/homePage"})
public class FuramaServlet extends HttpServlet {
    ICustomerBo iCustomerBo = new CustomerBo();
    IServiceBo iServiceBo = new ServiceBo();
    EmployeeBo iEmployeeBo = new EmployeeBo();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertCustomer(request, response);
                break;
            case "create_service":
                createService(request, response);
                break;
            case "create_employee":
                createEmployee(request, response);
                break;
            case "edit":
                try {
                    updateCustomer(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employee_id"));
        String employeeName = request.getParameter("employee_name");
        String employeeBirthday = request.getParameter("employee_birthday");
        String employeeIdCard = request.getParameter("employee_id_card");
        double employeeSalary = Double.parseDouble(request.getParameter("employee_salary"));
        String employeePhone = request.getParameter("employee_phone");
        String employeeEmail = request.getParameter("employee_email");
        String employeeAddress = request.getParameter("employee_address");
        int positionId = Integer.parseInt(request.getParameter("position_id"));
        int educationDegreeId = Integer.parseInt(request.getParameter("education_degree_id"));
        int divisionId = Integer.parseInt(request.getParameter("division_id"));
        String userName = request.getParameter("user_name");
        Employee employee = new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId, divisionId, userName);
        iEmployeeBo.insertEmployee(employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        dispatcher.forward(request, response);
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int serviceId = Integer.parseInt(request.getParameter("service_id"));
        String serviceName = request.getParameter("service_name");
        double serviceArea = Double.parseDouble(request.getParameter("service_area"));
        double serviceCost = Double.parseDouble(request.getParameter("service_cost"));
        int serviceMaxPeople = Integer.parseInt(request.getParameter("service_max_people"));
        int rentTypeId = Integer.parseInt(request.getParameter("rent_type_id"));
        int serviceTypeId = Integer.parseInt(request.getParameter("service_type_id"));
        String standardRoom = request.getParameter("standard_room");
        String descriptionOrderConvenience = request.getParameter("description_order_convenience");
        double poolArea = Double.parseDouble(request.getParameter("pool_area"));
        int numberFloors = Integer.parseInt(request.getParameter("number_floors"));

        Service service = new Service(serviceId, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId, serviceTypeId, standardRoom, descriptionOrderConvenience, poolArea, numberFloors);
        iServiceBo.insertService(service);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/create.jsp");
        dispatcher.forward(request, response);
        try {
            response.sendRedirect("/homePage");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        iCustomerBo.deleteCustomer(id);

        List<Customer> ListCustomer = iCustomerBo.selectAllCustomer();
        request.setAttribute("ListCustomer", ListCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("customer_id"));
        int customerTypeId = Integer.parseInt(request.getParameter("customer_type_id"));
        String customerName = request.getParameter("customer_name");
        String customerBirthday = request.getParameter("customer_birthday");
        int customerGender = Integer.parseInt(request.getParameter("customer_gender"));
        int customerIdCard = Integer.parseInt(request.getParameter("customer_id_card"));
        String customerPhone = request.getParameter("customer_phone");
        String customerEmail = request.getParameter("customer_email");
        String customerAddress = request.getParameter("customer_address");

        Customer customer = new Customer(customerId, customerTypeId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);

        iCustomerBo.updateCustomer(customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");

        dispatcher.forward(request, response);
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("customer_id"));
        int customerTypeId = Integer.parseInt(request.getParameter("customer_type_id"));
        String customerName = request.getParameter("customer_name");
        String customerBirthday = request.getParameter("customer_birthday");
        int customerGender = Integer.parseInt(request.getParameter("customer_gender"));
        int customerIdCard = Integer.parseInt(request.getParameter("customer_id_card"));
        String customerPhone = request.getParameter("customer_phone");
        String customerEmail = request.getParameter("customer_email");
        String customerAddress = request.getParameter("customer_address");

        Customer customerAdd = new Customer(customerId, customerTypeId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
        iCustomerBo.insertCustomer(customerAdd);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create_customer.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showNewCustomer(request, response);
                break;
            case "create_service":
                showNewService(request, response);
                break;
            case "create_employee":
                showNewEmployee(request, response);
                break;
            case "list_employee":
                showListEmployee(request,response);
                break;
            case "list":
                showList(request, response);
                break;
            case "edit":
                showUpdateCustomer(request, response);
                break;
            case "delete":
                try {
                    deleteCustomer(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                showAllCustomer(request, response);
                break;
        }
    }

    private void showListEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> listEmployee = iEmployeeBo.selectAllEmployee();
        request.setAttribute("listEmployee", listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showNewEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showUpdateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer existingUser = iCustomerBo.getCustomerById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        request.setAttribute("customer", existingUser);
        dispatcher.forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> listCustomer = this.iCustomerBo.selectAllCustomer();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showNewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create_customer.jsp");
        dispatcher.forward(request, response);
    }

    private void showAllCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> listCustomer = iCustomerBo.selectAllCustomer();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/display.jsp");
        dispatcher.forward(request, response);
    }
}
