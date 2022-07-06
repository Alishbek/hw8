package com.alishbek.players;

public abstract class Hero extends GameEntity implements HavingSuperAbility{
    private SuperAbility superAbility;
    private String heroName;

    public SuperAbility getSuperAbility() {
        return superAbility;
    }

    public void setSuperAbility(SuperAbility superAbility) {
        this.superAbility = superAbility;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public Hero(int health, int damage, SuperAbility superAbility, String heroName) {
        super(health, damage);
        this.superAbility=superAbility;
        this.heroName=heroName;
    }
}
