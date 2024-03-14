import Models.Department;
import Models.Employee;
import Models.Company;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeInitializer {

    public static List<Employee> initializeEmployees(Employee manager1, Employee manager2) {
        Employee emp1 = new Employee("empId1", "Booshan", 60000, manager1, "IT");
        Employee emp2 = new Employee("empId2", "Kousik", 70000, manager2, "Product");
        Employee emp3 = new Employee("empId3", "Kishore", 80000, manager1, "Marketing");
        Employee emp4 = new Employee("empId4", "Kousik", 90000, manager2, "Product");
        Employee emp5 = new Employee("empId5", "Muthu", 100000, manager1, "IT");

        return Arrays.asList(manager1, manager2, emp1, emp2, emp3, emp4, emp5);
    }

    public static Employee initializeManager1() {
        return new Employee("empId101", "Harish", 110000, null, "IT");
    }

    public static Employee initializeManager2() {
        return new Employee("empId102", "Kumar", 120000, null, "Marketing");
    }

    public static Company initializeCompany() {
        Employee manager1 = initializeManager1();
        Employee manager2 = initializeManager2();

        List<Employee> employees = initializeEmployees(manager1, manager2);

        Department IT = new Department("IT");
        IT.addEmployee(employees.get(0));
        IT.addEmployee(employees.get(2));
        IT.addEmployee(employees.get(4));

        Department product = new Department("Product");
        product.addEmployee(employees.get(3));
        product.addEmployee(manager2);

        Department marketing = new Department("Marketing");
        marketing.addEmployee(employees.get(1));
        marketing.addEmployee(employees.get(5));

        Company company = new Company();
        company.addDepartment(IT);
        company.addDepartment(product);
        company.addDepartment(marketing);

        return company;
    }
}
