package nhat.coder.casestudyspring.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Division {
    @Id
    private String divisionId;
    private String divisionName;

    @OneToMany(mappedBy = "division")
    private Collection<Employee> employees;

    public Division() {
    }

    public String getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(String divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }
}
