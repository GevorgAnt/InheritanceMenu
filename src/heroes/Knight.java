package heroes;



import enemy.Enemy;
import weapons.SwordAndShield;

import java.util.Random;

public class Knight extends Hero {

Random rnd=new Random();
    public Knight(String name, char sex, String race, int size) {
        super();

        description = "Knight- Defender of the weaks, specialize in melee combat, and use cover/guard " +
                "to defend those who are in danger.";
       start();
        weapon = new SwordAndShield();
        this.name = name;
        this.sex = sex;
        this.race = race;
        this.height = size;

    }



    @Override
    public void specialSkill(Enemy enemy) {
        enemy.setDamage(enemy.getDamage()-3);
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
        int percent = rnd.nextInt(100);
        return percent > 70;
    }

    @Override
    public void start() {
        health = 300;
        defence = 200;
        abilityCastCount=3;
    }

    @Override
    public void levelUp() {
        start();
        System.out.println("Congratulations you raised your level");
        System.out.println("you got stronger and batter");
        level++;
        experience -=100;
        health+=level*4;
        defence+=level*4;
        baseDamage+=level*2;

    }
}
