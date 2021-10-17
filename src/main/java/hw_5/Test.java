package hw_5;

import hw_5.entit.Design;
import hw_5.entit.Employee;
import hw_5.entit.Manager;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee[] employees = employeeFactory.generateEmployeesArray(2);
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

//        edit
        System.out.println("edit");
        Employee employeeNew = new Manager(1, "Victor", 21, 3000, 'm');
        Employee employeeEdit = service.edit(employeeNew);
        service.employeePrint();
        System.out.println();

        //employeeByName
        System.out.println("employeeByName");
        Employee[] employeeByName = service.getByName("Victor");
        System.out.println(Arrays.toString(employeeByName));
        System.out.println();

//        sortByName
        System.out.println("sortByName");
        Employee[] sortByName = service.sortByName();
        System.out.println(Arrays.toString(sortByName));
        System.out.println();

        //sortByNameAndSalary
        System.out.println("sortByNameAndSalary");
        Employee[] sortByNameAndSalary = service.sortByNameAndSalary();
        System.out.println(Arrays.toString(sortByNameAndSalary));
        System.out.println();

        //remove
        System.out.println("remove");
        Employee remove = service.remove(1);
        service.employeePrint();
        System.out.println();

        //add
        System.out.println("Add");
        Design design = new Design(3, "Nik", 12, 2000, 'w', 100, 6);
        service.add(design);
        service.employeePrint();
        System.out.println();
    }
}
