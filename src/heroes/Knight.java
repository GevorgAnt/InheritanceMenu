package heroes;



import weapons.SwordAndShield;
import weapons.Weapon;

public class Knight extends Hero {

    public Knight(String name, char sex, String race, int size) {
        super();

        description = "Knight- Defender of the weaks, specialize in melee combat, and use cover/guard " +
                "to defend those who are in danger.";
        health = 300;
        defence = 200;
        weapon = new SwordAndShield();
        this.name = name;
        this.sex = sex;
        this.race = race;
        this.height = size;
    }

    @Override
    public void specialSkill() {
        System.out.println("Give some protection points to allies");
    }

    @Override
    public void abilityAttack() {
        System.out.println("Strong slash with sword");
    }

    @Override
    public void secondAttack() {
        System.out.println("stunning enemies with shield");
    }

    public void weaponAttack(Weapon weapon) {
        System.out.println("attack with sword and shield");
    }

    @Override
    public void defence() {
        System.out.println("block attacks with shield");
    }

    @Override
    public void jump() {
        System.out.println("To heavy to jump");
    }
}
