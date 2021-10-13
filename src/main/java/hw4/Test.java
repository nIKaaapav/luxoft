package hw4;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee[] employees = employeeFactory.generateEmployees(2);
        EmployeeService service = new EmployeeService(employees);

        //employeePrint
        service.employeePrint();
        System.out.println();

        //getById
        Employee employeeById = service.getById(1);
        System.out.println(employeeById);
        System.out.println();

        // calculateSalaryAndBonus
        int calculateSalaryAndBonus = service.calculateSalaryAndBonus();
        System.out.println(calculateSalaryAndBonus);
        System.out.println();

        //edit
        Employee employeeNew = new Employee(1, "Victor", 21, 3000, 'm', 5, 165);
        Employee employeeEdit = service.edit(employeeNew);
        service.employeePrint();
        System.out.println();

        //employeeByName
        Employee[] employeeByName = service.getByName("Victor");
        System.out.println(Arrays.toString(employeeByName));
        System.out.println();

        Employee[] sortByName = service.sortByName();
        System.out.println(Arrays.toString(sortByName));
        System.out.println();

        //sortByNameAndSalary
        Employee[] sortByNameAndSalary = service.sortByNameAndSalary();
        System.out.println(Arrays.toString(sortByNameAndSalary));
        System.out.println();

        //remove
        Employee remove = service.remove(1);
        service.employeePrint();
        System.out.println();
    }
}
