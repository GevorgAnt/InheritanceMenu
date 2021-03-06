package menu;

import fileService.FileService;
import fileService.SaveService;
import game.Play;
import heroService.Service;
import heroes.Hero;

import java.util.*;

public class MainMenu {
    //
    CharacterMenu characterMenu=new CharacterMenu();
    //File Read Write method for Heroes
    FileService service=new FileService();
    //File load save methods for Heroes
    SaveService heroesService=new SaveService();
    public  void start()
    {

        Scanner scanner=new Scanner(System.in);
        int select;
        System.out.println("i am greeting you to my rpg game simulator");
        System.out.println("Here you can create new hero and crash some enemies");
        System.out.println("type 1 to start new game, 2 to load saves,3 to show your heroes sorted by Level");
        try {
            select = Integer.parseInt(scanner.next());
        }
        catch (NumberFormatException e)
        {
            select=1;
        }
        switch (select)
        {
            case 1:{
                //start new game
                characterMenu.start();
                break;
            }
            case 2: {
                //load from txt files
                Hero hero = null;
                service.read();
                System.out.println("Now choose your hero by id");
                boolean pass = false;

                while (!pass) {
                    try {
                        int choose = Integer.parseInt(scanner.next());
                        if (service.getById(choose) != null) {
                            hero = heroesService.load(choose);
                            pass = true;
                        }

                    } catch
                    (Exception e) {
                        System.out.println("Select valid number");
                    }
                }
                Play play=new Play(hero);
                play.start();
                break;
            }
            case 3:{
                //Three map to sort Elements
                Service heroService = new Service();
                ArrayList<Hero> heroes= heroService.sortedHeroes();
                heroes.sort(Hero::compareTo);
                for (Hero hero:heroes) {
                    System.out.println(hero.print());
                }

                }
        }

        }

       /* public FileService getFileService()
        {
            return characterMenu.getFile();
        }*/
    }

