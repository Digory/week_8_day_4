package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "managers")
public class Manager extends Employee {
    private List<Administrator> administrators;
    private int budget;
    private Department department;

    public Manager(){}

    public Manager(String name, String nationalInsuranceNumber, int salary, int budget) {
        super(name, nationalInsuranceNumber, salary);
        administrators = new ArrayList<Administrator>();
        this.budget = budget;
    }

    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
    public List<Administrator> getAdministrators() {
        return administrators;
    }

    public void setAdministrators(List<Administrator> administrators) {
        this.administrators = administrators;
    }

    public void addAdministrator(Administrator administrator){
        administrators.add(administrator);
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    @OneToOne(mappedBy = "manager", fetch = FetchType.LAZY)
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
