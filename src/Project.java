import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Stream;
/**
 * The Project class represents a  group of tasks that  related to a specific project
 * It extends the TaskManagement and inherits methods like adding, removing, updating,
 * individualTask class has additional functionality to Analyze the Project.
 * Tasks are stored as collection of a PriorityQueue

 */
public class Project extends TaskManagement  {

     public Project(){
         super(new PriorityQueue<>());
     }
/**
 * Analyzes and prints statistics about the tasks in the project.
 * The analysis includes the total number of tasks, the count of tasks by their status,
 * and the count of tasks by their priority level.
 * **/
     public void ProjectAnalyzing(){
         System.out.println("Total Number of Tasks :"+ tasks.size());
         System.out.println("Number of assigned tasks " +tasks.stream().filter(x -> x.getStatus().equals("assigned")).count());
         System.out.println("Number of not completed tasks "   +tasks.stream().filter(x -> x.getStatus().equals("inprogress")).count());
         System.out.println("Number of completed tasks " +tasks.stream().filter(x -> x.getStatus().equals("completed")).count());
         System.out.println("Number of tasks with Priority 'high': "+tasks.stream().filter(x -> x.getPriority().equals("high")).count());
         System.out.println("Number of tasks with Priority 'intermediate': " + tasks.stream().filter(x -> x.getPriority().equals("intermediate")).count());
         System.out.println("Number of tasks with Priority 'low': " +tasks.stream().filter(x -> x.getPriority().equals("low")).count());



         }

}
