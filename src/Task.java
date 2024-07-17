import java.time.LocalDate;
/**
 * The Task class contains the task information such as  ID, title, description, status, priority,and due date.
 * It implements the `Comparable<Task>` interface to allow the comparison between tasks.
 */
public class Task implements Comparable<Task> {

   private int id;
   private String title;
   private String description;
   private String status;
   private String priority;
   private LocalDate dueDate;
   static int taskIdGenerator = 0;

   /**
    * Constructs a new `Task` with the specified details.
    * The task's ID is auto-generated
    *
    * @param title       the title of the task
    * @param description a description of the task
    * @param status      the status of the task
    * @param priority    the priority  of the task
    * @param dueDate     the due date of the task
    */
   public Task(String title, String description, String status, String priority, LocalDate dueDate) {
      this.id = taskIdGenerator++;
      this.title = title;
      this.description = description;
      this.status = status;
      this.priority = priority;
      this.dueDate = dueDate;
   }

   /**
    * Returns the ID of this task.
    *
    * @return the ID of the task
    */
   public int getId() {
      return id;
   }

   /**
    * Returns the title of this task.
    *
    * @return the title of the task
    */
   public String getTitle() {
      return title;
   }

   /**
    * Sets the title of this task.
    *
    * @param title the new title to be assigned to this task
    */
   public void setTitle(String title) {
      this.title = title;
   }

   /**
    * Returns the description of this task.
    *
    * @return the description of the task
    */
   public String getDescription() {
      return description;
   }

   /**
    * Sets the description of this task.
    *
    * @param description the new description to be assigned to this task
    */
   public void setDescription(String description) {
      this.description = description;
   }

   /**
    * Returns the status of this task.
    *
    * @return the status of the task
    */
   public String getStatus() {
      return status;
   }

   /**
    * Sets the status of this task.
    *
    * @param status the new status to be assigned to this task
    */
   public void setStatus(String status) {
      this.status = status;
   }

   /**
    * Returns the priority level of this task.
    *
    * @return the priority level of the task
    */
   public String getPriority() {
      return priority;
   }

   /**
    * Sets the priority level of this task.
    *
    * @param priority the new priority level to be assigned to this task
    */
   public void setPriority(String priority) {
      this.priority = priority;
   }

   /**
    * Returns the due date of this task.
    *
    * @return the due date of the task
    */
   public LocalDate getDueDate() {
      return dueDate;
   }

   /**
    * Sets the due date of this task.
    *
    * @param dueDate the new due date to be assigned to this task
    */
   public void setDueDate(LocalDate dueDate) {
      this.dueDate = dueDate;
   }

   /**
    * override the toString() method to fetch specific details about the object
    *
    * @return a string representation of the task
    */
   @Override
   public String toString() {
      return "Task { Id : " + id + ", Title : " + title + ", Description : " + description +
              ", Status : " + status + ", Priority : " + priority + ", DueDate : " + dueDate + " }";
   }

   /**
    * override the compareTo() method Compares this task to another task based on their priority.
    *
    * @param other the other task to compare to
    * @return an  integer to represent the result of comparison, zero if they equal , positive if less than,
    *        negative if greater than
    */
   @Override
   public int compareTo(Task other) {
      return this.priority.compareTo(other.priority);
   }
}
