package heroes;

import actions.Abilities;
import actions.Movaments;
import weapons.Weapon;


abstract public class Hero implements Abilities, Movaments {

    String name;
    char sex;
    String race;
    int height;
    Weapon weapon;


    static int health;
    static int defence;
    static String description;

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public String getRace() {
        return race;
    }

    public int getHeight() {
        return height;
    }

    public  Weapon getWeapon() {
        return weapon;
    }

    public static int getHealth() {
        return health;
    }

    public static int getDefence() {
        return defence;
    }

    public static String getDescription() {
        return description;
    }


    public String print() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", race='" + race + '\'' +
                ", height=" + height +
                ", health=" + health + '\'' +
                ", defence=" + defence + '\'' +
                ", Weapon=" + weapon.getName() + "}";
    }


}
