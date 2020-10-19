package nhat.coder.casestudyspring.model;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    private String contractDetailId;
//    private String contractId;
//    private String attachServiceId;
    private String quantity;


    @ManyToOne()
    @JoinColumn(name = "contractId")
    private Contract contract;

    @ManyToOne()
    @JoinColumn(name = "attachServiceId")
    private AttachService attachService;


    public ContractDetail() {
    }

    public String getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(String contractDetailId) {
        this.contractDetailId = contractDetailId;
    }
//
//    public String getContractId() {
//        return contractId;
//    }
//
//    public void setContractId(String contractId) {
//        this.contractId = contractId;
//    }

//    public String getAttachServiceId() {
//        return attachServiceId;
//    }
//
//    public void setAttachServiceId(String attachServiceId) {
//        this.attachServiceId = attachServiceId;
//    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

//    public AttachService getAttachService() {
//        return attachService;
//    }
//
//    public void setAttachService(AttachService attachService) {
//        this.attachService = attachService;
//    }
}
