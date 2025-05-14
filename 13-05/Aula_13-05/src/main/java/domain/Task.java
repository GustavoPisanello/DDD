package domain;

public class Task {
    private String id;
    private String description;
    private boolean completed;

    public Task(String id, String description){
        this.id = id;
        this.description = description;
        this.completed = false;
    }

    public void markAsCompleted(){
        this.completed = true;
    }

    public String getId(){
        return id;
    }

    public String getDescription(){
        return description;
    }

    public String isCompleted(){
        return completed == true ? "completo" : "incompleto";
    }
}
