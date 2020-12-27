package heroes;

import actions.Abilities;
import actions.HeroSkill;
import actions.Life;
import actions.Movements;
import enemy.Enemy;
import fileService.SaveHeroesService;
import weapons.Weapon;



abstract public class Hero implements Abilities<Enemy>, Movements, Life, HeroSkill,Comparable<Hero> {

    int id;
    int playerPositionX=1;
    int playerPositionY=1;
    int coins=0;
    int level=0;
    char sex;
    String name;
    String race;
    int height;
    int abilityCastCount;
    int experience =0;
    int baseDamage=15;
    int health;
    int defence;


    Weapon weapon;

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

    public   int getHealth() {
        return health;
    }

    public   int getDefence() {
        return defence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getPlayerPositionX() {
        return playerPositionX;
    }

    public void setPlayerPositionX(int playerPositionX) {
        this.playerPositionX = playerPositionX;
    }

    public int getPlayerPositionY() {
        return playerPositionY;
    }

    public void setPlayerPositionY(int playerPositionY) {
        this.playerPositionY = playerPositionY;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAbilityCastCount() {
        return abilityCastCount;
    }

    public void setAbilityCastCount(int abilityCastCount) {
        this.abilityCastCount = abilityCastCount;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public static String getDescription() {
        return description;
    }





    public String print() {
        return
                "name=" + name +
                ", coins=" + coins +
                ", level=" + level +
                ", abilityCastCount=" + abilityCastCount +
                ", experience=" + experience +
                ", baseDamage=" + baseDamage +
                ", health=" + health +
                ", defence=" + defence;
    }

    public boolean gameOver()
    {
        return health <= 0;
    }
    @Override
    public void abilityAttack(Enemy enemy) {
        if(abilityCastCount>0) {
            System.out.println("You hit the enemy with ability");
            int damage = (baseDamage + weapon.getDamage());
            System.out.println("Enemy lost " + damage + " health");
            enemy.setHealth(enemy.getHealth() - damage);
            abilityCastCount--;
        }
    }
    @Override
    public int compareTo(Hero o2) {
        return this.getLevel()-o2.getLevel();
    }


}
