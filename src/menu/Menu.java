package menu;

import fileService.FileService;

import heroes.*;
import weaponService.WeaponService;
import weapons.Weapon;

import java.util.Scanner;

public class Menu {
    FileService file=new FileService();
WeaponService service=new WeaponService();
    Scanner in = new Scanner(System.in);

    public void start() {
        Hero hero = null;
        System.out.println("i am greeting you to my hero simulator");
        System.out.println("Here you can create new hero and give him some individuality");
        System.out.println("Press 1 to crete new Hero or 2 to look heroes you created (2 by default)");
        int choose = Integer.parseInt(in.next());
        if (choose == 1) {
            hero = file.write();
        } else {
            file.read();
            System.out.println("Now choose your hero by id");
            boolean pass = false;

            while (!pass) {
                try {
                    int select = Integer.parseInt(in.next());
                    if (file.getById(select) != null) {
                        hero =file.getById(select);
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
        System.out.println("8 to show menu context again, 9 for weapon stats");
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
                        hero =file.getById(temp);
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
                case "9": {
                    service.heroWeaponInfo(hero.getWeapon());
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


