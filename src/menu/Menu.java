package menu;

import heroeService.Service;
import heroes.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Menu {
    int id = 1;
    final String PATH = "Heroes.txt";
    File newFile = new File(PATH);
    Scanner in = new Scanner(System.in);

    public void start() {
        Hero hero = null;
        System.out.println("i am greeting you to my hero simulator");
        System.out.println("Here you can create new hero and give him some individuality");
        System.out.println("Press 1 to crete new Hero or 2 to look heroes you created (2 by default)");
        int choose = Integer.parseInt(in.next());
        if (choose == 1) {
            hero = write();
        } else {
            read();
            System.out.println("Now choose your hero by id");
            boolean pass = false;

            while (!pass) {
                try {
                    int select = Integer.parseInt(in.next());
                    if (getById(select) != null) {
                        hero = getById(select);
                        pass = true;
                    }

                } catch
                (Exception e) {
                    System.out.println("Select valid number");
                }
            }
        }
        System.out.println("Now you can get some information about your hero");
        System.out.println("Type 1 for weapon information, 2 for hero movement info");
        System.out.println("3 for specialSkill, 4 for ability attack");
        System.out.println("5 for secondary attack, ");
        System.out.println("6 to create new hero and 7 to select another one");
        System.out.println("8 to show menu context again");
        System.out.println("0 to get to exit");

        String select = "";
        while (!select.equals("0")) {
            select = in.next();
            System.out.println("-----------");
            switch (select) {
                case "1": {

                    hero.weaponAttack(hero.getWeapon());
                    System.out.println("-----------");
                    break;
                }
                case "2": {

                    hero.jump();
                    hero.defence();
                    System.out.println("-----------");
                    break;
                }
                case "3": {
                    hero.specialSkill();
                    System.out.println("-----------");
                    break;
                }
                case "4": {
                    hero.abilityAttack();
                    System.out.println("-----------");
                    break;
                }
                case "5": {
                    hero.secondAttack();
                    System.out.println("-----------");
                    break;
                }
                case "6": {
                    hero = write();
                    System.out.println("-----------");
                    showMenu();
                    break;
                }
                case "7": {
                    System.out.println("-----------");
                    read();
                    try {
                        int temp = Integer.parseInt(in.next());
                        while (getById(temp) == null) {
                            temp = Integer.parseInt(in.next());
                        }
                        hero = getById(temp);
                    } catch (Exception e) {
                        System.out.println("type vaid number");
                    }
                    showMenu();
                    break;
                }
                case "8": {
                    showMenu();
                    break;
                }
                case "0": {
                    System.out.println("good luck");
                    break;
                }
                default: {
                    System.out.println("select valid number");
                    break;

                }
            }
        }


    }

    private void read() {

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

    public void showMenu() {

        System.out.println("Now you can get some information about your hero");
        System.out.println("Type 1 for weapon information, 2 for hero movement info");
        System.out.println("3 for specialSkill, 4 for ability attack");
        System.out.println("5 for secondary attack, ");
        System.out.println("6 to create new hero and 7 to select another one");
        System.out.println("8 to show menu context again");
        System.out.println("0 to get to exit");
    }
}


