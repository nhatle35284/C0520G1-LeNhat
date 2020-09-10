package menu.controller;

import menu.bo.common.Validate;
import menu.bo.contractBo.ContractBo;
import menu.bo.contractBo.IContractBo;
import menu.bo.contractDetailBo.ContractDetailBo;
import menu.bo.contractDetailBo.IContractDetailBo;
import menu.bo.customerBo.CustomerBo;
import menu.bo.customerBo.ICustomerBo;
import menu.bo.customerUserServiceBo.CustomerUserServiceBo;
import menu.bo.customerUserServiceBo.ICustomerUserServiceBo;
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
    ICustomerUserServiceBo iCustomerUserServiceBo = new CustomerUserServiceBo();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertCustomer(request, response);
                break;
            case "edit":
                try {
                    updateCustomer(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "search_customer":
                searchByNameCustomer(request, response);
                break;
            case "create_service":
                createService(request, response);
                break;
            case "edit_service":
                updateService(request, response);
                break;
            case "search_service":
                searchByNameService(request, response);
                break;
            case "create_employee":
                createEmployee(request, response);
                break;
            case "edit_employee":
                updateEmployee(request, response);
                break;
            case "search_employee":
                searchByName(request, response);
                break;
            case "create_contract":
                createContract(request, response);
                break;
            case "create_contract_detail":
                createContractDetail(request, response);
                break;
            default:
                break;
        }
    }

    /**CRUD Customer Do Post**/
    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerId = request.getParameter("customer_id");
        int customerTypeId = Integer.parseInt(request.getParameter("customer_type_id"));
        String customerName = request.getParameter("customer_name");
        String customerBirthday = request.getParameter("customer_birthday");
        int customerGender = Integer.parseInt(request.getParameter("customer_gender"));
        String customerIdCard = request.getParameter("customer_id_card");
        String customerPhone = request.getParameter("customer_phone");
        String customerEmail = request.getParameter("customer_email");
        String customerAddress = request.getParameter("customer_address");
        if (!Validate.isValid(customerId, Validate.REGEX_ID_CUSTOMER)) {
            request.setAttribute("message", "Enter the wrong customer id!!(KH_XXXX)");
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create_customer.jsp");
            dispatcher.forward(request, response);
        } else if (!Validate.isValid(customerPhone, Validate.REGEX_NUMBER_PHONE)) {
            request.setAttribute("message1", "Enter the wrong number phone!!(090XXXXXXX)");
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create_customer.jsp");
            dispatcher.forward(request, response);
        }else if (!Validate.isValid(customerIdCard, Validate.REGEX_ID)) {
            request.setAttribute("message2", "Enter the wrong ID Card!!(XXXXXXXXX-XXXXXXXXXXXX)");
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create_customer.jsp");
            dispatcher.forward(request, response);
        }else if (!Validate.isValid(customerEmail, Validate.REGEX_EMAIL)) {
            request.setAttribute("message3", "Enter the wrong email!!(wwwwwww@ww.ww)");
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create_customer.jsp");
            dispatcher.forward(request, response);
        }else {
            Customer customerAdd = new Customer(customerId, customerTypeId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
            iCustomerBo.insertCustomer(customerAdd);
            List<Customer> listCustomer = iCustomerBo.selectAllCustomer();
            request.setAttribute("listCustomer", listCustomer);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
            dispatcher.forward(request, response);
        }


    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String customerId = request.getParameter("customer_id");
        int customerTypeId = Integer.parseInt(request.getParameter("customer_type_id"));
        String customerName = request.getParameter("customer_name");
        String customerBirthday = request.getParameter("customer_birthday");
        int customerGender = Integer.parseInt(request.getParameter("customer_gender"));
        String customerIdCard = request.getParameter("customer_id_card");
        String customerPhone = request.getParameter("customer_phone");
        String customerEmail = request.getParameter("customer_email");
        String customerAddress = request.getParameter("customer_address");
        if (!Validate.isValid(customerPhone, Validate.REGEX_NUMBER_PHONE)) {

            request.setAttribute("message", "Enter wrong number phone!!(090XXXXXXX)");
            Customer customer = iCustomerBo.getCustomerById(customerId);
            request.setAttribute("customer", customer);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");

            dispatcher.forward(request, response);
        } else if (!Validate.isValid(customerIdCard, Validate.REGEX_ID)) {

            request.setAttribute("message1", "Enter wrong ID Card!(XXXXXXXXX-XXXXXXXXXXXX)");
            Customer customer = iCustomerBo.getCustomerById(customerId);
            request.setAttribute("customer", customer);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");

            dispatcher.forward(request, response);
        }else if (!Validate.isValid(customerEmail, Validate.REGEX_EMAIL)) {

            request.setAttribute("message2", "Enter wrong Email!(wwwwww@WWW.WWW)");
            Customer customer = iCustomerBo.getCustomerById(customerId);
            request.setAttribute("customer", customer);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");

            dispatcher.forward(request, response);
        }else {
            Customer customer = new Customer(customerId, customerTypeId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
            iCustomerBo.updateCustomer(customer);

            List<Customer> listCustomer = iCustomerBo.selectAllCustomer();
            request.setAttribute("listCustomer", listCustomer);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
            dispatcher.forward(request, response);
        }

    }

    private void searchByNameCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Customer> listCustomer = null;
        listCustomer = iCustomerBo.searchByName(name);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        request.setAttribute("listCustomer", listCustomer);
//        request.setAttribute("message","List ALL Users");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * END CRUD Customer Do Post
     * <p>
     * /** CRUD Service do do Post
     **/

    private void createService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String serviceId = request.getParameter("service_id");
        String serviceName = request.getParameter("service_name");
        double serviceArea = Double.parseDouble(request.getParameter("service_area"));
        double serviceCost = Double.parseDouble(request.getParameter("service_cost"));
        int serviceMaxPeople = Integer.parseInt(request.getParameter("service_max_people"));
        int rentTypeId = Integer.parseInt(request.getParameter("rent_type_id"));
        int serviceTypeId = Integer.parseInt(request.getParameter("service_type_id"));
        String standardRoom = request.getParameter("standard_room");
        String descriptionOrderConvenience = request.getParameter("description_order_convenience");
        double poolArea = Double.parseDouble(request.getParameter("pool_area"));
        String numberFloors = request.getParameter("number_floors");
        if (!Validate.isValid(serviceId, Validate.REGEX_ID_SERVICE)) {
            request.setAttribute("message", "Enter wrong Service id!!(SV_XXXX)");
            RequestDispatcher dispatcher = request.getRequestDispatcher("service/create.jsp");
            dispatcher.forward(request, response);
        } else {
            Service service = new Service(serviceId, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId, serviceTypeId, standardRoom, descriptionOrderConvenience, poolArea, numberFloors);
            iServiceBo.insertService(service);
            List<Service> listService = iServiceBo.selectAllService();
            request.setAttribute("listService", listService);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void updateService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String serviceId = request.getParameter("service_id");
        String serviceName = request.getParameter("service_name");
        double serviceArea = Double.parseDouble(request.getParameter("service_area"));
        double serviceCost = Double.parseDouble(request.getParameter("service_cost"));
        int serviceMaxPeople = Integer.parseInt(request.getParameter("service_max_people"));
        int rentTypeId = Integer.parseInt(request.getParameter("rentType_id"));
        int serviceTypeId = Integer.parseInt(request.getParameter("service_type_id"));
        String standardRoom = request.getParameter("standard_room");
        String descriptionOrderConvenience = request.getParameter("description_order_convenience");
        int poolArea = Integer.parseInt(request.getParameter("pool_area"));
        String numberFloor = request.getParameter("number_floor");
        if (Validate.isValid(serviceId, Validate.REGEX_ID_SERVICE)) {
            Service service = new Service(serviceId, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId, serviceTypeId, standardRoom, descriptionOrderConvenience, poolArea, numberFloor);
            try {
                iServiceBo.updateService(service);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("message", "Enter wrong service id!!(SV_XXXX");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/edit.jsp");

        dispatcher.forward(request, response);
    }

    private void searchByNameService(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Service> listService = null;
        listService = iServiceBo.searchByName(name);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/list.jsp");
        request.setAttribute("listService", listService);
//        request.setAttribute("message","List ALL Users");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /** END CRUD Service do Post**/

    /**
     * CRUD Employee do Post
     **/
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
        if (Validate.isValid(employeePhone, Validate.REGEX_NUMBER_PHONE)) {
            request.setAttribute("message", "Enter wrong Number Phone");
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
            dispatcher.forward(request, response);
        } else if (Validate.isValid(employeeIdCard, Validate.REGEX_ID)) {
            request.setAttribute("message1", "Enter wrong ID Card");
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
            dispatcher.forward(request, response);
        }else if (Validate.isValid(employeeEmail, Validate.REGEX_EMAIL)) {
            request.setAttribute("message2", "Enter wrong ID Card");
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
            dispatcher.forward(request, response);
        } else {
            Employee employee = new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId, divisionId, userName);
            iEmployeeBo.insertEmployee(employee);
            List<Employee> listEmployee = iEmployeeBo.selectAllEmployee();
            request.setAttribute("listEmployee", listEmployee);
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
            dispatcher.forward(request, response);
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
        if (!Validate.isValid(employeePhone, Validate.REGEX_NUMBER_PHONE)) {

            request.setAttribute("message", "Enter Wrong number phone!!!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee/edit.jsp");
            dispatcher.forward(request, response);
        }else if (!Validate.isValid(employeeIdCard, Validate.REGEX_ID)) {
            request.setAttribute("message1", "Enter Wrong ID Card!!!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee/edit.jsp");
            dispatcher.forward(request, response);
        }else if (!Validate.isValid(employeeEmail, Validate.REGEX_EMAIL)) {
            request.setAttribute("message2", "Enter Wrong Email!!!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee/edit.jsp");
            dispatcher.forward(request, response);
        } else {
            Employee employee = new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId, divisionId, userName);
            try {
                iEmployeeBo.updateEmployee(employee);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            List<Employee> listEmployee = iEmployeeBo.selectAllEmployee();
            request.setAttribute("listEmployee", listEmployee);
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
            dispatcher.forward(request, response);
        }

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
    /** END CRUD Employee do Post**/

    /**
     * Create Contract doPost
     **/
    private void createContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int contract_id = Integer.parseInt(request.getParameter("contract_id"));
        String contract_start_date = request.getParameter("contract_start_date");
        String contract_end_date = request.getParameter("contract_end_date");
        double contract_deposit = Double.parseDouble(request.getParameter("contract_deposit"));
        double contract_total_money = Double.parseDouble(request.getParameter("contract_total_money"));
        int employee_id = Integer.parseInt(request.getParameter("employee_id"));
        String customer_id = request.getParameter("customer_id");
        String service_id = request.getParameter("service_id");
        if (Validate.isValid(service_id,Validate.REGEX_ID_CUSTOMER)){
            request.setAttribute("message","Enter wrong service ID!!!(SV_XXXX) ");
            RequestDispatcher dispatcher = request.getRequestDispatcher("contract/create.jsp");
            dispatcher.forward(request, response);
        } else {
            Contract contract = new Contract(contract_id, contract_start_date, contract_end_date, contract_deposit, contract_total_money, employee_id, customer_id, service_id);
            iContractBo.insertContract(contract);
            request.setAttribute("message","Enter successfully");
            RequestDispatcher dispatcher = request.getRequestDispatcher("contract/create.jsp");
            dispatcher.forward(request, response);
        }
    }

    /**End**/
    private void createContractDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //contract_detail_id,contract_id,attach_service_id,quantity
        int contract_detail_id = Integer.parseInt(request.getParameter("contract_detail_id"));
        int contract_id = Integer.parseInt(request.getParameter("contract_id"));
        String quantity = request.getParameter("attach_service_id");
        int attach_service_id = Integer.parseInt(request.getParameter("quantity"));
        ContractDetail contractDetail = new ContractDetail(attach_service_id, contract_detail_id, contract_id, quantity);
        iContractDetailBo.insertContractDetail(contractDetail);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract_detail/create.jsp");
        dispatcher.forward(request, response);
    }
    /** Create Contract Detail**/

    /**
     * End Create Contract
     **/



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "list":
                showList(request, response);
                break;
            case "create":
                showNewCustomer(request, response);
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

            case "list_service":
                showListService(request, response);
                break;
            case "create_service":
                showNewService(request, response);
                break;
            case "edit_service":
                showUpdateService(request, response);
                break;
            case "delete_service":
                deleteService(request, response);
                break;


            case "create_employee":
                showNewEmployee(request, response);
                break;
            case "list_employee":
                showListEmployee(request, response);
                break;
            case "edit_employee":
                showUpdateEmployee(request, response);
                break;
            case "delete_employee":
                deleteEmployee(request, response);
                break;


            case "create_contract":
                showNewContract(request, response);
                break;

            case "create_contract_detail":
                showNewContractDetail(request, response);
                break;

            case "list_user_service":
                showListUserService(request, response);
                break;

            default:
                showAllCustomer(request, response);
                break;
        }
        }

    /** CRUD Customer doGet**/
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
    private void showUpdateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Customer existingUser = iCustomerBo.getCustomerById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        request.setAttribute("customer", existingUser);
        dispatcher.forward(request, response);
    }
    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String id = request.getParameter("id");
        iCustomerBo.deleteCustomer(id);

        List<Customer> listCustomer = iCustomerBo.selectAllCustomer();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request, response);
    }
    private void showAllCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> listCustomer = iCustomerBo.selectAllCustomer();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/display.jsp");
        dispatcher.forward(request, response);
    }

    /**End CRUD Customer doGet**/


    /** CRUD Service doGet**/
    private void showListService(HttpServletRequest request, HttpServletResponse response) {
        List<Service> listService = iServiceBo.selectAllService();
        request.setAttribute("listService", listService);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showNewService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/create.jsp");
        dispatcher.forward(request, response);
    }
    private void showUpdateService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Service existingService = iServiceBo.getServiceById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/edit.jsp");
        request.setAttribute("service", existingService);
        dispatcher.forward(request, response);
    }
    private void deleteService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        iServiceBo.deleteService(id);

        List<Service> listService = iServiceBo.selectAllService();
        request.setAttribute("listService", listService);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/list.jsp");
        dispatcher.forward(request, response);
    }
    /**End CRUD Service doGet**/


    /** CRUD Employee doGet**/
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
    private void showUpdateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee existingUser = iEmployeeBo.getEmployeeById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/edit.jsp");
        request.setAttribute("employee", existingUser);
        dispatcher.forward(request, response);
    }
    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            iEmployeeBo.deleteEmployee(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Employee> listEmployee = iEmployeeBo.selectAllEmployee();
        request.setAttribute("listEmployee", listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request, response    );
    }

    /**End CRUD Employee doGet**/


    /** Create Contract doGet**/
    private void showNewContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/create.jsp");
        dispatcher.forward(request, response);
    }
    /**End CRUD Customer doGet**/


    /** Create Contract Detail doGet**/
    private void showNewContractDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract_details/create.jsp");
        dispatcher.forward(request, response);
    }
    /**End CRUD Customer doGet**/

    /** Create List All Customer Using Service doGet**/
    private void showListUserService(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerUserService> listUserService = iCustomerUserServiceBo.selectCustomerUserService();
        request.setAttribute("listUserService", listUserService);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/customer_using_service.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**End List All Customer Using Service doGet**/



}
