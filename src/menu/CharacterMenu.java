package menu;

import game.Play;
import fileService.FileService;

import heroes.*;
import weaponService.WeaponService;

import java.util.Scanner;

public class CharacterMenu {
    FileService file=new FileService();

    Scanner in = new Scanner(System.in);

    //start Character menu
    public void start() {
        Hero hero = null;

        System.out.println("Press 1 to crete new Hero or 2 to look heroes you created (2 by default)");
        int choose;
        try {
            choose= Integer.parseInt(in.next());
        }
        catch (NumberFormatException e)
        {
            choose=2;
        }

        if (choose == 1) {
            //Create new hero and write it to file
            hero = file.write();
        } else {
            //read file and get Heroes you created
            file.read();
            System.out.println("Now choose your hero by id");
            boolean pass = false;

            while (!pass) {
                try {
                    int select = Integer.parseInt(in.next());
                    //Chose hero by id you type
                    if (file.getById(select) != null) {
                        hero = file.getById(select);
                        pass = true;
                    }

                } catch
                (Exception e) {
                    System.out.println("Select valid number");
                }
            }
        }
        //showMenu();
        //choose what to do
        System.out.println("Type 1 to play game or 2 to view player stats, 0 to exit");
        String select = "";
        while (!select.equals("0")) {
            select = in.next();
            System.out.println("-----------");
            switch (select) {
                case "1": {
                    //start actual game with your hero
                    Play play=new Play(hero);
                    play.start();
                    select="0";
                    break;
                }
                case "2":{
                    //View your hero statistics
                    viewStats(hero);
                    break;
                }
                case "0": {
                    //close program
                    System.out.println("Good luck");
                    break;
                }
                    }
                /* */
            }
        }





      private void showMenu() {

        System.out.println("Now you can get some information about your hero");
        System.out.println("Type 1 for weapon information");
        System.out.println("Type 2 to view hero stats");
        System.out.println("Type 3 to Play game");
        System.out.println("6 to create new hero and 7 to select another one");
        System.out.println("8 to show menu context again");
          System.out.println("0 to get to Menu and -1 to exit");
    }
    //Hero stats menu
    private void viewStats(Hero hero) {
        showMenu();
        String select = "";
        while (!select.equals("0")) {
            select = in.next();
            System.out.println("-----------");
            switch (select) {
                case "1": {

                    WeaponService service=new WeaponService();
                    service.heroWeaponInfo(hero.getWeapon());
                    System.out.println("-----------");
                    break;
                }
                case "2": {

                    System.out.println(Hero.getDescription());
                    System.out.println(hero.print());
                    System.out.println("-----------");
                    break;
                }
                case "3": {

                    Play play=new Play(hero);
                    play.start();
                    break;
                }


                case "6": {
                    hero = file.write();
                    System.out.println("-----------");
                    showMenu();
                    break;
                }
                case "7": {
                    System.out.println("-----------");
                    file.read();
                    try {
                        int temp = Integer.parseInt(in.next());
                        while (file.getById(temp) == null) {
                            temp = Integer.parseInt(in.next());
                        }
                        hero = file.getById(temp);
                    } catch (Exception e) {
                        System.out.println("type valid number");
                    }
                    showMenu();
                    break;
                }
                case "8": {
                    showMenu();
                    break;
                }

                case "-1": {
                    System.out.println("good luck");
                    break;
                }
                case "0": {
                    MainMenu menu=new MainMenu();
                    menu.start();
                    break;
                }
                default: {
                    System.out.println("select valid number");
                    break;

                }
            }

        }
    }}

