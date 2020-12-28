package game;

import enemy.Enemy;
import fileService.FileService;
import fileService.SaveService;
import heroes.Hero;
import weaponService.WeaponService;

import java.util.Random;
import java.util.Scanner;

public class Play {
    //enum directions for moving
    Directions dir = null;
    GameMap map = new GameMap();
    Hero player;

    Scanner inp = new Scanner(System.in);
    SaveService service=new SaveService();

    //get hero
    public Play(Hero player) {
        this.player = player;
    }

    //start actual game
    public void start() {

        //while player still alive he can move
        while (!player.gameOver()) {
                dir = move(player);
                switch (dir) {
                    case EAST -> player.setPlayerPositionX(player.getPlayerPositionX() + 1);
                    case WEST -> player.setPlayerPositionX(player.getPlayerPositionX() - 1);
                    default -> player.setPlayerPositionY(player.getPlayerPositionY() + 1);
                    case SOUTH -> player.setPlayerPositionY(player.getPlayerPositionY() - 1);
                }
                //check if enemy detected
                if (map.checkEnemy(player)) {
                    war(player, map.getMAP()[player.getPlayerPositionX()][player.getPlayerPositionY()]);
                }
                //if not check if it is weapon store ore checkpoint
                else if(!map.checkEnemy(player))
                {
                    //chance for trade
                    Random random = new Random();
                    int chance= random.nextInt(100);
                    if(chance>=70) {
                        WeaponService weaponService = new WeaponService();
                        weaponService.trade(player);
                    }
                    else if(chance>=55)
                    {
                    //chance for checkpoint
                        System.out.println("Checkpoint reached ");
                        //save hero stats in checkpoint
                        service.save();

                    }
                    else
                        System.out.println("Way is clear");
                }

            }
        //if hero died restart game or exit
        restartOrExit();

        }

    private void restartOrExit() {
        System.out.println("GAME OVER YOU LOST!!!");
        System.out.println("Want to try again or exit??");
        System.out.println("1 to try again from checkpoint  2 to restart the game");
        inp.nextLine();
        int select=inp.nextInt();
        if(select==1)
        {
            //start new game with loaded hero
            Play contain=new Play(service.load(player.getId()));
            contain.start();


        }
        else if(select==2)
        {
            //restart game
            FileService service=new FileService();
            Play restart=new Play(service.getById(player.getId()));
            restart.start();
        }

    }

//   enemy fight mechanic
    private void war(Hero hero, Enemy enemy) {
        System.out.println("Lets crush some skulls !!");
        System.out.println("You met " + enemy.getName());
        System.out.println("-------");
        while (!enemy.died() && !hero.gameOver()) {

            System.out.println("type 1 to attack 2 evade from enemy attack and 3 to use your hero ability you have " + hero.getAbilityCastCount() + " mana");
            System.out.println("your health " + hero.getHealth());
            int select = Integer.parseInt(new Scanner(System.in).next());
            switch (select) {
                case 1: {
                    attackEnemy(enemy, hero);

                    break;
                }
                case 2: {
                    if (hero.evade()) {
                        System.out.println("you evaded from enemy");
                        System.out.println("Enemy lost some of his armor");
                        enemy.setDefence(enemy.getDefence() - 10);
                    } else {
                        System.out.println("Enemy catch you");
                        enemy.abilityAttack(hero);
                    }
                    break;
                }
                case 3: {
                    hero.abilityAttack(enemy);
                    if(enemy.died())
                        getLoot(hero,enemy);
                    break;
                }
            }
        }
    }

    //choose direction to move
    public Directions move(Hero hr) {
        boolean pass=false;
        while (!pass) {

            System.out.println("Choose direction to move (1-East(>),2-West(<),3-South(v),4-North(^)(Default))");
            int select = Integer.parseInt(inp.next());
            switch (select) {
                case 1: {
                    if (hr.getPlayerPositionX() <2) {
                        dir = Directions.EAST;
                        pass = true;

                    }
                    break;
                }
                case 2: {
                    if (hr.getPlayerPositionX() > 0) {
                        dir = Directions.WEST;
                        pass = true;

                    }
                    break;
                }
                case 3: {
                    if (hr.getPlayerPositionY() > 0) {
                        dir = Directions.SOUTH;
                        pass = true;
                    }
                    break;
                }
                default: {
                    if (hr.getPlayerPositionY() <2) {
                        dir = Directions.NORTH;
                        pass = true;

                    }
                    break;
                }

            }
            if (!pass) {
                System.out.println("Edge of the world select another direction");
            }
        }
        return dir;
    }

    //attack enemy and take loot after killing him
    public void attackEnemy(Enemy enemy,Hero hero) {
             hero.weaponAttack(enemy);
        if(enemy.died())
        {
            getLoot(hero, enemy);
        }
        else
        {
            enemy.weaponAttack(hero);
        }
    }

    //get experience and coin from enemy
    public void getLoot(Hero hero,Enemy enemy)
    {

        hero.setCoins(hero.getCoins()+enemy.getCoinDrop());
        hero.setExperience(hero.getExperience()+enemy.getExperianceDrop());
        if(hero.getExperience()>=100) {
            hero.levelUp();

        }
        System.out.println("Congratulations You killed "+enemy.getName());
        map.setToNull(hero);
        //if map cleared set hero default position
        if(map.levelPass())
        {
            hero.setPlayerPositionY(1);
            hero.setPlayerPositionX(1);
        }
    }


}
