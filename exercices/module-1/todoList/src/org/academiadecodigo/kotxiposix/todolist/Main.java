package org.academiadecodigo.kotxiposix.todolist;


public class Main{

    public static void main(String[] args) {

        TodoList todoList = new TodoList();

        todoList.add(new TodoItem("study", Importance.HIGH, 5));
        todoList.add(new TodoItem("beer time", Importance.LOW, 2));
        todoList.add(new TodoItem("sleep", Importance.MEDIUM, 1));
        todoList.add(new TodoItem("respect", Importance.HIGH, 3));
        todoList.add(new TodoItem("see girl", Importance.LOW, 1));
        todoList.add(new TodoItem("go To Palmarejo", Importance.HIGH, 0));
        todoList.offer(new TodoItem("stay here", Importance.LOW, 1));
        todoList.offer(new TodoItem("listen music", Importance.MEDIUM, 10));

        while (!todoList.isEmpty()){

            System.out.println(todoList.poll());
        }
    }

}
