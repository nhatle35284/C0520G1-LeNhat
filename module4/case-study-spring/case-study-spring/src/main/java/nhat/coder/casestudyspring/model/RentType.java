package nhat.coder.casestudyspring.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class RentType {
    @Id
    private String rentTypeId;
    private String rentTypeName;
    private String rentTypeCost;

    @OneToMany(mappedBy = "rentType")
    private Collection<Service> services;

    public RentType() {
    }

    public String getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(String rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public String getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(String rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }

    public Collection<Service> getServices() {
        return services;
    }

    public void setServices(Collection<Service> services) {
        this.services = services;
    }
}
