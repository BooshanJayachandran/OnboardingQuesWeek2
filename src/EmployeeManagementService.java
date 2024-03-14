import Models.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeManagementService {

    public Employee findMostSalariedEmployee(List<Employee> employees) {
        return employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
    }

    public Map<String, List<Employee>> groupEmployeesByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.toList()
                ));
    }

    public Map<String, List<String>> findEmployeesWithSameName(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getName,
                        Collectors.mapping(Employee::getEmpId, Collectors.toList())
                ))
                .entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public List<Employee> findReportees(String managerName, List<Employee> employees) {
        return employees.stream()
                .filter(employee -> {
                    Employee manager = employee.getManager();
                    return manager != null && managerName.equalsIgnoreCase(manager.getName());
                })
                .collect(Collectors.toList());
    }
}
