package heroes;


import enemy.Enemy;
import weapons.Bow;


import java.util.Random;


public class Archer extends Hero {
    Random rnd = new Random();

    public Archer(String name, char sex, String race, int size) {
        super();

        description = "Archer- a range fighter who uses bows  as a primary weapon " +
                "and can pinpoint enemies weakness (Analyze).";

        start();
        weapon = new Bow();
        this.name = name;
        this.sex = sex;
        this.race = race;
        this.height = size;

    }


    @Override
    public void specialSkill(Enemy enemy) {
        if(enemy.getDefence()<=0)
        enemy.setDefence(enemy.getDefence()-15);
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
        return percent > 30;
    }

    @Override
    public void start() {
        health = 170;
        defence = 100;
        abilityCastCount = 3;
    }

    @Override
    public void levelUp() {
        start();
        System.out.println("Congratulations you raised yur level");
        System.out.println("Your got stronger and batter");
        level++;

        experience -= 100;
        health += level * 5;
        defence += defence * 3;
        baseDamage += level * 3;
    }
}
