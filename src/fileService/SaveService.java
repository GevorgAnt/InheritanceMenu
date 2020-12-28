package fileService;

import heroes.Hero;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class SaveService {
    final String PATH = "HeroesParams.txt";
    //int id=0;
   // FileService service = new FileService();


    //file path
    File newFile = new File(PATH);
    //get heroes from FileService
    HashMap<Integer, Hero> heroes = FileService.getIdHero();
    Set<Map.Entry<Integer, Hero>> set = heroes.entrySet();

     public void save() {
         StringBuilder builder=new StringBuilder();
         String info="";
         //update all hero stats in txt file
        for (Map.Entry<Integer, Hero> me : set) {
            Hero hr = me.getValue();

             info = builder.append(hr.getId()).append(",").append(hr.getPlayerPositionX()).append(",").append(hr.getPlayerPositionY()).append(",").append(hr.getCoins()).append(",").append(hr.getLevel()).append(",").append(hr.getExperience()).append(",").append(hr.getAbilityCastCount()).append(",").append(hr.getHealth()).append(",").append(hr.getBaseDamage()).append(",").append(hr.getDefence()).toString();
            builder.append(System.getProperty("line.separator"));
        }
        try {
            Files.write(Paths.get(PATH), info.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

     }

     //Load Heroe1

    public Hero load(int id) {

        Hero hero = heroes.get(id);
        if (newFile.length() == 0) {
            System.out.println("You dont have any saves");
        } else {
        try {

            Scanner myReader = new Scanner(newFile);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                String[] res = data.split(",");
                if (id == Integer.parseInt(res[0])) {
                    //set all hero parametres
                    hero.setPlayerPositionX(Integer.parseInt(res[1]));
                    hero.setPlayerPositionY(Integer.parseInt(res[2]));
                    hero.setCoins(Integer.parseInt(res[3]));
                    hero.setLevel(Integer.parseInt(res[4]));
                    hero.setExperience(Integer.parseInt(res[5]));
                    hero.setAbilityCastCount(Integer.parseInt(res[6]));
                    hero.setHealth(Integer.parseInt(res[7]));
                    hero.setBaseDamage(Integer.parseInt(res[8]));
                    hero.setDefence(Integer.parseInt(res[9]));
                    break;
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("File don`t found ");
        }

        }
        return hero;
    }




}
