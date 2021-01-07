package loginService;

import databaseService.DatabaseService;
import fileService.FileService;
import user.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class LoginService {

    private HashMap<String ,String> loginPass;

    public LoginService() throws IOException {
        this.loginPass = new HashMap<>();
        initLogins();

    }

    public HashMap<String, String> getLoginPass() {
        return loginPass;
    }

    public void initLogins() throws IOException {
        List<String> logins= DatabaseService.read();
        for (String x:logins)
        {
            String[] data=x.split(",");
            loginPass.put(data[1],data[3]);
        }
    }


    public String check() throws IOException {

        String login = loginValidation();
        if(!loginPass.isEmpty())
        {
            while(loginPass.containsKey(login))
            {
                System.out.println("Login is busy");
                login=loginValidation();
            }
        }

        return login;
    }


    private String loginValidation()
    {
        Scanner scanner=new Scanner(System.in);
        boolean valid=false;
        String login="";
        while (!valid) {
            login=scanner.nextLine();
            if (login.length() >= 10 ) {
                valid = true;
            }
            else {
                System.out.println("login must have at least 10 characters");
            }
        }
        return login;
    }

    public boolean checkLogin(String login,String password)
    {

        if(loginPass.containsKey(login))
        return loginPass.get(login).equals(User.md5DigestJavaHexString(password));

        return false;
    }
}
