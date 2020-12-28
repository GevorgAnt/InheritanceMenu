package heroes;
import enemy.Enemy;
import weapons.Lute;


import java.util.Random;


public class Bard extends Hero  {
    Random rnd=new Random();
    public Bard(String name, char sex, String race, int size) {
        super();

        description = "A musician who aids and support his allies and make them stronger (stats up and buffing up), and weaken the enemies " +
                "with spells and debuffs.";
        start();
        weapon = new Lute();
        this.name = name;
        this.sex = sex;
        this.race = race;
        this.height = size;

    }

    @Override
    public void specialSkill(Enemy enemy) {
        health+=5;
        enemy.setDefence(enemy.getDefence()-1);
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
        return percent >= 50;
    }

    @Override
    public void start() {
        health = 250;
        defence = 120;
        abilityCastCount=14;
        baseDamage=20;
    }

    @Override
    public void levelUp() {
        start();
        System.out.println("Congratulations you raised your level");
        System.out.println("you got stronger and batter");
        level++;

        experience -=100;
        health+=level*8;
        defence+=level*2;
        baseDamage+=level*2;

    }


}
