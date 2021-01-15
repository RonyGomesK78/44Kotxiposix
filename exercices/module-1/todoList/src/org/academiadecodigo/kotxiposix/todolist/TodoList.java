package org.academiadecodigo.kotxiposix.todolist;

import java.util.PriorityQueue;

public class TodoList {

    private PriorityQueue<TodoItem> todoList = new PriorityQueue<>();

    public boolean add(TodoItem todoItem){

        return todoList.add(todoItem);
    }

    public PriorityQueue<TodoItem> getTodoList(){

        return this.todoList;
    }


}
