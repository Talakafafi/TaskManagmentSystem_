import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * The TaskManagement class contains all the shared operation can be done on the Task object like add , update,and remove
 * *It is an abstract method , implementing the shared method between class to be extended and used
 * Tasks are stored as collection of an ArrayList

 */
public abstract class TaskManagement {
    protected Collection<Task> tasks;

    /**
     * Constructs an instance with the specified collection of tasks.
     * @param tasks the collection of tasks to be managed
     */
    protected TaskManagement(Collection<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Adds a new task to the collection.
     * @param addedtask the task to be added
     */
    public  void addTask(Task addedtask) {
        if (tasks.add(addedtask)) {
            System.out.println("Task added successfully.");
        } else {
            System.out.println("The operation failed, make sure to insert the right inputs.");
        }
    }

    /**
     * removes task from the collection using ID.
     * @param taskId the task to be removed
     */
    public  void removeTask(int taskId) {
        try {
        Task removedTask = tasks.stream().filter(task -> task.getId() == taskId).findFirst().orElseThrow();
        tasks.remove(removedTask);
            System.out.println("Task removed successfully.");
        }catch(NoSuchElementException o){
            System.out.println("the inserted Task ID does not exist");
        }
    }

    /**
     * updates an existing task .
     * user will choose one of the datafile and pass an associated number to that datafile with the new value
     * @param taskId the task to be updated
     * @param value the new value
     * @param updatedField the determined datafile
     */
    public  void updatedTask(int taskId, String value, int updatedField) {
        try {
            Task updatedTask = tasks.stream().filter(task -> task.getId() == taskId).findFirst().orElseThrow();
            switch (updatedField) {
                case 1: //update the title
                    updatedTask.setTitle(value);
                    break;
                case 2: //update the Description
                    updatedTask.setDescription(value);
                    break;
                case 3: //update the Status
                    updatedTask.setStatus(value);
                    break;
                case 4: //update the Priority
                    updatedTask.setPriority(value);
                    break;
                case 5: //update the DueDate
                    updatedTask.setDueDate(LocalDate.parse(value));
                    break;
            }
        }catch(NoSuchElementException o){
            System.out.println("the inserted Task ID does not exist");
        }
    }

    /**
     * prints the toString() method of each task
     * the toString() contains the details of the task
     *
     * */
    public  void listOfTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    /**
     * filters the tasks using the passed data
     * filters the tasks depending on the status , priority and data
     * all the passed parameters are nullable
     * @param status the status of the tasks
     * @param priority the priority level of the tasks
     * @param date the due date of the tasks
     */
    public  void filter( String status, String priority, LocalDate date) {
        Stream<Task> streamFromList = tasks.stream();

        if (!status.isEmpty()) {
            streamFromList = streamFromList.filter(task -> task.getStatus().equals(status));
        }

        if (!priority.isEmpty() ) {
            streamFromList = streamFromList.filter(task -> task.getPriority().equals(priority));
        }

        if (!date.isEqual(LocalDate.parse("1111-11-11"))) {
            streamFromList = streamFromList.filter(task -> task.getDueDate().equals(date));
        }

        streamFromList.forEach(System.out::println);
    }
    public List<Task> listTasks() {
        return tasks.stream().collect(Collectors.toList());
    }

}


