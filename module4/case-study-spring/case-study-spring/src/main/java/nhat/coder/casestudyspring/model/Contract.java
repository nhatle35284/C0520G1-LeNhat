package nhat.coder.casestudyspring.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Contract {
    @Id
    private String contractId;
    private String contractStartDate;
    private String contractEndDate;
    private String contractDeposit;
    private String ContractTotalMoney;

    @ManyToOne()
    @JoinColumn(name = "customerId")
    private Customer customer;
    @ManyToOne()
    @JoinColumn(name = "employeeId")
    private Employee employee;


    @ManyToOne()
    @JoinColumn(name = "serviceId")
    private Service service;

    @OneToMany(mappedBy = "contract")
    private Collection<ContractDetail> contractDetails;


    public Contract() {
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public String getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(String contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public String getContractTotalMoney() {
        return ContractTotalMoney;
    }

    public void setContractTotalMoney(String contractTotalMoney) {
        ContractTotalMoney = contractTotalMoney;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
//
//    public Collection<ContractDetail> getContractDetails() {
//        return contractDetails;
//    }
//
//    public void setContractDetails(Collection<ContractDetail> contractDetails) {
//        this.contractDetails = contractDetails;
//    }
}
