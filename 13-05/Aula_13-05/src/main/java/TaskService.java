public interface TaskService {
    void createTask(String id, String description);
    void completeTask(String id);
}
