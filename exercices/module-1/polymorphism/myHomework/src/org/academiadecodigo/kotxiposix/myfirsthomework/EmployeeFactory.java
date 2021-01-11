package org.academiadecodigo.kotxiposix.myfirsthomework;

public abstract class EmployeeFactory {

    public static Employee makeEmployee(EmployeeType employeeType, String name, int age){

        switch (employeeType){

            case SECRETARY:
                return new Secretary(employeeType, name, age, 2000);

            case TEACHER:
                return new Teacher(employeeType, name, age, 5000);

            default:
                return new Student(employeeType, name, age);
        }
    }
}
