package heroes;



import weapons.Dagger;
import weapons.Weapon;

public class Thief extends Hero  {
    public Thief(String name, char sex, String race, int size) {
        super();

        description = "Thief- a fast fighter able to pickpocket the enemies to get rare items " +
                "from them and sometimes their own equipment to benefits the group. ";
        health = 120;
        defence = 150;
        weapon = new Dagger();
        this.name = name;
        this.sex = sex;
        this.race = race;
        this.height = size;
    }

    @Override
    public void specialSkill() {
        System.out.println("Critical attack from behind");
    }

    @Override
    public void abilityAttack() {
        System.out.println("Throw smoke bomb to run away");
    }

    @Override
    public void secondAttack() {
        System.out.println("Can go invisible");
    }

    @Override
    public void weaponAttack(Weapon weapon) {
        System.out.println("Fast attack with dagger");
    }

    @Override
    public void defence() {
        System.out.println("Can dodge enemy attacks");
    }

    @Override
    public void jump() {
        System.out.println("have very good acrobatic movements");
    }
}
