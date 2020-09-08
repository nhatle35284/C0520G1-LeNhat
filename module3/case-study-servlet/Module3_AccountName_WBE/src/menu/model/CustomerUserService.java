package menu.model;

public class CustomerUserService {
//    customer.customer_id,customer.customer_name,service.service_id,service.service_name,contract.contract_id,attach_service.attach_service_name
    private int customerId;
    private String customerName;
    private int serviceId;
    private String serviceName;
    private int contractId;
    private String attachServiceName;

    public CustomerUserService(int customerId, String customerName, int serviceId, String serviceName, int contractId, String attachServiceName) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.contractId = contractId;
        this.attachServiceName = attachServiceName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }
}
