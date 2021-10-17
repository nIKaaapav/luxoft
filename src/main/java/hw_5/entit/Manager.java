package hw_5.entit;

public class Manager extends Employee {
    public Manager(long id, String name, int age, int salary, char gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
    }

    @Override
   public int fullSalaryOnMonth(){
        return this.salary;
    }

    @Override
    public String print() {
        return getClass().getName() + ": \n" +
                "id:" + this.id + " ; " +
                "name:" + this.name + "; " +
                "age:" + this.age +  " ; " +
                "salary:" + this.salary +  " ; " +
                "gender:" + this.gender + " ; " +
                "gender:" + this.gender;

    }

    @Override
    public String toString() {
        return "Manager{" +
                " id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender=" + gender +
                '}';
    }
}
