package enemy;

import heroes.Hero;

import java.util.Random;

public class Cerber extends Enemy{
    public Cerber() {
        super();
        damage=25;
        name="Cerberus";
        defence=300;
        coinDrop=100;
        ExperianceDrop=40;
        health=300;
    }

    public void weaponAttack(Hero hero) {
        System.out.println("Enemy hit you");
        int damage= (int) Math.abs((this.damage-hero.getDefence()*0.15));
        hero.setHealth(hero.getHealth()-damage);
        System.out.println("you lost " +damage  + " health");
    }


    @Override
    public void abilityAttack(Hero hero) {
        System.out.println("Enemy hit you with with Claws");
        Random rnd=new Random();
        int damage= this.damage+ rnd.nextInt(35);
        hero.setHealth(hero.getHealth()-damage);
        System.out.println("you lost " +damage  + " health");
        if(hero.getExperience()>10)
            hero.setExperience(hero.getExperience()-10);
        this.damage+=7;
    }


}
