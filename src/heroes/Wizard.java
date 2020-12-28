package heroes;


import enemy.Enemy;
import weapons.Staff;

import java.util.Random;


public class Wizard extends Hero  {
    Random rnd=new Random();
    public Wizard(String name, char sex, String race, int size) {
        super();

        description = "a strong spell caster specialize in long range magic attacks.";
        start();
        weapon = new Staff();
        this.name = name;
        this.sex = sex;
        this.race = race;
        this.height = size;

    }

    @Override
    public void specialSkill(Enemy enemy) {

       enemy.setDamage(enemy.getDamage()-3);
       enemy.setDefence(enemy.getDefence()-3);
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
        return percent > 55;
    }

    @Override
    public void start() {
        health = 100;
        defence = 70;
        abilityCastCount=10;
    }

    @Override
    public void levelUp() {
        start();
        System.out.println("Congratulations you raised your level");
        System.out.println("you got stronger and batter");
        level++;

        experience -=100;
        health+=level*3;
        defence+=level*2;
        baseDamage+=level*5;

    }


}
