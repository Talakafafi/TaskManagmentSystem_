import java.util.LinkedList;

public class UserManagment {
    static LinkedList<User> users =new LinkedList<>();

    static void addUser(User addedUser){
        users.add(addedUser);

    }
    static void deleteUser(User removedUser){
        users.remove(removedUser);
    }
    static void updateUser(User updatedUser , String email ,String name){
        updatedUser.setEmail((email==null)?updatedUser.getEmail():email);
        updatedUser.setName((name==null)?updatedUser.getName():name);
    }




}
