package game;

import enemy.*;
import heroes.Hero;

import java.util.Random;



public class GameMap {
  final private Enemy[][] MAP =new Enemy[3][3];
    private int count=0;

    //initialise map when it created
    public GameMap() {
        mapInitialise();
    }

    Random rnd=new Random();
  static private int level=1;

   /* public int getLevel() {
        return level;
    }*/



    public Enemy[][] getMAP() {
        return MAP;
    }



    public void mapInitialise()
    {
        for (int i = 0; i < MAP.length ; i++) {
            for (int j = 0; j < MAP.length; j++) {
                if(i==1 && j==1)
                    continue;
                int type=rnd.nextInt(level*10);

                if(type<4)
                    MAP[i][j]=new Snakes();
                else if(type>=5 && type<=11)
                    MAP[i][j]=new SkeletonWarrior();
                else if(type>=12 && type<=36)
                    MAP[i][j]=new DevilWolves();
                else if(type>=36 && type<=60)
                    MAP[i][j]=new BarbarianWarrior();
                else if(type>=60 && type<=75)
                    MAP[i][j]=new Cerber();
                else if(type>=75 && type<=90)
                    MAP[i][j]=new Hydra();
                else if(type>=90 && type<=100)
                    MAP[i][j]=new Dragon();
                else
                {

                    count++;
                }


            }
        }
    }

    //check if there is enemy
    public Boolean checkEnemy(Hero hr) {
        boolean dis=false;
        if(MAP[hr.getPlayerPositionX()][hr.getPlayerPositionY()]!=null)
        {
            dis= true;
            System.out.println("Enemy on our way ");
        }
        return dis;
    }
    public void setToNull(Hero hero)
    {
        MAP[hero.getPlayerPositionX()][hero.getPlayerPositionY()]=null;
        count++;
    }


    //check if you pass the level
    public boolean levelPass()
    {
        int maxTurns = 8;
        if(count== maxTurns) {
            System.out.println("Congratulations you passed level "+level);
            level++;
            System.out.println("Welcome to level "+ level);
            System.out.println("This level filled with more dangerous creatures");
            mapInitialise();
            return  true;
        }
        return false;
    }
}
