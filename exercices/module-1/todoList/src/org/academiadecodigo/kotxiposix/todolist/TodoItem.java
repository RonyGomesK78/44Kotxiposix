package org.academiadecodigo.kotxiposix.todolist;


import java.util.PriorityQueue;

public class TodoItem implements Comparable<TodoItem>{

    private String itemDescription;
    private Importance importance;
    private int priority;

    public TodoItem(String itemDescription, Importance importance, int priority){

        this.itemDescription = itemDescription;
        this.importance = importance;
        this.priority = priority;
    }

    public String getItemDescription() {

        return itemDescription;
    }

    public Importance getImportance() {

        return importance;
    }

    @Override
    public int compareTo(TodoItem o) {

       /* if (importance.compareTo(o.importance) == 0){

            if (priority > o.priority){

                return 1;
            }

            return -1;
        }*/
        return importance.compareTo(o.importance) == 0 ? Integer.compare(this.priority, o.priority) : importance.compareTo(o.importance);
        //return importance.compareTo(o.importance);
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "itemDescription='" + itemDescription + '\'' +
                ", importance=" + importance +
                ", priority=" + priority +
                '}';
    }
}
