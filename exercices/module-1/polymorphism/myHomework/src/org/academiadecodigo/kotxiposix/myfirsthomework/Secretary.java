package org.academiadecodigo.kotxiposix.myfirsthomework;

public class Secretary extends Employee implements Receivable{

    private double salary;

    public Secretary(EmployeeType employeeType, String name, int age, double salary){

        super(employeeType, name, age);
        this.salary = salary;
    }

    @Override
    public double calcSalary(int timeWorked) {

        return this.salary * timeWorked;
    }

    @Override
    public String toString() {

        return super.toString() + " : " + calcSalary(21 * 6);
    }
}
