import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
/**
 * The UserManagement class contains all the operation can be done on the user object like add , update,and remove
 * users are stored as collection of an ArrayList

 */
public class UserManagement {
    static ArrayList<User> users =new ArrayList<>(); //users contains the objects of type User

    /**
     *adds new user
     * @param addedUser  the object that will be added
     */
    static void addUser(User addedUser){
        if(users.add(addedUser)) {
            System.out.println("User added successfully.");
        } else {
            System.out.println("The operation failed, make sure to insert the right inputs.");
        }

    }
    /**
     *removes user by ID
     * @param userId  the ID of the User Object that will be removed
     */
    static void removeUser(int userId){
        try{
        User removedTask = users.stream().filter(user -> user.getId() == userId).findFirst().orElseThrow();
        users.remove(removedTask);
        System.out.println("user removed successfully.");

    }catch(
    NoSuchElementException o){    //an Exception thrown if the inserted ID does not exist
        System.out.println("the inserted user ID does not exist");
    }
    }

    /**
     *update user by ID
     * @param userId  the ID of the User Object that will be updated
     */
    static void updateUser(int userId , String email ,String name){
        try{
        User updatedUser = users.stream().filter(user -> user.getId() == userId).findFirst().orElseThrow();
        updatedUser.setEmail((email==null)?updatedUser.getEmail():email);
        updatedUser.setName((name==null)?updatedUser.getName():name);
        }catch(
                NoSuchElementException o){
            System.out.println("the inserted user ID does not exist");
        }
    }

    /**
     *print the details of each user
     */
    static void usersDetails(){
        for (User user : users) {
            System.out.println("user Id : "+user.getId());
            System.out.println("user name : " + user.getName());
            System.out.println("user email : "+user.getEmail());
        }
    }


}
