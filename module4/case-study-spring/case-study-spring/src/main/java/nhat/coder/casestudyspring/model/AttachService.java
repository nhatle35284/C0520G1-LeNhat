package nhat.coder.casestudyspring.model;

import javax.persistence.*;
import java.util.Collection;


@Entity
public class AttachService {
    @Id
    private String attachServiceId;
    private String attachServiceName;
    private String attachServiceCost;
    private String attachServiceUnit;
    private String attachServiceStatus;
    @OneToMany(mappedBy = "attachService")
    private Collection<ContractDetail> contractDetails;

    public AttachService() {
    }

    public String getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(String attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public String getAttachServiceCost() {
        return attachServiceCost;
    }

    public void setAttachServiceCost(String attachServiceCost) {
        this.attachServiceCost = attachServiceCost;
    }

    public String getAttachServiceUnit() {
        return attachServiceUnit;
    }

    public void setAttachServiceUnit(String attachServiceUnit) {
        this.attachServiceUnit = attachServiceUnit;
    }

    public String getAttachServiceStatus() {
        return attachServiceStatus;
    }

    public void setAttachServiceStatus(String attachServiceStatus) {
        this.attachServiceStatus = attachServiceStatus;
    }

    public Collection<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Collection<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
