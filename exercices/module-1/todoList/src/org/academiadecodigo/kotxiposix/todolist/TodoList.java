package org.academiadecodigo.kotxiposix.todolist;

import java.util.PriorityQueue;

public class TodoList {

    private PriorityQueue<TodoItem> todoList = new PriorityQueue<>();

    public boolean add(TodoItem todoItem){

        return todoList.add(todoItem);
    }

    public boolean offer(TodoItem todoItem){

        return todoList.offer(todoItem);
    }

    public boolean isEmpty(){

        return todoList.isEmpty();
    }

    public TodoItem poll(){

        return todoList.poll();
    }

}
