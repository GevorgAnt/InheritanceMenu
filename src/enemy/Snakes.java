package enemy;

import heroes.Hero;

import java.util.Random;

public class Snakes extends Enemy {
    public Snakes() {
        super();
        damage=5;
        name="Snake";
        defence=5;
        coinDrop=3;
        ExperianceDrop=5;
        health=55  ;
    }

    @Override
    public void weaponAttack(Hero hero) {
        System.out.println("Enemy hit you");
        int damage= (int) Math.abs((this.damage-hero.getDefence()*0.15));
        hero.setHealth(hero.getHealth()-damage);
        System.out.println("you lost " +damage  + " health");
    }


    @Override
    public void abilityAttack(Hero hero) {
        System.out.println("Enemy hit you with with poison");
        Random rnd=new Random();
        int damage= this.damage+ rnd.nextInt(25);
        hero.setHealth(hero.getHealth()-damage);
        System.out.println("you lost " +damage  + " health");
        if(hero.getBaseDamage()>3)
        hero.setBaseDamage(hero.getBaseDamage()-3);
    }


}
