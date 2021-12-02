package hw5;

import hw5.entit.Design;
import hw5.entit.Developer;
import hw5.entit.Employee;
import hw5.entit.Manager;

public class EmployeeFactory {
    static String[] namesWomen = {"Niki", "Sera", "Anna", "Victoria"};
    static String[] namesMan = {"Nik", "Jack", "Bill", "Jon"};
    static String[] entityName = {
            Design.class.getName(), Developer.class.getName(), Manager.class.getName()
    };

    static int random(int min, int max) {
        int delta = max - min;

        double random = Math.random();
        return (int) (random * delta + min);
    }

    static String generateName(char gender){
        int random = random(0, 4);
        if (gender =='m') return namesMan[random];
        else return namesWomen[random];
    }

    static char generateGender(){
        int random = random(0, 2);
        if (random == 0) return 'm';
        else return 'w';
    }

    static int generateSalary(){
        return random(1000, 5000);
    }

    static int generateFindBugs(){
        return random(0, 10);
    }

    static int generateDefaultBugRate(){
        return random(100, 400);
    }

    static int generateAge(){
        return random(20, 50);
    }

    static int generateWorkedDays(){
        return random(0, 7);
    }

    static String generateEntity(){
        int randomValue = random(0, 3);
        return entityName[randomValue];
    }

    static Employee generateEmployee(int id) {
        char generateGender = generateGender();
        String generateName = generateName(generateGender);
        String entity = generateEntity();
        if (entity.equals(Design.class.getName())) {
            return new Design(id,  generateName, generateAge(), generateSalary(), generateGender, generateDefaultBugRate(), generateWorkedDays());
        } else if (entity.equals(Developer.class.getName())){
            return new Developer(id,  generateName, generateAge(), generateSalary(), generateGender, generateFindBugs());
        } else if (entity.equals(Manager.class.getName())){
            return new Manager(id,  generateName, generateAge(), generateSalary(), generateGender);
        }
        return null;
    }


    Employee[] generateEmployeesArray(int size){
        Employee[] employees = new Employee[size];
        for (int i = 0; i < size; i++) {
            employees[i] = generateEmployee(i + 1);
        }
        return employees;
    }
}
