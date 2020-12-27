package enemy;

import heroes.Hero;

import java.util.Random;

public class Hydra extends Enemy{
    public Hydra() {
        super();
        damage=60;
        name="Hydra";
        defence=50;
        coinDrop=20;
        ExperianceDrop=30;
        health=320  ;
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
        System.out.println("Enemy hit you with with Fire");
        Random rnd=new Random();
        int damage= this.damage+ rnd.nextInt(40);
        hero.setHealth(hero.getHealth()-damage);
        System.out.println("you lost " +damage  + " health");
        if(hero.getBaseDamage()>3)
        hero.setBaseDamage(hero.getBaseDamage()-3);
        if(getDefence()>5)
        hero.setDefence(hero.getDefence()-5);
    }



}
