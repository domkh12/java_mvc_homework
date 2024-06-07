import controller.UserController;
import exception.InputException;
import exception.UserNotFound;
import model.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();

        System.out.println("\n" +
                "\t\t\t  ███╗   ███╗██╗   ██╗ ██████╗\n" +
                "\t\t\t  ████╗ ████║██║   ██║██╔════╝\n" +
                "\t\t\t  ██╔████╔██║██║   ██║██║     \n" +
                "\t\t\t  ██║╚██╔╝██║╚██╗ ██╔╝██║     \n" +
                "\t\t\t  ██║ ╚═╝ ██║ ╚████╔╝ ╚██████╗\n" +
                "\t\t\t  ╚═╝     ╚═╝  ╚═══╝   ╚═════╝\n" +
                "                              \n");
        while (true){
            try{
                    System.out.println("=================");
                    System.out.println("1. Add new user");
                    System.out.println("2. Show all user");
                    System.out.println("3. Update user");
                    System.out.println("4. Delete user");
                    System.out.println("0,99. Exit");
                    System.out.println("=================");
                    System.out.print("[+] Insert Option: ");
                    Scanner scanner = new Scanner(System.in);

                    if (!scanner.hasNextInt()) {
                        throw new InputException("[!] Invalid option");
                    }

                    Integer op = scanner.nextInt();
                    switch (op){
                        case 1:
                            userController.addUser();
                            break;
                        case 2:
                            userController.getAllUsers();
                            break;
                        case 3:
                            userController.updateUser();
                            break;
                        case 4:
                            userController.deleteUser();
                            break;
                        case 0,99:
                            System.out.println("Exiting");
                        default:
                            throw new InputException("[!] Invalid option");
                    }
            }catch (UserNotFound | InputException userNotFound){
                System.out.println(userNotFound.getMessage());
            }
        }
    }
}