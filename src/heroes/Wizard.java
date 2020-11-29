package heroes;


import weapons.Staff;
import weapons.Weapon;


public class Wizard extends Hero  {
    public Wizard(String name, char sex, String race, int size) {
        super();

        description = "a strong spell caster specialize in long range magic attacks.";
        health = 100;
        defence = 70;
        weapon = new Staff();
        this.name = name;
        this.sex = sex;
        this.race = race;
        this.height = size;
    }

    @Override
    public void specialSkill() {
        System.out.println("Strong magic attacks");
    }

    @Override
    public void abilityAttack() {
        System.out.println("Throws fireball to enemy");
    }

    @Override
    public void secondAttack() {
        System.out.println("Calls strong lightning storm to kill his enemies ");
    }

    @Override
    public void weaponAttack(Weapon weapon) {
        System.out.println("Shooting enemies with secret magic power");

    }

    @Override
    public void defence() {
        System.out.println("Magical barrier ");
    }

    @Override
    public void jump() {
        System.out.println("Can teleport for short distance");
    }
}
