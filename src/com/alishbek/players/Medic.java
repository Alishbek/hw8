package com.alishbek.players;

public class Medic extends Hero{
    private int healPoints;

    public int getHealPoints() {
        return healPoints;
    }

    public void setHealPoints(int healPoints) {
        this.healPoints = healPoints;
    }

    public Medic(int health, int damage, String heroName, int healPoints) {
        super(health, damage, SuperAbility.HEAL, heroName);
        this.healPoints=healPoints;
    }

    @Override
    public void useSuperAbility(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if(heroes[i].getHealth()>0&&heroes[i].getHeroName()!=this.getHeroName()){
                heroes[i].setHealth(heroes[i].getHealth()+this.healPoints);
            }
        }
    }
}
