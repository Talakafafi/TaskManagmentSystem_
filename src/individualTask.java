import java.time.LocalDate;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
/**
 * The individualTask class represents the tasks that not related to specific project
 * It extends the TaskManagement and inherits methods like adding, removing, updating,
 * individualTask class has additional functionality to sort tasks by their status, priority, or due date.
 * Tasks are stored as collection of an ArrayList

 */
public class individualTask extends TaskManagement {
    static ArrayList<Task> tasks = new ArrayList<>();

    public individualTask() {
        super(tasks);
    }

    /**
     * sort tasks by their status, priority, or due date.
     *
     * @param sortingCriteria the datafile to sort by
     */
    public  void sort(int sortingCriteria){
        Stream<Task> streamFromList = tasks.stream();
        switch (sortingCriteria){
            case 1://sort by status
                streamFromList.sorted((x,y)->x.getStatus().compareTo(y.getStatus())).forEach(System.out::println);
                break;
            case 2://sort by priority
                streamFromList.sorted((x,y)->x.getPriority().compareTo(y.getPriority())).forEach(System.out::println);
                break;
            case 3://sort by date
                streamFromList.sorted((x,y)->x.getDueDate().compareTo(y.getDueDate())).forEach(System.out::println);
                break;
        }
    }
}

