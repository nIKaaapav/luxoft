package hw4;

public class EmployeeService {
    Employee[] employeeBD;

    public EmployeeService(Employee[] employeeBD) {
        this.employeeBD = employeeBD;
    }

    void employeePrint(){
        for (Employee employee: employeeBD) {
            if (employee != null) {
                employee.print();
                System.out.println();
            }
        }
    }

    int calculateSalaryAndBonus(){
        int moneyForSalaryAndBonus = 0;
        for (Employee employee: employeeBD) {
            moneyForSalaryAndBonus += employee.salary;
            moneyForSalaryAndBonus += employee.defaultBugRate * employee.findBugs;
        }
        return moneyForSalaryAndBonus;
    }

    Employee getById(long id){
        for (Employee employee: employeeBD) {
           if (employee.id == id) return employee;
        }
        return null;
    }

    Employee[] getByName(String name){
        Employee[] employeesArrayByName  = new Employee[employeeBD.length];
        int countEmployeesByName = 0;
        for (Employee employee: employeeBD) {
           if (employee.name.equals(name)) employeesArrayByName[countEmployeesByName++] = employee;
        }
        Employee[] employeesArrayByNameResult  = new Employee[countEmployeesByName];

        for (int i = 0; i < countEmployeesByName; i++) {
            employeesArrayByNameResult[i] = employeesArrayByName[i];
        }

        return employeesArrayByNameResult;
    }

    Employee[] sortByName() {
        Employee[] employees = employeeBD.clone();

        for (int i = 0; i < employees.length; i++) {
            for (int j = 0; j < employees.length; j++) {
                Employee template = employees[i];
                System.out.printf("name template = %s \n", template.name);
                System.out.printf("name employees[j] = %s \n", employees[j].name);
                System.out.println("compareTo" + template.name.compareTo(employees[j].name));
                if (template.name.compareTo(employees[j].name) < 0){
                    employees[i] = employees[j];
                    employees[j] = template;
                }
            }
        }

        return employees;
    }

    Employee[] sortByNameAndSalary() {
        Employee[] employees = employeeBD.clone();

        for (int i = 0; i < employees.length; i++) {
            for (int j = 0; j < employees.length; j++) {
                Employee template = employees[i];

                if (template.name.equals(employees[j].name)){
                    if (template.salary > employees[j].salary){
                        employees[i] = employees[j];
                        employees[j] = template;
                        break;
                    }
                }

                if (template.name.compareTo(employees[j].name) < 0){
                    employees[i] = employees[j];
                    employees[j] = template;
                }
            }
        }

        return employees;
    }

    Employee edit(Employee employeeNew) {
        if (employeeNew.id > employeeBD.length) return null;

        Employee employeeCurrent = getById(employeeNew.id);
        Employee employeeUpdated = new Employee(employeeNew.id, employeeNew.name, employeeNew.age, employeeNew.salary, employeeNew.gender, employeeNew.findBugs, employeeNew.defaultBugRate);

        employeeBD[(int) employeeNew.id - 1] = employeeUpdated;
        return employeeCurrent;
    }


    Employee remove(long id){
        Employee employee = getById(id);
        Employee[] newEmployeeBD = new Employee[this.employeeBD.length - 1];
        int countNewEmployeeBD = 0;

        for (int i = 0; i < this.employeeBD.length; i++) {
            if (this.employeeBD[i].id != id) {
                newEmployeeBD[countNewEmployeeBD++] = this.employeeBD[i];
            }
        }

        this.employeeBD = newEmployeeBD;

        return employee;
    }


}
