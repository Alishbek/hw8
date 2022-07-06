package com.alishbek.players;

import com.alishbek.general.RPG_Game;

public class Warrior extends Hero{

    public Warrior(int health, int damage, String heroName) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE, heroName);
    }
    public int randomNumberWar = RPG_Game.random.nextInt(3)+2;
    @Override
    public void useSuperAbility(Hero[] heroes, Boss boss) {
        if (boss.getHealth() < getDamage()*randomNumberWar){
            boss.setHealth(0);
        } else {
            boss.setHealth(boss.getHealth()-getDamage()*randomNumberWar);
        }

    }
}
