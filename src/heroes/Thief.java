package heroes;



import enemy.Enemy;
import weapons.Dagger;

import java.util.Random;

public class Thief extends Hero  {
    Random rnd=new Random();
    public Thief(String name, char sex, String race, int size) {
        super();

        description = "Thief- a fast fighter able to pickpocket the enemies to get rare items " +
                "from them and sometimes their own equipment to benefits the group. ";
        start();
        weapon = new Dagger();
        this.name = name;
        this.sex = sex;
        this.race = race;
        this.height = size;

    }

    @Override
    public void specialSkill(Enemy enemy)
    {

        if(rnd.nextInt(100)>=90)
        {
            enemy.setHealth(0);
        }
    }





    @Override
    public void weaponAttack(Enemy enemy) {

        specialSkill(enemy);
        System.out.println("You hit the enemy");
        int damage=(int) ((baseDamage+weapon.getDamage()-enemy.getDefence()*0.15));
        System.out.println("Enemy lost "+damage+" health");
        enemy.setHealth(enemy.getHealth()-damage);
    }

    @Override
    public boolean evade() {
        int percent = rnd.nextInt(101);
        return percent > 45;
    }

    @Override
    public void start() {
        health = 120;
        defence = 150;
        abilityCastCount=5;

    }

    @Override
    public void levelUp() {

        System.out.println("Congratulations you raised yur level");
        System.out.println("Your got stronger and batter");
        level++;
        start();
        experience -=100;
        health+=level*8;
        defence+=level*2;
        baseDamage+=level*4;

    }
}
