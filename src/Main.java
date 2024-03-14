import Models.Company;
import Models.Employee;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Company company = EmployeeInitializer.initializeCompany();

        EmployeeManagementService service = new EmployeeManagementService();

        Employee mostSalariedEmployee = service.findMostSalariedEmployee(company.getAllEmployees());
        System.out.println("Most Salaried Employee: " + mostSalariedEmployee);
        System.out.println();

        Map<String, List<Employee>> groupedEmployees = service.groupEmployeesByDepartment(company.getAllEmployees());
        System.out.println("Grouped Employees: ");
        groupedEmployees.forEach((department, employeeList) -> {
            System.out.println("Department: " + department);
            employeeList.forEach(System.out::println);
            System.out.println();
        });

        Map<String, List<String>> employeesWithSameName = service.findEmployeesWithSameName(company.getAllEmployees());
        System.out.println("Employees with the Same Name: " + employeesWithSameName);
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the manager's name (Harish or Kumar): ");
        String managerName = scanner.nextLine();

        EmployeeInitializer employeeInitializer = new EmployeeInitializer();
        Employee manager1 = employeeInitializer.initializeManager1();
        Employee manager2 = employeeInitializer.initializeManager2();

        List<Employee> employees = employeeInitializer.initializeEmployees(manager1, manager2);

        List<Employee> managers = Arrays.asList(manager1, manager2);
        Optional<Employee> selectedManager = managers.stream()
                .filter(manager -> managerName.equalsIgnoreCase(manager.getName()))
                .findFirst();

        if (selectedManager.isPresent()) {
            List<Employee> reportees = service.findReportees(selectedManager.get().getName(), employees);
            System.out.println("Reportees for Manager " + selectedManager.get().getName() + ": ");
            reportees.forEach(System.out::println);
        } else {
            System.out.println("Invalid manager name. Exiting program.");
        }
    }
}
