package enemy;

import heroes.Hero;

import java.util.Random;

public class Dragon extends Enemy{

    public Dragon() {
        super();
        damage=100;
        name="Dragon";
        defence=200;
        coinDrop=150;
        ExperianceDrop=190;
        health=420  ;
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
        System.out.println("Enemy hit you with with elemental magic");
        Random rnd=new Random();
        int damage= this.damage+ rnd.nextInt(70);
        hero.setHealth(hero.getHealth()-damage);
        System.out.println("you lost " +damage  + " health");
        if(hero.getWeapon().getDamage()>15)
            hero.getWeapon().setDamage(hero.getWeapon().getDamage()-15);
        if(hero.getDefence()>10)
            hero.setDefence(hero.getDefence()-10);
    }





}
