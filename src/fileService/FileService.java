package fileService;

import heroService.Service;
import heroes.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class FileService {
    final String PATH = "Heroes.txt";
    int id=1;
    File newFile = new File(PATH);
    public void read() {

        try {
            Scanner myReader = new Scanner(newFile);
            boolean empty = true;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                //String[] res=data.split(",");
                empty = false;
            }
            if (empty) {
                System.out.println("you dont have any hero created ");
                System.out.println("So you need to create one");
                write();
                read();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File don`t found ");
        }


    }

    public Hero write() {
        Service sr = new Service();
        Hero hero1 = null;



        //System.out.println("hasav");
        hero1 = sr.CreateHero();
        String type = hero1.getClass().getSimpleName();
        String info="";
        if(newFile.length()==0)
        {
            info = id + "," + hero1.getName() + "," + hero1.getSex() + "," + hero1.getRace() + "," + hero1.getHeight() + "," + type;
        }
        else
        {
            info = "\n"+id + "," + hero1.getName() + "," + hero1.getSex() + "," + hero1.getRace() + "," + hero1.getHeight() + "," + type;

        }

        id++;
        try {
            Files.write(Paths.get("Heroes.txt"), info.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Couldn't save the file");
        }

        return hero1;
    }
    public Hero getById(int id) {
        Hero hr = null;
        String[] res = null;
        try {
            Scanner myReader = new Scanner(newFile);
            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();

                if (Integer.parseInt(String.valueOf(data.charAt(0))) == id) {

                    res = data.split(",");
                }


            }
            if (res == null) {
                System.out.println("Cant find object with " + id + " id");
                System.out.println("type valid id");
                return null;
            }

            switch (res[5]) {
                case "Archer": {
                    hr = new Archer(res[1], res[2].charAt(0), res[3], Integer.parseInt(res[4]));
                    break;
                }
                case "Bard": {
                    hr = new Bard(res[1], res[2].charAt(0), res[3], Integer.parseInt(res[4]));
                    break;
                }
                case "Knight": {
                    hr = new Knight(res[1], res[2].charAt(0), res[3], Integer.parseInt(res[4]));

                    break;
                }
                case "Thief": {
                    hr = new Thief(res[1], res[2].charAt(0), res[3], Integer.parseInt(res[4]));

                    break;
                }
                case "Wizard": {
                    hr = new Wizard(res[1], res[2].charAt(0), res[3], Integer.parseInt(res[4]));

                    break;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File don`t found ");
        }
        return hr;
    }
}
