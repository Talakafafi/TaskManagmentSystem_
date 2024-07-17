/**
 * TaskProcessor is a class that uses multi-threading to simulate task execution.
 * Task Processing Definition: Each task processing simulation involves printing the task details, simulating a delay
 * , and then marking the task as completed.
 */
public class TaskProcessor  implements Runnable  {
    private static final Object lock = new Object();
    Task task ;
    public TaskProcessor(Task task){
        this.task=task;
    }

    @Override
    public void run() {

        try {

            task.setStatus("inprocessing");
            System.out.println("TaskID" + task.getId());
            System.out.println("title :" + task.getTitle());
            System.out.println("Description :" + task.getDescription());
            System.out.println("status :" + task.getStatus());
            System.out.println("priority :" + task.getPriority());


            Thread.sleep(7000);
            task.setStatus("completed");
            System.out.println("Task "+task.getId() +"is completed");
        }
        catch (InterruptedException ie) {
            System.out.println ("... ending synchronized block");
        }
    }

}
