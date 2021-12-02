package hw4;

public class EmployeeFactory {
    static String[] namesWomen = {"Niki", "Sera", "Anna", "Victoria"};
    static String[] namesMan = {"Nik", "Jack", "Bill", "Jon"};

    static int random(int min, int max) {
        int delta = max - min;

        double random = Math.random();
        return (int) (random * delta + min);
    }

    static String generateName(char gender){
        int random = random(0, 4);
        System.out.println(random);
        if (gender =='m') return namesMan[random];
        else return namesWomen[random];
    }

    static char generateGender(){
        int random = random(0, 2);
        System.out.println(random);
        if (random == 0) return 'm';
        else return 'w';
    }

    static int generateSalary(){
        int random = random(1000, 5000);
        return random;
    }

    static int generateFindBugs(){
        int random = random(0, 10);
        return random;
    }

    static int generateDefaultBugRate(){
        int random = random(100, 400);
        return random;
    }

    static int generateAge(){
        int random = random(20, 50);
        return random;
    }


    Employee[] generateEmployees(int size){
        Employee[] employees = new Employee[size];
        for (int i = 0; i < size; i++) {
            char gender = generateGender();
            String name = generateName(gender);
            int salary = generateSalary();
            int findBugs = generateFindBugs();
            int defaultBugRate = generateDefaultBugRate();
            int age = generateAge();
            Employee employee = new Employee((long) i + 1, name, age, salary, gender, findBugs, defaultBugRate);
            employees[i] = employee;
        }
        return employees;
    }
}
