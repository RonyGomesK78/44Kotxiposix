package org.academiadecodigo.kotxiposix.myfirsthomework;

public class Teacher extends Employee implements Receivable{

    private double salary;

    public Teacher(EmployeeType employeeType, String name, int age, double salary){

        super(employeeType, name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public double calcSalary(int timeWorked) {

        return salary * timeWorked;
    }

    @Override
    public String toString() {

        return super.toString() + " : " + calcSalary(21 * 8);
    }


}
