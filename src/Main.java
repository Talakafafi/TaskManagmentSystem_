import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        individualTask TaskManagement = new individualTask();
        TaskManagement.addTask(new Task("Task 1", "Description for Task 1", "assigned", "high", LocalDate.parse("2024-07-20")));
        TaskManagement.addTask(new Task("Task 2", "Description for Task 2", "assigned", "intermediate", LocalDate.parse("2024-08-15")));
        TaskManagement.addTask(new Task("Task 3", "Description for Task 3", "assigned", "low", LocalDate.parse("2024-09-10")));
        TaskManagement.addTask(new Task("Task 4", "Description for Task 4", "assigned", "high", LocalDate.parse("2024-10-05")));
        TaskManagement.addTask(new Task("Task 5", "Description for Task 5", "assigned", "intermediate", LocalDate.parse("2024-11-01")));
        TaskManagement.addTask(new Task("Task 6", "Description for Task 6", "assigned", "low", LocalDate.parse("2024-11-01")));
        TaskManagement.addTask(new Task("Task 7", "Description for Task 7", "assigned", "high", LocalDate.parse("2024-11-01")));
        TaskManagement.addTask(new Task("Task 8", "Description for Task 8", "assigned", "intermediate", LocalDate.parse("2024-11-04")));
        TaskManagement.addTask(new Task("Task 9", "Description for Task 9", "assigned", "low", LocalDate.parse("2025-11-01")));
        TaskManagement.addTask(new Task("Task 10", "Description for Task 10", "assigned", "high", LocalDate.parse("2024-10-01")));
        TaskManagement.addTask(new Task("Task 11", "Description for Task 1", "assigned", "high", LocalDate.parse("2024-07-20")));
        TaskManagement.addTask(new Task("Task 12", "Description for Task 2", "assigned", "intermediate", LocalDate.parse("2024-08-15")));
        TaskManagement.addTask(new Task("Task 13", "Description for Task 3", "assigned", "low", LocalDate.parse("2024-09-10")));
        Project project = new Project() ;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String console;
        while(true){
        System.out.println("menu : ");
        System.out.println("1. Users");
        System.out.println("2. Tasks");
        System.out.println("3. Projects");
        System.out.println("4. Task process");
        try {
            console = reader.readLine();
            int options = Integer.parseInt (console);

            switch (options) {
                case 1: {
                    boolean flag = true;
                    while(flag){
                    System.out.println("***** User operations ****** ");
                    System.out.println("1. Add user    ");
                    System.out.println("2. Remove user ");
                    System.out.println("3. Update user ");
                    System.out.println("4. show users");
                    System.out.println("5. Exit");
                    console = reader.readLine();
                    int usersOptions = Integer.parseInt(console);

                    switch (usersOptions) {
                        case 1: {
                            System.out.println("Insert the name ");
                            String name = reader.readLine();
                            while (!name.matches("^[A-Z][a-z].*")){
                                System.out.println("invaild name try again ");
                                name = reader.readLine();
                            }
                            System.out.println("Insert the email ");
                            String email = reader.readLine();
                            while (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                                System.out.println("invaild email try again ");
                                email = reader.readLine();

                            }
                            User newuser = new User(name, email);
                            UserManagement.addUser(newuser);
                            break;
                        }
                        case 2:{
                            System.out.println("Insert the user ID you want to remove");
                            int taskId = Integer.parseInt(reader.readLine());
                            UserManagement.removeUser(taskId);
                            break;
                        }
                        case 3: {
                            System.out.println("Insert the user ID you want to update");
                            int taskId = Integer.parseInt(reader.readLine());
                            System.out.println("If you want to update the name , Insert the new value or press enter ");
                            String name = reader.readLine();
                            System.out.println("If you want to update the email , Insert the new value or press enter ");
                            String email = reader.readLine();
                            UserManagement.updateUser(taskId, email, name);
                            break;
                        }
                        case 4:{
                            UserManagement.usersDetails();
                                break;

                        }
                        case 5:{
                            flag =false;
                            break;
                        }



                    }}
                    break;
                }
                case 2: {
                    boolean flag =true;
                    while(flag){
                    System.out.println("***** Task operations ****** ");
                    System.out.println("1. Add task    ");
                    System.out.println("2. Remove task ");
                    System.out.println("3. Update task ");
                    System.out.println("4. list tasks");
                    System.out.println("5. filter tasks");
                    System.out.println("6. Sort");
                    System.out.println("7. Exit");
                    console = reader.readLine();
                    int tasksOptions = Integer.parseInt(console);
                       switch(tasksOptions) {
                           case 1: {
                               System.out.println("Insert the title ");
                               String title = reader.readLine();
                               System.out.println("Insert the description ");
                               String description = reader.readLine();
                               System.out.println("Insert the status (assigned , completed ,  inprocessing)");
                               String status = reader.readLine();
                               System.out.println("Insert the priority (high ,  intermediate , low)");
                               String priority = reader.readLine();
                               System.out.println("Insert the dueDate (0000-00-00)");
                               LocalDate dueDate = LocalDate.parse(reader.readLine());

                               TaskManagement.addTask(new Task(title, description, status, priority,dueDate));
                               break;
                           }
                           case 2:{
                               System.out.println("Insert the task ID you want to remove");
                               int taskId = Integer.parseInt(reader.readLine());
                               TaskManagement.removeTask(taskId);
                               break;
                           }
                           case 3:{
                               System.out.println("Insert the task ID you want to update");
                               int taskId = Integer.parseInt(reader.readLine());
                               System.out.println("Which value you want to change ?  ");
                               System.out.println("1.title  2.description 3.status 4.priority 5.dueDate ");
                               int updatedfeild = Integer.parseInt(reader.readLine());
                               System.out.println("Insert the new value");
                               String value = reader.readLine();
                               TaskManagement.updatedTask(taskId,value,updatedfeild);
                               break;
                           }
                           case 4 :{
                               TaskManagement.listOfTasks();
                               break;
                           }
                           case 5:{
                               System.out.println("Insert the number of required status : assigned , completed ,  inprocessing ,or press enter");
                               String status = reader.readLine();
                               System.out.println("Insert the number of required priority : high ,  intermediate , low ,or press enter ");
                               String priority = reader.readLine();
                               System.out.println("Insert the number of required dueDate or press enter ");
                               String output =reader.readLine();
                               LocalDate dueDate = (output.isEmpty())?LocalDate.parse("1111-11-11"):LocalDate.parse(output);
                               TaskManagement.filter(status ,priority ,dueDate);
                               break;
                           }
                           case 6:{
                               System.out.println("Which value you want to sort by ?  ");
                               System.out.println(" 1.status 2.priority 3.dueDate ");
                               int sortingCriteria = Integer.parseInt(reader.readLine());
                               TaskManagement.sort(sortingCriteria);
                               break;
                           }
                           case 7:{
                               flag =false;
                               break;
                           }

                       }
                    }
                break;
                }
                case 3:{
                    boolean flag =true;
                    System.out.println("1. Add new project ");
                    System.out.println("2. existent projects ");
                    console = reader.readLine();
                    int Options = Integer.parseInt(console);
                    switch(Options){
                    case 1:{
                         project = new Project();
                        }
                    case 2:{
                        while(flag){
                        System.out.println("***** Project operations ****** ");
                        System.out.println("1. Add tasks ");
                        System.out.println("2. delete tasks ");
                        System.out.println("3. Project Analysis");
                        System.out.println("4. tasks details");
                        System.out.println("5. Exit");
                        console = reader.readLine();
                        int projectOptions = Integer.parseInt(console);


                        switch (projectOptions) {
                            case 1: {
                                System.out.println("Insert the title ");
                                String title = reader.readLine();
                                System.out.println("Insert the description ");
                                String description = reader.readLine();
                                System.out.println("Insert the status (assigned ,completed ,  inprocessing)");
                                String status = reader.readLine();
                                System.out.println("Insert the priority (high ,  intermediate , low)");
                                String priority = reader.readLine();
                                System.out.println("Insert the dueDate (0000-00-00)");
                                LocalDate dueDate = LocalDate.parse(reader.readLine());

                                project.addTask(new Task(title, description, status, priority, dueDate));

                                break;
                            }
                            case 2: {
                                System.out.println("Insert the task ID you want to remove");
                                int taskId = Integer.parseInt(reader.readLine());
                                project.removeTask(taskId);
                                break;
                            }
                            case 3: {
                                project.ProjectAnalyzing();
                                break;
                            }
                            case 4: {
                                project.listOfTasks();
                                break;
                            }
                            case 5: {
                                flag = false;
                                break;
                            }

                        }
                        }
                        break;
                    }
                    }

                    break;
                }
                case 4 : {
                    ExecutorService service = Executors.newFixedThreadPool(10);
                    List<Task> processingTasks = TaskManagement.listTasks();
                    for (Task processingTask : processingTasks) {
                        service.execute(new TaskProcessor(processingTask));
                    }
                    break;

                }
            }
            }
        catch (DateTimeParseException o){
            System.out.println("Invalid date format , try again");
        }
        catch (NumberFormatException l){
            System.out.println("Please chose one of the listed the options ");
        }
        catch(Exception exception){
            System.out.println(exception.toString());
            System.out.println("something went wrong");
        }
        }


    }
}