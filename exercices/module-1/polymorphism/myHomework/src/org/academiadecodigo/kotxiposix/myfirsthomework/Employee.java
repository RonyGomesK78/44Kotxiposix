package org.academiadecodigo.kotxiposix.myfirsthomework;

public abstract class Employee {

    private String name;
    private int age;
    private EmployeeType employeeType;

    public Employee(EmployeeType employeeType, String name, int age){

        this.employeeType = employeeType;
        this.name = name;
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {

        this.age = age;
    }

    public EmployeeType getEmployeeType() {

        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {

        this.employeeType = employeeType;
    }

    @Override
    public String toString() {

        return getClass().getSimpleName() + " : " + getName() + " : " + getAge();
    }
}
