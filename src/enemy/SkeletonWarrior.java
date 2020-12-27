package enemy;

import heroes.Hero;

import java.util.Random;

public class SkeletonWarrior extends Enemy {

    public SkeletonWarrior() {
        super();
        damage=25;
        name="Skeleton warrior";
        defence=5;
        coinDrop=5;
        ExperianceDrop=10;
        health=100;
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
        System.out.println("Enemy hit you with with Sword");
        Random rnd=new Random();
        int damage= this.damage+ rnd.nextInt(30);
        hero.setHealth(hero.getHealth()-damage);
        System.out.println("you lost " +damage  + " health");

        hero.setHealth(hero.getHealth()-3);
    }


}
