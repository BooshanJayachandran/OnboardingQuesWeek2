package Models;

public class Employee {
    private String empId;
    private String name;
    private double salary;
    private Employee manager;
    private String department;


    public Employee(String empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    public Employee(String empId, String name, double salary, Employee manager, String department) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
        this.manager = manager;
        this.department = department;
    }

    public String getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Employee getManager() {
        return manager;
    }

    public String getDepartment() {
        return department != null ? department : "Unknown";
    }


    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", manager=" + (manager != null ? manager.getName() : "null") +
                ", department='" + getDepartment() + '\'' +
                '}';
    }


    /*@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Employee employee = (Employee) obj;

        return empId.equals(employee.empId);
    }

    @Override
    public int hashCode() {
        return empId.hashCode();
    }

     */

}
