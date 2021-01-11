package org.academiadecodigo.kotxiposix.myfirsthomework;

public class Main {

    public static void main(String[] args) {

        Employee student = EmployeeFactory.makeEmployee(EmployeeType.STUDENT, "Maria Rosa", 22);

        Employee secretary = EmployeeFactory.makeEmployee(EmployeeType.SECRETARY, "Luisa Monteiro", 45);

        Employee teacher = EmployeeFactory.makeEmployee(EmployeeType.TEACHER, "Karen Hellen", 33);

        System.out.println(student.toString());
        System.out.println(secretary.toString());
        System.out.println(teacher.toString());
    }
}
