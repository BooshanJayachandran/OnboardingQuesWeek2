package Models;
import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Department> departments;

    public Company() {
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        this.departments.add(department);
    }

    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = new ArrayList<>();
        for (Department department : departments) {
            allEmployees.addAll(department.getEmployees());
        }
        return allEmployees;
    }

    @Override
    public String toString() {
        return "Company{" +
                "departments=" + departments +
                '}';
    }

}