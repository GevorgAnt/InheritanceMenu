package main;
import user.User;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        User user=new User();
        try {
            user.loginOrRegistration();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
