package heroes;


import weapons.Bow;
import weapons.Weapon;


public class Archer extends Hero  {

    public Archer(String name, char sex, String race, int size) {
        super();

        description = "Archer- a range fighter who uses bows  as a primary weapon " +
                "and can pinpoint enemies weakness (Analyze).";
        health = 170;
        defence = 100;
        weapon = new Bow();
        this.name = name;
        this.sex = sex;
        this.race = race;
        this.height = size;
    }


    @Override
    public void specialSkill() {
        System.out.println("Have an eagle vision");
    }

    @Override
    public void abilityAttack() {
        System.out.println("shooting whit magic arrow  from big distance ");
    }

    @Override
    public void secondAttack() {
        System.out.println("Arrow rain ");
    }

    @Override
    public void weaponAttack(Weapon weapon) {
        System.out.println("Fast attacks with bow");
    }

    @Override
    public void defence() {
        System.out.println("dodging enemy attacks");
    }

    @Override
    public void jump() {
        System.out.println("Can jump high distance ");
    }
}
