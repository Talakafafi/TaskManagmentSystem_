import java.time.LocalDate;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Stream;

public class TaskManagment {
    static LinkedList<Task> tasks = new LinkedList<>();

    static void addTask(Task addedtask) {
        if (tasks.add(addedtask)) {
            System.out.println("Task added successfully.");
        } else {
            System.out.println("The operation failed, make sure to insert the right inputs.");
        }
    }

    static void removeTask(int taskId) {
        try {
        Task removedTask = tasks.stream().filter(task -> task.getId() == taskId).findFirst().orElseThrow();
        tasks.remove(removedTask);
            System.out.println("Task removed successfully.");
        }catch(NoSuchElementException o){
            System.out.println("the inserted Task ID does not exist");
        }
    }

    static void updatedTask(int taskId, String value, int updatedfeild) {
        try {
            Task updatedTask = tasks.stream().filter(task -> task.getId() == taskId).findFirst().orElseThrow();
            switch (updatedfeild) {
                case 1:
                    updatedTask.setTitle(value);
                    break;
                case 2:
                    updatedTask.setDescription(value);
                    break;
                case 3:
                    updatedTask.setStatus(value);
                    break;
                case 4:
                    updatedTask.setPriority(value);
                    break;
                case 5:
                    updatedTask.setdueDate(LocalDate.parse(value));
                    break;
            }
        }catch(NoSuchElementException o){
            System.out.println("the inserted Task ID does not exist");
        }
    }

    static void listOfTasks() {
        int number = 0;
        for (Task task : tasks) {
            System.out.println(task);
            number++;
        }
    }

    static void filter( String status, String priority, LocalDate date) {
        Stream<Task> streamFromList = tasks.stream();

        if (!status.isEmpty()) {
            streamFromList = streamFromList.filter(task -> task.getStatus().equals(status));
        }

        if (!priority.isEmpty() ) {
            streamFromList = streamFromList.filter(task -> task.getPriority().equals(priority));
        }

        if (!date.isEqual(LocalDate.parse("1111-11-11"))) {
            streamFromList = streamFromList.filter(task -> task.getdueDate().equals(date));
        }

        streamFromList.forEach(System.out::println);
    }
}


