package heroes;



import weapons.Lute;
import weapons.Weapon;


public class Bard extends Hero  {
    public Bard(String name, char sex, String race, int size) {
        super();

        description = "A musician who aids and support his allies and make them stronger (stats up and buffing up), and weaken the enemies " +
                "with spells and debuffs.";
        health = 250;
        defence = 120;
        weapon = new Lute();
        this.name = name;
        this.sex = sex;
        this.race = race;
        this.height = size;
    }

    @Override
    public void specialSkill() {
        System.out.println("Strong health regeneration");
    }

    @Override
    public void abilityAttack() {
        System.out.println("Healing allies ");
    }

    @Override
    public void secondAttack() {
        System.out.println("debuffing enemies making them slower and weaker");
    }


    public void weaponAttack(Weapon weapon) {
        System.out.println("Making protections for allies");
    }

    @Override
    public void defence() {
        System.out.println("Barrier for magical and physical attacks");
    }

    @Override
    public void jump() {
        System.out.println("Normal human jump");
    }

}
