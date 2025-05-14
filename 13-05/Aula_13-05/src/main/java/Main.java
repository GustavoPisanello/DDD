import domain.Task;
import repository.TaskRepository;

public class Main {
    public static void main(String[] args) {
        TaskRepository repo = new InMemoryTaskRepository();
        TaskService service = new TaskServiceImpl(repo);

        service.createTask("1", "Estudar arquitetura hexagonal");
        service.completeTask("1");

        Task task = repo.findById("1");
        System.out.println("Tarefa: " + task.getDescription() + " | concluída: " + task.isCompleted());
    }
}