import domain.Task;
import repository.TaskRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryTaskRepository implements TaskRepository {
    private final Map<String, Task> storage = new HashMap<>();

    public void save(Task task){
        storage.put(task.getId(), task);
    }

    public Task findById(String id){
        return storage.get(id);
    }
}
