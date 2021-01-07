package user;

import databaseService.DatabaseService;
import fileService.FileService;
import loginService.LoginService;
import menu.MainMenu;


import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.Scanner;

public class User {

    DatabaseService fileService = new DatabaseService();
    Scanner scanner = new Scanner(System.in);
    String name;
    String surname;
    String email;
    String userName;
    String password;


    public static String md5DigestJavaHexString(String message) {
        StringBuilder sb = new StringBuilder();
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(message.getBytes());
            byte[] digest = md.digest();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public void userRegistration() throws IOException {

        LoginService service = new LoginService();

        System.out.println("Enter name :");
        name = validate("^[A-Z]+([a-z])*");
        System.out.println("Enter surname:");
        surname = validate("^[A-Z]+([a-z])*");
        System.out.println("Enter email:");
        email = validate("^(.+)@(.+).(.+)$");
        System.out.println("Enter user login");
        userName = service.check();
        System.out.println("Enter user password");
        String tempPass = validate("^(?=.{8,}$)(?=(?:.*[A-Z]){2,})(?=.*[a-z])(?=(?:.*[0-9]){3,}).*");
        password = md5DigestJavaHexString(tempPass);

        String[] data = {name, surname, userName, email, password};
        fileService.write(data);
    }

    private String validate(String regex) {

        String data = scanner.nextLine();
        while (!data.matches(regex)) {
            System.out.println("Enter valid data");
            data = scanner.nextLine();
        }
        return data;
    }


    public void loginOrRegistration() throws IOException {
        LoginService service = new LoginService();
        System.out.println("Login(1) or register(2) new account (2 by default)");
        int choose = Integer.parseInt(scanner.next());
        scanner.nextLine();

        switch (choose) {
            case 1: {
                System.out.println("Enter login");
                String login = scanner.nextLine();
                System.out.println("Enter password");
                String password = scanner.nextLine();
                if (!service.checkLogin(login, password)) {
                    System.out.println("invalid input data");
                }
                else {
                    System.out.println("Complete");
                    MainMenu menu=new MainMenu();
                    menu.start();
                }
                break;
            }
            default: {
                userRegistration();
                loginOrRegistration();
                break;
            }
        }
    }

}
