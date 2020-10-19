package nhat.coder.casestudyspring.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
public class User {
        @Id
        private String userName;
        private String userPassword;

        @OneToMany(mappedBy = "user")
        private Set<Employee> employeeSet;

        @ManyToMany(cascade = {CascadeType.ALL})
        @JoinTable(name = "userRole",joinColumns = @JoinColumn(name = "userName"), inverseJoinColumns = @JoinColumn(name = "roleId"))
        private Set<Role> roles;

        public User() {
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserPassword() {
            return userPassword;
        }

        public void setUserPassword(String userPassword) {
            this.userPassword = userPassword;
        }

        public Set<Employee> getEmployeeSet() {
            return employeeSet;
        }

        public void setEmployeeSet(Set<Employee> employeeSet) {
            this.employeeSet = employeeSet;
        }

        public Set<Role> getRoles() {
            return roles;
        }

        public void setRoles(Set<Role> roles) {
            this.roles = roles;
        }

//    @Id
//    private String userName;
//    private String password;
//
//    @OneToMany(mappedBy = "user")
//    private Collection<Employee> employees;
//
//    @ManyToMany(cascade = {CascadeType.ALL})
//    @JoinTable(name = "user_role" ,joinColumns = @JoinColumn(name = "userName",updatable = true),inverseJoinColumns = @JoinColumn(name ="roleId",updatable = true))
//    private Collection<Role> roles;
//
//    public User() {
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Collection<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(Collection<Employee> employees) {
//        this.employees = employees;
//    }
//
//    public Collection<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Collection<Role> roles) {
//        this.roles = roles;
//    }
}
