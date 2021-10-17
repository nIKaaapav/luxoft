package hw_5.entit;

public abstract class Employee {
    public long id;
    public String name;
    public int age;
    public int salary;
    public char gender;

    public abstract int  fullSalaryOnMonth();

    public abstract String print();
}
