package nhat.coder.casestudyspring.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Position {
    @Id
    private String positionId;
    private String positionName;
    @OneToMany(mappedBy = "position")
    private Collection<Employee> employees;

    public Position() {
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }
}
