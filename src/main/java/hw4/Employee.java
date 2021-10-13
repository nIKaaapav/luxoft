package hw4;

public class Employee {
     long id;
     String name;
     int age;
     int salary;
     char gender;
     int findBugs;
     int defaultBugRate;

    public Employee(long id, String name, int age, int salary, char gender, int findBugs, int defaultBugRate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
        this.findBugs = findBugs;
        this.defaultBugRate = defaultBugRate;
    }

    public Employee() {}

    public void print(){
        System.out.println("Employee:");
        System.out.print("id: " + this.id + ", ");
        System.out.print("name: " + this.name + ", ");
        System.out.print("age: " + this.age + ", ");
        System.out.print("salary: " + this.salary + ", ");
        System.out.print("gender: " + this.gender + ", ");
        System.out.print("findBugs: " + this.findBugs + ", ");
        System.out.print("defaultBugRate: " + this.defaultBugRate + ".");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender=" + gender +
                ", findBugs=" + findBugs +
                ", defaultBugRate=" + defaultBugRate +
                '}';
    }
}
