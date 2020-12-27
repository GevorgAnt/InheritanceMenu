package weaponService;

import heroes.Hero;
import weapons.Weapon;

import java.util.Random;
import java.util.Scanner;

public class WeaponService {
    Random rnd=new Random();

    public void heroWeaponInfo(Weapon weapon)
    {
        System.out.println("--here is your hero`s weapon information--");
        System.out.println("Your Weapon is "+ weapon.getName());
        System.out.println("Your Weapon damage is "+ weapon.getDamage());

    }


    public void trade(Hero hero) {
        int chance=rnd.nextInt(100);
        if(chance>=60) {
            System.out.println("You met trader");
            System.out.println("You can upgrade your weapon if you have enough money");
            int cost = rnd.nextInt(120) + hero.getLevel() * 10;
            System.out.println("You need " + (cost) + " coin to upgrade");
            System.out.println("you have " + hero.getCoins() + " coins");
            System.out.println("Type 1 yo upgrade and 2 to leave the store(2 by default) ");
            int select = new Scanner(System.in).nextInt();
            if (select == 1) {
                if (hero.getCoins() >= cost) {
                    hero.setCoins(hero.getCoins() - cost);
                    hero.getWeapon().setDamage(hero.getWeapon().getDamage() + hero.getLevel() * 15);
                    System.out.println("Completed");
                } else {
                    System.out.println("You dont have enough money for that");
                }
            } else {
                System.out.println("good luck warrior");

            }
        }
        else
        {
            System.out.println("Way is clear");
        }

    }


}
