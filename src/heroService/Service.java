package heroService;

import heroes.*;


import java.util.Scanner;

public class Service {
    boolean confirm = false;
    String agree = "";
    int select;

    Scanner in = new Scanner(System.in);

    public Hero CreateHero() {
        Hero hr = null;
        System.out.println("Creating new Hero");
        System.out.println("---------------");
        System.out.println("Enter hero name");
        String name = in.nextLine();
        System.out.println("Enter hero sex m or f (by default m)");
        char sex = in.next().charAt(0);
        if (sex != 'm' && sex != 'f')
            sex = 'm';
        in.nextLine();
        System.out.println("Enter hero race (Any race you know)");
        String race = in.nextLine();
        System.out.println("Enter hero size(height) must be bigger from 100 and less 220 (150 by default)");
        int size;
        try {
            size = Integer.parseInt(in.nextLine());
            if (size < 100 || size>=220)
                size = 150;
        } catch (NumberFormatException e) {
            size = 150;
        }
        System.out.println("Select hero class 1-Archer ,2-Bard ,3-Knight, 4-Thief, 5-Wizard ");
        select = Integer.parseInt(in.nextLine());
        while (!confirm)
            switch (select) {
                case 1: {
                    if (ifConfirmHero(hr = new Archer(name, sex, race, size))) {
                        System.out.println("Select hero class 1-Archer ,2-Bard ,3-Knight, 4-Thief, 5-Wizard ");
                        select = Integer.parseInt(in.nextLine());
                    }
                    break;
                }

                case 2: {
                    if (ifConfirmHero(hr = new Bard(name, sex, race, size))) {
                        System.out.println("Select hero class 1-Archer ,2-Bard ,3-Knight, 4-Thief, 5-Wizard ");
                        select = Integer.parseInt(in.nextLine());
                    }
                    break;
                }
                case 3: {
                    if (ifConfirmHero(hr = new Knight(name, sex, race, size))) {
                        System.out.println("Select hero class 1-Archer ,2-Bard ,3-Knight, 4-Thief, 5-Wizard ");
                        select = Integer.parseInt(in.nextLine());
                    }
                    break;
                }
                case 4: {
                    if (ifConfirmHero(hr = new Thief(name, sex, race, size))) {
                        System.out.println("Select hero class 1-Archer ,2-Bard ,3-Knight, 4-Thief, 5-Wizard ");
                        select = Integer.parseInt(in.nextLine());
                    }
                    break;
                }
                case 5: {
                    if (ifConfirmHero(hr = new Wizard(name, sex, race, size))) {
                        System.out.println("Select hero class 1-Archer ,2-Bard ,3-Knight, 4-Thief, 5-Wizard ");
                        select = Integer.parseInt(in.nextLine());
                    }
                    break;
                }
                default: {
                    System.out.println("Select another number (1-5)");
                    select = Integer.parseInt(in.nextLine());
                    break;

                }
            }

        assert hr != null;
        System.out.println(hr.print());
        System.out.println("-------------------------");
        return hr;


    }

    public boolean ifConfirmHero(Hero hr) {
        System.out.println("---------------------");
        System.out.println(Hero.getDescription());
        System.out.println("*--You sure?--*");
        System.out.println("type yes if you sure");

        agree = in.next();
        in.nextLine();
        if (agree.equals("yes")) {

            confirm = true;
            return false;
        }

        return true;
    }



    public void heroAbilities(Hero hr)
    {
        System.out.println();
        System.out.println("----------------");
        System.out.println("Hero ability attack");
        hr.abilityAttack();
        System.out.println("-------------");
        System.out.println("Hero special skill");
        hr.specialSkill();
        System.out.println("-------------");
        System.out.println("Hero secondary skill");
        hr.secondAttack();
        System.out.println("-------------");
        System.out.println("Hero weapon attack");
        hr.weaponAttack(hr.getWeapon());
    }


}
