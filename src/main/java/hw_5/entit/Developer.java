package hw_5.entit;

public class Developer extends Employee {
    final int fixedBug;


    public Developer(long id, String name, int age, int salary, char gender, int fixedBug) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
        this.fixedBug = fixedBug;
    }

    @Override
    public int fullSalaryOnMonth() {
        return (int) (this.salary + this.fixedBug * this.salary * 0.2);
    }


    @Override
    public String print() {
        return getClass().getName() + ": \n" +
                "id:" + this.id + " ; " +
                "name:" + this.name + "; " +
                "age:" + this.age +  " ; " +
                "salary:" + this.salary +  " ; " +
                "gender:" + this.gender + " ; " +
                "gender:" + this.gender + " ; " +
                "fixedBug:" + this.fixedBug;

    }

    @Override
    public String toString() {
        return "Developer{" +
                "fixedBug=" + fixedBug +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender=" + gender +
                '}';
    }
}
