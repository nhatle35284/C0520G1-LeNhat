package menu.controller;

import menu.bo.contractBo.ContractBo;
import menu.bo.contractBo.IContractBo;
import menu.bo.contractDetailBo.ContractDetailBo;
import menu.bo.contractDetailBo.IContractDetailBo;
import menu.bo.customerBo.CustomerBo;
import menu.bo.customerBo.ICustomerBo;
import menu.bo.employeeBo.EmployeeBo;
import menu.bo.employeeBo.IEmployeeBo;
import menu.bo.serviceBo.IServiceBo;
import menu.bo.serviceBo.ServiceBo;
import menu.model.*;

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
    IEmployeeBo iEmployeeBo = new EmployeeBo();
    IContractBo iContractBo = new ContractBo();
    IContractDetailBo iContractDetailBo = new ContractDetailBo();


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
            case "create_contract":
                createContract(request, response);
                break;
            case "create_contract_detail":
                createContractDetail(request, response);
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
            case "edit_employee":
                updateEmployee(request, response);
                break;
            case "search_employee":
                searchByName(request, response);
                break;
            default:
                break;
        }
    }

    private void createContractDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //contract_detail_id,contract_id,attach_service_id,quantity
        int contract_detail_id = Integer.parseInt(request.getParameter("contract_detail_id"));
        int contract_id = Integer.parseInt(request.getParameter("contract_id"));
        int quantity = Integer.parseInt(request.getParameter("attach_service_id"));
        int attach_service_id = Integer.parseInt(request.getParameter("quantity"));
        ContractDetail contractDetail = new ContractDetail(attach_service_id,contract_detail_id, contract_id, quantity);
        iContractDetailBo.insertContractDetail(contractDetail);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract_detail/create.jsp");
        dispatcher.forward(request, response);
    }

    private void createContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int contract_id = Integer.parseInt(request.getParameter("contract_id"));
        String contract_start_date = request.getParameter("contract_start_date");
        String contract_end_date = request.getParameter("contract_end_date");
        double contract_deposit = Double.parseDouble(request.getParameter("contract_deposit"));
        double contract_total_money = Double.parseDouble(request.getParameter("contract_total_money"));
        int employee_id = Integer.parseInt(request.getParameter("employee_id"));
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        int service_id = Integer.parseInt(request.getParameter("service_id"));
        Contract contract = new Contract(contract_id, contract_start_date, contract_end_date, contract_deposit, contract_total_money, employee_id, customer_id, service_id);
        iContractBo.insertContract(contract);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/create.jsp");
        dispatcher.forward(request, response);
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Employee> listEmployee = null;
        try {
            listEmployee = iEmployeeBo.searchByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        request.setAttribute("listEmployee", listEmployee);
//        request.setAttribute("message","List ALL Users");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        try {
            iEmployeeBo.updateEmployee(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/edit.jsp");

        dispatcher.forward(request, response);
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
                showListEmployee(request, response);
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
            case "edit_employee":
                showUpdateEmployee(request, response);
                break;
            case "delete_employee":
                deleteEmployee(request, response);
                break;
            default:
                showAllCustomer(request, response);
                break;
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            iEmployeeBo.deleteEmployee(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showUpdateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee existingUser = iEmployeeBo.getEmployeeById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/edit.jsp");
        request.setAttribute("employee", existingUser);
        dispatcher.forward(request, response);
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
