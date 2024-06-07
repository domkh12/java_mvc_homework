package controller;

import exception.InputException;
import exception.UserNotFound;
import model.User;
import model.dao.UserDao;
import model.dto.UserDto;
import model.service.UserService;
import model.service.UserServiceImpl;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class UserController {
    private final UserService userService = new UserServiceImpl();
    public void getAllUsers(){
        tableRender(userService.getAllUsers());
    }
    public void addUser(){
        Integer id = new Random().nextInt(10000);
        System.out.print("Enter Name: ");
        String name = new Scanner(System.in).next();
        System.out.print("Enter Email: ");
        String email = new Scanner(System.in).next();
        System.out.print("Enter Password: ");
        String pass = new Scanner(System.in).next();
        System.out.println("[*] Add new user successfully");
        userService.addUser(new User(id, name, email, pass));
    }
    public void deleteUser() throws UserNotFound, InputException{
        System.out.print("Delete by ID: ");
        Scanner scanner = new Scanner(System.in);
        if(!scanner.hasNextInt()){
            throw new InputException("[!] Invalid option");
        }
        int del = scanner.nextInt();
        userService.deleteUser(del);
        System.out.println("[*] Deleted user successfully");
    }
    public void updateUser() throws UserNotFound, InputException {
        System.out.print("Update By ID: ");
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            throw new InputException("[!] Invalid option");
        }
        Integer id = scanner.nextInt();
        var list = userService.getAllUsers().stream().filter(e -> e.id().equals(id)).toList();
        if(list.isEmpty()){
            throw new UserNotFound("[!] ID NOT FOUND");
        }
        System.out.println("[*] ID FOUND");
        tableRender(list);
        System.out.print("[+] Enter new name: ");
        String name = new Scanner(System.in).next();
        System.out.print("[+] Enter new email: ");
        String email = new Scanner(System.in).next();
        System.out.print("[+] Enter new password: ");
        String pass = new Scanner(System.in).next();
        userService.updateUser(new User(id, name, email, pass));
        System.out.println("[*] User updated successfully");

    }

    public void tableRender(List<UserDto> userDtos){
        Table t = new Table(3, BorderStyle.UNICODE_BOX, ShownBorders.ALL);

        t.setColumnWidth(0, 30,30);
        t.setColumnWidth(1, 30,30);
        t.setColumnWidth(2, 30,30);
        t.addCell("ID",new CellStyle(CellStyle.HorizontalAlign.CENTER));
        t.addCell("Name",new CellStyle(CellStyle.HorizontalAlign.CENTER));
        t.addCell("Email",new CellStyle(CellStyle.HorizontalAlign.CENTER));
        for (UserDto u : userDtos){
            t.addCell(String.valueOf(u.id()), new CellStyle(CellStyle.HorizontalAlign.CENTER));
            t.addCell(u.name(), new CellStyle(CellStyle.HorizontalAlign.CENTER));
            t.addCell(u.email(), new CellStyle(CellStyle.HorizontalAlign.CENTER));
        }
        System.out.println(t.render());
    }
}
