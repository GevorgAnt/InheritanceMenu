package enemy;

import heroes.Hero;

import java.util.Random;

public class DevilWolves extends Enemy {
    public DevilWolves() {
        super();
        damage=40;
        name="Devil Wolves";
        defence=5;
        coinDrop=20;
        ExperianceDrop=19;
        health=120;
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
        System.out.println("Enemy hit you with with fangs");
        Random rnd=new Random();
        int damage= this.damage+ rnd.nextInt(20);
        hero.setHealth(hero.getHealth()-damage);
        System.out.println("you lost " +damage  + " health");
        if(hero.getWeapon().getDamage()>3)
            hero.getWeapon().setDamage(hero.getWeapon().getDamage()-3);
        this.damage+=5;
    }


}
