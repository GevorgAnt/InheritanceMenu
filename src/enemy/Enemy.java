package enemy;

import actions.Abilities;
import heroes.Hero;

import java.util.Random;

abstract public class Enemy implements Abilities<Hero> {
    protected int damage;
    protected String name;
    protected int defence;
    protected int coinDrop;
    protected int ExperianceDrop;
    protected int health;

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    public int getDefence() {
        return defence;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getCoinDrop() {
        return coinDrop;
    }

    public boolean died() {
        return health < 0;
    }

    public int getExperianceDrop() {
        return ExperianceDrop;
    }



    public void setDamage(int damage) {
        this.damage = damage;
    }


}

