package hw_5.entit;

public class Design extends Employee {
    int rate;
    int workedDays;

    public Design(long id, String name, int age, int salary, char gender, int rate, int workedDays) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
        this.rate = rate;
        this.workedDays = workedDays;
    }

    @Override
    public int fullSalaryOnMonth(){
        return this.salary + this.rate * this.workedDays;
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
                "rate:" + this.rate +  " ; " +
                "workedDays:" + this.workedDays;

    }

    @Override
    public String toString() {
        return "Design{" +
                "rate=" + rate +
                ", workedDays=" + workedDays +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender=" + gender +
                '}';
    }
}
