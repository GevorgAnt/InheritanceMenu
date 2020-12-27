package enemy;

import heroes.Hero;

import java.util.Random;

public class BarbarianWarrior extends Enemy {

    public BarbarianWarrior() {
        super();
         damage=35;
         name="Barbarian warrior";
         defence=30;
         coinDrop=10;
         ExperianceDrop=10;
         health=150;
    }

    public void weaponAttack(Hero hero) {
        System.out.println("Enemy hit you");
        int damage= (int) Math.abs((this.damage-hero.getDefence()*0.15));
        hero.setHealth(hero.getHealth()-damage);
        System.out.println("you lost " +damage  + " health");
    }


    @Override
    public void abilityAttack(Hero hero) {
        System.out.println("Enemy hit you with with Axe");
        Random rnd=new Random();
        int damage= this.damage+ rnd.nextInt(20);
        hero.setHealth(hero.getHealth()-damage);
        System.out.println("you lost " +damage  + " health");
        if(hero.getCoins()>7)
            hero.setCoins(hero.getCoins()-7);
        this.defence+=7;
    }


}
