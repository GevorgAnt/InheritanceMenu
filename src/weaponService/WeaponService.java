package weaponService;

import weapons.Weapon;

public class WeaponService {

    public void heroWeaponInfo(Weapon weapon)
    {
        System.out.println("--here is your hero`s weapon information--");
        System.out.println("Your Weapon is "+ weapon.getName());
        System.out.println("Your Weapon damage is "+ weapon.getDamage());
        System.out.println("Your Weapon range is "+ weapon.getRange());
        System.out.println("Your Weapon speed is "+ weapon.getSpeed());
    }


}
