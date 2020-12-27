package fileService;

import heroService.Service;
import heroes.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import java.util.HashMap;

import java.util.Scanner;

public class FileService {
    final String PATH = "Heroes.txt";
    final String PATH_PARAM = "HeroesParams.txt";
    int id=0;
    File newFile = new File(PATH);
    File file = new File(PATH_PARAM);
   // List<Hero> heroList=new ArrayList<>();

    //Hashmap containing all heroes created
   static HashMap<Integer,Hero> idHero=new HashMap<>();

   static public HashMap<Integer, Hero> getIdHero() {
        return idHero;
    }



    public FileService() {
        saveHeroes();
    }

    //Get all heroes from Heroes.txt and pass it to hashmap
    public  void saveHeroes()
    {
        Hero hr=null;
        try {
            Scanner myReader = new Scanner(newFile);

            while (myReader.hasNextLine())
            {
                String data=  myReader.nextLine();
                String[] res=data.split(",");
                id++;
                //Detect which class was created
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
                assert hr != null;
                //set hero id
                hr.setId(id);
                idHero.put(id,hr);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //read from Heroes.txt
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

    //txt write and hero crate methods
    public Hero write() {
       //Hero service
        Service sr = new Service();
        Hero hero1 ;
        //System.out.println("hasav");
        //Create new Hero
        hero1 = sr.CreateHero();
        StringBuilder builder=new StringBuilder(",");
        String type = hero1.getClass().getSimpleName();
        String params;
        String info;
            id++;
        idHero.put(id,hero1);
        //Append all strings and pass it to fileWriter
        info=new StringBuilder(",").append(id).append(hero1.getName()).append(hero1.getSex()).append( hero1.getRace()).append(hero1.getHeight()).append(type)+ "\n";
            //info = id + "," + hero1.getName() + "," + hero1.getSex() + "," + hero1.getRace() + "," + hero1.getHeight() + "," + type+","+hero1.getExperience()+","+hero1.getHealth()+","+hero1.getCoins()+","+hero1.getLevel()+"\n";

        if(file.length()!=0)
            builder.append(System.getProperty("line.separator"));
        params= builder.append(id).append(hero1.getPlayerPositionX()).append(hero1.getPlayerPositionY()).append(hero1.getCoins()).append(hero1.getLevel()).append( hero1.getExperience()).append(hero1.getAbilityCastCount()).append(hero1.getHealth()).append( hero1.getBaseDamage()).append( hero1.getDefence()).toString();


        try {
            //Append do txt files
            Files.write(Paths.get(PATH), info.getBytes(), StandardOpenOption.APPEND);
            Files.write(Paths.get(PATH_PARAM), params.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Couldn't save the file");
        }

        //return created hero
        return hero1;
    }


    //get Hero from hashmap
    public Hero getById(int id) {
        Hero hr = null;
            hr=idHero.get(id);

            if (hr == null) {
                System.out.println("Cant find object with " + id + " id");
                System.out.println("type valid id");
                return null;
            }

        return hr;
    }
}
